package org.launchcode.homeloancompare.models;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
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

    @ManyToOne(cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull(message = "Occupancy Type is Required")
    private OccupancyCategory occupancyCategory;

    @ManyToOne(cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull(message = "Property Type is Required")
    private PropertyCategory propertyCategory;

    @ManyToOne(cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull(message = "Transaction Type is Required")
    private TransactionCategory transactionCategory;

    public Loan(@Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters") @NotEmpty(message = "Please enter your name") String borrowersName, @Size(min = 3, max = 75, message = "Address must be between 3 and 75 characters") @NotEmpty(message = "Please enter property address") String subjectProperty, @Valid @NotNull LoanDetails loanDetails, @NotNull(message = "Occupancy Type is Required") OccupancyCategory occupancyCategory, @NotNull(message = "Property Type is Required") PropertyCategory propertyCategory, @NotNull(message = "Transaction Type is Required") TransactionCategory transactionCategory) {
        this.borrowersName = borrowersName;
        this.subjectProperty = subjectProperty;
        this.loanDetails = loanDetails;
        this.occupancyCategory = occupancyCategory;
        this.propertyCategory = propertyCategory;
        this.transactionCategory = transactionCategory;
    }

    public Loan() {
    }

    public String getSubjectProperty() {
        return subjectProperty;
    }

    public void setSubjectProperty(String subjectProperty) {
        this.subjectProperty = subjectProperty;
    }

    public OccupancyCategory getOccupancyCategory() {
        return occupancyCategory;
    }

    public void setOccupancyCategory(OccupancyCategory occupancyCategory) {
        this.occupancyCategory = occupancyCategory;
    }

    public PropertyCategory getPropertyCategory() {
        return propertyCategory;
    }

    public void setPropertyCategory(PropertyCategory propertyCategory) {
        this.propertyCategory = propertyCategory;
    }

    public TransactionCategory getTransactionCategory() {
        return transactionCategory;
    }

    public void setTransactionCategory(TransactionCategory transactionCategory) {
        this.transactionCategory = transactionCategory;
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
