package org.launchcode.homeloancompare.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class Loan extends AbstractEntity{


    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    @NotEmpty(message = "Please enter your name")
    private String borrowersName;

    @Size(min = 3, max = 75, message = "Address must be between 3 and 75 characters")
    @NotEmpty(message = "Please enter property address")
    private String subjectProperty;

    @OneToOne(cascade = CascadeType.ALL)
    @Valid
    @NotNull
    private LoanDetails loanDetails;


    public Loan(@Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters") @NotEmpty(message = "Please enter your name") String borrowersName, @Size(min = 3, max = 75, message = "Address must be between 3 and 75 characters") @NotEmpty(message = "Please enter property address") String subjectProperty, @Valid @NotNull LoanDetails loanDetails) {
        this.borrowersName = borrowersName;
        this.subjectProperty = subjectProperty;
        this.loanDetails = loanDetails;
    }

    public Loan() {
    }

    public String getSubjectProperty() {
        return subjectProperty;
    }

    public void setSubjectProperty(String subjectProperty) {
        this.subjectProperty = subjectProperty;
    }

    public String getBorrowersName() {
        return borrowersName;
    }

    public void setBorrowersName(String borrowersName) {
        this.borrowersName = borrowersName;
    }

    public LoanDetails getLoanDetails() {
        return loanDetails;
    }

    public void setLoanDetails(LoanDetails loanDetails) {
        this.loanDetails = loanDetails;
    }

    @Override
    public String toString() {
        return subjectProperty;
    }

}