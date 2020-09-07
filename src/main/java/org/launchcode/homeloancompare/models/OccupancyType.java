package org.launchcode.homeloancompare.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public enum OccupancyType {
    OWNER_OCCUPIED("Owner Occupied"),
    SECOND_HOME("Second Home"),
    NOO("Rental Property");

    @Id
    @GeneratedValue
    int id;
    private String displayName;

    OccupancyType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
