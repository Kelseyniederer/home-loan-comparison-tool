package org.launchcode.homeloancompare.models;
import javax.persistence.Entity;
import javax.validation.constraints.Size;

@Entity
public class OccupancyCategory extends AbstractEntity {

    @Size(min=3, message="Name must be at least 3 characters long")
    private String name;

    public OccupancyCategory(@Size(min = 3, message = "Name must be at least 3 characters long") String name) {
        this.name = name;
    }

    public OccupancyCategory() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}
