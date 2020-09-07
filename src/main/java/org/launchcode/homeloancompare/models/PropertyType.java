package org.launchcode.homeloancompare.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public enum PropertyType {
    SFR("Single Family Residence"),
    TOWNHOUSE("Townhouse"),
    MULTI_FAM("Multiple-Family Residence"),
    CONDO("Condo");

    @Id
    @GeneratedValue
    int id;
    private String displayName;

    PropertyType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
