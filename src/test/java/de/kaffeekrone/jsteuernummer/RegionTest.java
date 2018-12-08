package de.kaffeekrone.jsteuernummer;

import org.apache.commons.lang3.tuple.Triple;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static de.kaffeekrone.jsteuernummer.Region.*;
import static org.assertj.core.api.Assertions.assertThat;

public class RegionTest {


    private List<Triple<Region, String, String>> testEntries;

    @Before
    public void setUp() {
        // entries from https://de.wikipedia.org/wiki/Steuernummer
        testEntries = new ArrayList<>();
        testEntries.add(Triple.of(BW, "93815/08152", "2893081508152"));
        testEntries.add(Triple.of(BY, "181/815/08155", "9181081508155"));
        testEntries.add(Triple.of(BE, "21/815/08150", "1121081508150"));
        testEntries.add(Triple.of(BB, "048/815/08155", "3048081508155"));
        testEntries.add(Triple.of(HB, "75 815 08152", "2475081508152"));
        testEntries.add(Triple.of(HH, "02/815/08156", "2202081508156"));
        testEntries.add(Triple.of(HE, "013 815 08153", "2613081508153"));
        testEntries.add(Triple.of(MV, "079/815/08151", "4079081508151"));
        testEntries.add(Triple.of(NI, "24/815/08151", "2324081508151"));
        testEntries.add(Triple.of(NW, "133/8150/8159", "5133081508159"));
        testEntries.add(Triple.of(RP, "22/815/08154", "2722081508154"));
        testEntries.add(Triple.of(SL, "010/815/08182", "1010081508182"));
        testEntries.add(Triple.of(SN, "201/123/12340", "3201012312340"));
        testEntries.add(Triple.of(ST, "101/815/08154", "3101081508154"));
        testEntries.add(Triple.of(SH, "29/815/08158", "2129081508158"));
        testEntries.add(Triple.of(TH, "151/815/08156", "4151081508156"));
    }


    @Test
    public void matchesRegion() {
        for (Triple<Region, String, String> testEntry : testEntries) {
            assertThat(testEntry.getLeft().matchesCountry(testEntry.getRight())).isTrue();
        }
    }

    @Test
    public void matchesCountry() {
        for (Triple<Region, String, String> testEntry : testEntries) {
            assertThat(testEntry.getLeft().matchesCountry(testEntry.getRight())).isTrue();
        }
    }

    @Test
    public void toCountryWide() {
        for (Triple<Region, String, String> testEntry : testEntries) {
            assertThat(testEntry.getLeft().toCountryWide(testEntry.getMiddle())).isEqualTo(testEntry.getRight());
        }
    }

    @Test
    public void toRegionWide() {
        for (Triple<Region, String, String> testEntry : testEntries) {
            assertThat(testEntry.getLeft().toRegionWide(testEntry.getRight())).isEqualTo(testEntry.getMiddle());
        }
    }
}