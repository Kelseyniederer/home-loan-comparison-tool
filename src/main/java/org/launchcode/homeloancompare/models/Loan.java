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

    private TransactionType transactionType;

    private PropertyType propertyType;

    @ManyToOne
    @NotNull(message = "Occupancy Type is Required")
    private OccupancyCategory occupancyCategory;

    private Date closingDate;

    private Date firstPaymentDate;

    public Loan(String subjectProperty, String borrowersName, String borrowersEmail,
                Integer estimatedCreditScore, Integer purchasePrice, Integer homeOwnersInsurance,
                TransactionType transactionType, PropertyType propertyType, OccupancyCategory occupancyCategory, Date closingDate,
                Date firstPaymentDate) {
        this.subjectProperty = subjectProperty;
        this.borrowersName = borrowersName;
        this.borrowersEmail = borrowersEmail;
        this.estimatedCreditScore = estimatedCreditScore;
        this.purchasePrice = purchasePrice;
        this.homeOwnersInsurance = homeOwnersInsurance;
        this.occupancyCategory = occupancyCategory;
        this.transactionType = transactionType;
        this.propertyType = propertyType;
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

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public PropertyType getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(PropertyType propertyType) {
        this.propertyType = propertyType;
    }

    public OccupancyCategory getOccupancyCategory() {
        return occupancyCategory;
    }

    public void setOccupancyCategory(OccupancyCategory occupancyCategory) {
        this.occupancyCategory = occupancyCategory;
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
