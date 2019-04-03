package ie.tudublin;

import processing.data.TableRow;

public class Specs
{
    private String version;
    private  String corps;
    private String features;

    public Specs(TableRow row)
    {
        this.version = row.getString("Version");
        this.corps = row.getString("Oron Corps");
        this.features = row.getString("Specifications Features");
    }
}