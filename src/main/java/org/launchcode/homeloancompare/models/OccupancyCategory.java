package org.launchcode.homeloancompare.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class OccupancyCategory extends AbstractEntity {

    @Size(min=3, message="Name must be at least 3 characters long")
    private String name;

    @OneToMany(mappedBy = "occupancyCategory", cascade = CascadeType.REMOVE)
    private final List<Loan> loans = new ArrayList<>();

    public OccupancyCategory(@Size(min = 3, message = "Name must be at least 3 characters long") String name) {
        this.name = name;
    }

    public OccupancyCategory() {}

    public String getName() {
        return name;
    }

    public List<Loan> getLoans() {
        return loans;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}