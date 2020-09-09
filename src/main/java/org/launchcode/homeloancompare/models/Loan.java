package org.launchcode.homeloancompare.models;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;


@Entity
public class Loan extends AbstractEntity{

    @Size(min = 3, max = 75, message = "Address must be between 3 and 75 characters")
    @NotEmpty(message = "Please enter property address")
    private String subjectProperty;

    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    @NotEmpty(message = "Please enter your name")
    private String borrowersName;

    @NotEmpty(message = "Please enter your email address")
    @Email(message = "Invalid Email")
    private String borrowersEmail;

    @NotNull(message = "Please enter your estimated credit score")
    @NumberFormat
    private Integer estimatedCreditScore;

    private Integer purchasePrice;

    private Integer homeOwnersInsurance;


    @ManyToOne
    @NotNull(message = "Occupancy Type is Required")
    private OccupancyCategory occupancyCategory;

    @ManyToOne
    @NotNull(message = "Property Type is Required")
    private PropertyCategory propertyCategory;

    @ManyToOne
    @NotNull(message = "Transaction Type is Required")
    private TransactionCategory transactionCategory;

    private Date closingDate;

    private Date firstPaymentDate;

    public Loan(String subjectProperty, String borrowersName, String borrowersEmail,
                Integer estimatedCreditScore, Integer purchasePrice, Integer homeOwnersInsurance,
                TransactionCategory transactionCategory, PropertyCategory propertyCategory, OccupancyCategory occupancyCategory, Date closingDate,
                Date firstPaymentDate) {
        this.subjectProperty = subjectProperty;
        this.borrowersName = borrowersName;
        this.borrowersEmail = borrowersEmail;
        this.estimatedCreditScore = estimatedCreditScore;
        this.purchasePrice = purchasePrice;
        this.homeOwnersInsurance = homeOwnersInsurance;
        this.occupancyCategory = occupancyCategory;
        this.propertyCategory = propertyCategory;
        this.transactionCategory = transactionCategory;
        this.closingDate = closingDate;
        this.firstPaymentDate = firstPaymentDate;
    }

    public Loan(){}

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

    public String getBorrowersEmail() {
        return borrowersEmail;
    }

    public void setBorrowersEmail(String borrowersEmail) {
        this.borrowersEmail = borrowersEmail;
    }

    public Integer getEstimatedCreditScore() {
        return estimatedCreditScore;
    }

    public void setEstimatedCreditScore(Integer estimatedCreditScore) {
        this.estimatedCreditScore = estimatedCreditScore;
    }

    public Integer getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(Integer purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Integer getHomeOwnersInsurance() {
        return homeOwnersInsurance;
    }

    public void setHomeOwnersInsurance(Integer homeOwnersInsurance) {
        this.homeOwnersInsurance = homeOwnersInsurance;
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

    public Date getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(Date closingDate) {
        this.closingDate = closingDate;
    }

    public Date getFirstPaymentDate() {
        return firstPaymentDate;
    }

    public void setFirstPaymentDate(Date firstPaymentDate) {
        this.firstPaymentDate = firstPaymentDate;
    }

    @Override
    public String toString() {
        return subjectProperty;
    }

}
