package org.launchcode.homeloancompare.models;

public enum TransactionType {

    REFINANCE_RATE_AND_TERM("Refinance: Rate and Term"),
    REFINANCE_CASH_OUT("Refinance: Cash Out"),
    PURCHASE("Purchase");

    private final String displayName;

    TransactionType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
