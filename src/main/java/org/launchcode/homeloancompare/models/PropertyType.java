package org.launchcode.homeloancompare.models;

public enum PropertyType {
    SFR("Single Family Residence"),
    TOWNHOUSE("Townhouse"),
    MULTI_FAM("Multiple-Family Residence"),
    CONDO("Condo");

    int id;
    private String displayName;

    PropertyType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
