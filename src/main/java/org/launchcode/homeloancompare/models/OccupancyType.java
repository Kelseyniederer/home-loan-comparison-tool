package org.launchcode.homeloancompare.models;


public enum OccupancyType {
    OWNER_OCCUPIED("Owner Occupied"),
    SECOND_HOME("Second Home"),
    NOO("Rental Property");


    private String displayName;

    OccupancyType(String displayName) {
        this.displayName = displayName;

    }

    public String getDisplayName() {
        return displayName;
    }
}
