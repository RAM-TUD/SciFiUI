package ie.tudublin;

import processing.data.TableRow;

public class Specs
{
    private String version;
    private String corps;
    private String features;

    public Specs(TableRow row)
    {
        this.version = row.getString("Version");
        this.corps = row.getString("Cyberdene Systems");
        this.features = row.getString("Specification Features");
    }

    public String toString()
    {
        return version + "\t" + corps + "\t" + features;
    }

    /**
     * @return the version
     */
    public String getVersion() {
        return version;
    }

    /**
     * @param version the version to set
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * @return the corps
     */
    public String getCorps() {
        return corps;
    }

    /**
     * @param corps the corps to set
     */
    public void setCorps(String corps) {
        this.corps = corps;
    }

    /**
     * @return the features
     */
    public String getFeatures() {
        return features;
    }

    /**
     * @param features the features to set
     */
    public void setFeatures(String features) {
        this.features = features;
    }
}