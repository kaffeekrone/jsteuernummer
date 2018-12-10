package de.kaffeekrone.jsteuernummer;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class SteuernummerTest {

    @Test
    public void testForNpe() {
        assertThatNullPointerException().isThrownBy(() -> Steuernummer.of(null));
    }

    @Test
    public void test() {
        String steuernummerStr = "151/815/08156";
        Steuernummer steuernummer = Steuernummer.of(steuernummerStr);

        assertThat(steuernummer.getSteuernummer()).isEqualTo(steuernummerStr);
        // this is the guessed region, TH does match too.
        assertThat(steuernummer.getRegion()).isEqualTo(Region.BY);
    }

    @Test
    public void testWithRegion() {
        String steuernummerStr = "151/815/08156";
        Steuernummer steuernummer = Steuernummer.of(steuernummerStr, Region.TH);

        assertThat(steuernummer.getSteuernummer()).isEqualTo(steuernummerStr);
        assertThat(steuernummer.getRegion()).isEqualTo(Region.TH);
    }

    @Test
    public void invalidSteuernummerForRegion() {
        assertThatThrownBy(() -> Steuernummer.of("133/8150/8159", Region.TH))
                .isInstanceOf(SteuernummerException.class)
                .hasMessage("Region (TH) does not match with given steuernummer (133/8150/8159)");
    }

    @Test
    public void invalidSteuernummer() {
        assertThatThrownBy(() -> Steuernummer.of("02133/8150/819"))
                .isInstanceOf(SteuernummerException.class)
                .hasMessage("No region could be determined for steuernummer 02133/8150/819");
    }

}