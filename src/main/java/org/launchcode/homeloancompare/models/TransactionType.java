package org.launchcode.homeloancompare.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public enum TransactionType {

    REFINANCE_RATE_AND_TERM("Refinance: Rate and Term"),
    REFINANCE_CASH_OUT("Refinance: Cash Out"),
    PURCHASE("Purchase");

    @Id
    @GeneratedValue
    int id;
    private final String displayName;

    TransactionType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
