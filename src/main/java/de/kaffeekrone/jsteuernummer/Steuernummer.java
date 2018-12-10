package de.kaffeekrone.jsteuernummer;

public class Steuernummer {

    private final String steuernummer;
    private final Region region;

    /**
     *
     * @param steuernummer a german steuernummer
     * @throws SteuernummerException if the steuernummer is invalid
     */
    private Steuernummer(String steuernummer) throws SteuernummerException {
        this.steuernummer = steuernummer;
        Region tempRegion = null;
        for (Region region : Region.values()) {
            if (region.matchesRegion(steuernummer) || region.matchesCountry(steuernummer)) {
                tempRegion = region;
                break;
            }
        }
        if (tempRegion == null) {
            throw new SteuernummerException("No region could be determined for steuernummer " + steuernummer);
        }
        this.region = tempRegion;
    }

    /**
     *
     * @param steuernummer a german steuernummer
     * @param region the expected region
     * @throws SteuernummerException if the steuernummer is invalid or does not match against the region
     */
    private Steuernummer(String steuernummer, Region region) throws SteuernummerException {
        this.steuernummer = steuernummer;
        if (region.matchesRegion(steuernummer) || region.matchesCountry(steuernummer)) {
            this.region = region;
        } else {
            throw new SteuernummerException("Region (" + region + ") does not match with given steuernummer (" + steuernummer + ")");
        }
    }


    public String getSteuernummer() {
        return steuernummer;
    }

    public Region getRegion() {
        return region;
    }


    /**
     * Guesses the region, there are some pattern overlappings for examle TH and BY do both match for 151/815/08156
     * If you care for the region, be aware of such inconveniences.
     *
     * @param steuernummer a german steuernummer
     * @throws SteuernummerException if the supplied steuernummer is invalid
     * @return a Steuernummer instance
     */
    public static Steuernummer of(String steuernummer) throws SteuernummerException {
        return new Steuernummer(steuernummer);
    }

    /**
     * @param steuernummer a german steuernummer
     * @param region the expected region
     * @throws SteuernummerException if the supplied steuernummer is invalid for region
     * @return a Steuernummer instance
     */
    public static Steuernummer of(String steuernummer, Region region) throws SteuernummerException {
        return new Steuernummer(steuernummer, region);
    }
}
