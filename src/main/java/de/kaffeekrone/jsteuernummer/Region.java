package de.kaffeekrone.jsteuernummer;

import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum Region {

    // abbreviations from https://www.datendieter.de/item/Liste_Abkuerzungen_Bundeslaender
    /**
     * Baden Würtemberg
     */
    BW("^(?<ff>\\d{2})(?<bbb>\\d{3})[\\/](?<uuuu>\\d{4})(?<p>\\d{1})$",
            "^28(?<ff>\\d{2})0(?<bbb>\\d{3})(?<uuuu>\\d{4})(?<p>\\d{1})$",
            matcher -> matcher.group("ff") + matcher.group("bbb") + "/" + matcher.group("uuuu") + matcher.group("p"),
            matcher -> "28" + matcher.group("ff") + "0" + matcher.group("bbb") + matcher.group("uuuu") + matcher.group("p")),
    /**
     * Bayern
     */
    BY("^(?<fff>\\d{3})[/](?<bbb>\\d{3})[\\/](?<uuuu>\\d{4})(?<p>\\d{1})$",
            "^9(?<fff>\\d{3})0(?<bbb>\\d{3})(?<uuuu>\\d{4})(?<p>\\d{1})$",
            matcher -> matcher.group("fff") + "/" + matcher.group("bbb") + "/" + matcher.group("uuuu") + matcher.group("p"),
            matcher -> "9" + matcher.group("fff") + "0" + matcher.group("bbb") + matcher.group("uuuu") + matcher.group("p")),
    /**
     * Berlin
     */
    BE("^(?<ff>\\d{2})[\\/](?<bbb>\\d{3})[\\/](?<uuuu>\\d{4})(?<p>\\d{1})$",
            "^11(?<ff>\\d{2})0(?<bbb>\\d{3})(?<uuuu>\\d{4})(?<p>\\d{1})$",
            matcher -> matcher.group("ff") + "/" + matcher.group("bbb") + "/" + matcher.group("uuuu") + matcher.group("p"),
            matcher -> "11" + matcher.group("ff") + "0" + matcher.group("bbb") + matcher.group("uuuu") + matcher.group("p")),
    BB("^0(?<ff>\\d{2})[\\/](?<bbb>\\d{3})[\\/](?<uuuu>\\d{4})(?<p>\\d{1})$",
            "^30(?<ff>\\d{2})0(?<bbb>\\d{3})(?<uuuu>\\d{4})(?<p>\\d{1})$",
            matcher -> "0" + matcher.group("ff") + "/" + matcher.group("bbb") + "/" + matcher.group("uuuu") + matcher.group("p"),
            matcher -> "30" + matcher.group("ff") + "0" + matcher.group("bbb") + matcher.group("uuuu") + matcher.group("p")),
    /**
     * Bremen
     */
    HB("^(?<ff>\\d{2})\\s(?<bbb>\\d{3})\\s(?<uuuu>\\d{4})(?<p>\\d{1})$",
            "^24(?<ff>\\d{2})0(?<bbb>\\d{3})(?<uuuu>\\d{4})(?<p>\\d{1})$",
            matcher -> matcher.group("ff") + " " + matcher.group("bbb") + " " + matcher.group("uuuu") + matcher.group("p"),
            matcher -> "24" + matcher.group("ff") + "0" + matcher.group("bbb") + matcher.group("uuuu") + matcher.group("p")),
    HH("^(?<ff>\\d{2})[\\/](?<bbb>\\d{3})[\\/](?<uuuu>\\d{4})(?<p>\\d{1})$",
            "^22(?<ff>\\d{2})0(?<bbb>\\d{3})(?<uuuu>\\d{4})(?<p>\\d{1})$",
            matcher -> matcher.group("ff") + "/" + matcher.group("bbb") + "/" + matcher.group("uuuu") + matcher.group("p"),
            matcher -> "22" + matcher.group("ff") + "0" + matcher.group("bbb") + matcher.group("uuuu") + matcher.group("p")),
    /**
     * Hessen
     */
    HE("^0(?<ff>\\d{2})\\s(?<bbb>\\d{3})\\s(?<uuuu>\\d{4})(?<p>\\d{1})$",
            "^26(?<ff>\\d{2})0(?<bbb>\\d{3})(?<uuuu>\\d{4})(?<p>\\d{1})$",
            matcher -> "0" + matcher.group("ff") + " " + matcher.group("bbb") + " " + matcher.group("uuuu") + matcher.group("p"),
            matcher -> "26" + matcher.group("ff") + "0" + matcher.group("bbb") + matcher.group("uuuu") + matcher.group("p")),
    /**
     * Mecklenburg-Vorpommern
     */
    MV("^0(?<ff>\\d{2})[\\/](?<bbb>\\d{3})[\\/](?<uuuu>\\d{4})(?<p>\\d{1})$",
            "^40(?<ff>\\d{2})0(?<bbb>\\d{3})(?<uuuu>\\d{4})(?<p>\\d{1})$",
            matcher -> "0" + matcher.group("ff") + "/" + matcher.group("bbb") + "/" + matcher.group("uuuu") + matcher.group("p"),
            matcher -> "40" + matcher.group("ff") + "0" + matcher.group("bbb") + matcher.group("uuuu") + matcher.group("p")),
    /**
     * 	Niedersachsen
     */
    NI("^(?<ff>\\d{2})[\\/](?<bbb>\\d{3})[\\/](?<uuuu>\\d{4})(?<p>\\d{1})$",
            "^23(?<ff>\\d{2})0(?<bbb>\\d{3})(?<uuuu>\\d{4})(?<p>\\d{1})$",
            matcher -> matcher.group("ff") + "/" + matcher.group("bbb") + "/" + matcher.group("uuuu") + matcher.group("p"),
            matcher -> "23" + matcher.group("ff") + "0" + matcher.group("bbb") + matcher.group("uuuu") + matcher.group("p")),
    /**
     * Nordrhein-Westfalen
     */
    NW("^(?<fff>\\d{3})[\\/](?<bbbb>\\d{4})[\\/](?<uuu>\\d{3})(?<p>\\d{1})$",
            "^5(?<fff>\\d{3})0(?<bbbb>\\d{4})(?<uuu>\\d{3})(?<p>\\d{1})$",
            matcher -> matcher.group("fff") + "/" + matcher.group("bbbb") + "/" + matcher.group("uuu") + matcher.group("p"),
            matcher -> "5" + matcher.group("fff") + "0" + matcher.group("bbbb") + matcher.group("uuu") + matcher.group("p")),
    /**
     * Rheinland-Pfalz
     */
    RP("^(?<ff>\\d{2})[\\/](?<bbb>\\d{3})[\\/](?<uuuu>\\d{4})(?<p>\\d{1})$",
            "^27(?<ff>\\d{2})0(?<bbb>\\d{3})(?<uuuu>\\d{4})(?<p>\\d{1})$",
            matcher -> matcher.group("ff") + "/" + matcher.group("bbb") + "/" + matcher.group("uuuu") + matcher.group("p"),
            matcher -> "27" + matcher.group("ff") + "0" + matcher.group("bbb") + matcher.group("uuuu") + matcher.group("p")),
    /**
     * Saarland
     */
    SL("^0(?<ff>\\d{2})[\\/](?<bbb>\\d{3})[\\/](?<uuuu>\\d{4})(?<p>\\d{1})$",
            "^10(?<ff>\\d{2})0(?<bbb>\\d{3})(?<uuuu>\\d{4})(?<p>\\d{1})$",
            matcher -> "0" + matcher.group("ff") + "/" + matcher.group("bbb") + "/" + matcher.group("uuuu") + matcher.group("p"),
            matcher -> "10" + matcher.group("ff") + "0" + matcher.group("bbb") + matcher.group("uuuu") + matcher.group("p")),
    /**
     * Sachsen
     */
    SN("^2(?<ff>\\d{2})[\\/](?<bbb>\\d{3})[\\/](?<uuuu>\\d{4})(?<p>\\d{1})$",
            "^32(?<ff>\\d{2})0(?<bbb>\\d{3})(?<uuuu>\\d{4})(?<p>\\d{1})$",
            matcher -> "2" + matcher.group("ff") + "/" + matcher.group("bbb") + "/" + matcher.group("uuuu") + matcher.group("p"),
            matcher -> "32" + matcher.group("ff") + "0" + matcher.group("bbb") + matcher.group("uuuu") + matcher.group("p")),
    /**
     * 	Sachsen-Anhalt
     */
    ST("^1(?<ff>\\d{2})[\\/](?<bbb>\\d{3})[\\/](?<uuuu>\\d{4})(?<p>\\d{1})$",
            "^31(?<ff>\\d{2})0(?<bbb>\\d{3})(?<uuuu>\\d{4})(?<p>\\d{1})$",
            matcher -> "1" + matcher.group("ff") + "/" + matcher.group("bbb") + "/" + matcher.group("uuuu") + matcher.group("p"),
            matcher -> "31" + matcher.group("ff") + "0" + matcher.group("bbb") + matcher.group("uuuu") + matcher.group("p")),
    /**
     * 	Schleswig-Holstein
     */
    SH("^(?<ff>\\d{2})[\\/](?<bbb>\\d{3})[\\/](?<uuuu>\\d{4})(?<p>\\d{1})$",
            "^21(?<ff>\\d{2})0(?<bbb>\\d{3})(?<uuuu>\\d{4})(?<p>\\d{1})$",
            matcher -> matcher.group("ff") + "/" + matcher.group("bbb") + "/" + matcher.group("uuuu") + matcher.group("p"),
            matcher -> "21" + matcher.group("ff") + "0" + matcher.group("bbb") + matcher.group("uuuu") + matcher.group("p")),
    /**
     * 	Thüringen
     */
    TH("^1(?<ff>\\d{2})[\\/](?<bbb>\\d{3})[\\/](?<uuuu>\\d{4})(?<p>\\d{1})$",
            "^41(?<ff>\\d{2})0(?<bbb>\\d{3})(?<uuuu>\\d{4})(?<p>\\d{1})$",
            matcher -> "1" + matcher.group("ff") + "/" + matcher.group("bbb") + "/" + matcher.group("uuuu") + matcher.group("p"),
            matcher -> "41" + matcher.group("ff") + "0" + matcher.group("bbb") + matcher.group("uuuu") + matcher.group("p"));


    private final Pattern matchPatternRegion;
    private final Pattern matchPatternCountry;
    private final Function<Matcher, String> toRegionWideFunction;
    private final Function<Matcher, String> toCountryWideFunction;

    Region(String matchPatternRegion, String matchPatternCountry, Function<Matcher, String> toRegionWideFunction, Function<Matcher, String> toCountryWideFunction) {
        this.matchPatternRegion = Pattern.compile(matchPatternRegion);
        this.matchPatternCountry = Pattern.compile(matchPatternCountry);
        this.toRegionWideFunction = toRegionWideFunction;
        this.toCountryWideFunction = toCountryWideFunction;
    }

    public boolean matchesCountry(String steuernummer) {
        Matcher matcher = matchPatternCountry.matcher(steuernummer);

        return matcher.matches();
    }


    public boolean matchesRegion(String steuernummer) {
        Matcher matcher = matchPatternRegion.matcher(steuernummer);
        return matcher.matches();
    }


    public String toCountryWide(String steuernummer) {
        Matcher matcher = matchPatternRegion.matcher(steuernummer);

        if (matcher.matches()) {
            return toCountryWideFunction.apply(matcher);
        } else {
            throw new IllegalArgumentException("Steuernummer from the wrong region");
        }
    }

    public String toRegionWide(String steuernummer) {
        Matcher matcher = matchPatternCountry.matcher(steuernummer);

        if (matcher.matches()) {
            return toRegionWideFunction.apply(matcher);
        } else {
            throw new IllegalArgumentException("Steuernummer is not a country wide one");
        }
    }
}
