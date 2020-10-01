package org.launchcode.homeloancompare.models;


import org.springframework.format.annotation.NumberFormat;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class LoanDetails extends AbstractEntity {

    @NotEmpty(message = "Please enter your email address")
    @Email(message = "Invalid Email")
    private String borrowersEmail;

    @OneToOne(mappedBy = "loanDetails")
    private Loan loan;

    @NotNull(message = "Please enter your estimated credit score")
    @NumberFormat
    private Integer estimatedCreditScore;

    private String occupancyType;

    private String transactionType;

    private String propertyType;

    private Integer purchasePrice;

    private Integer homeOwnersInsurance;

    private String closingDate;

    private String firstPaymentDate;

    public LoanDetails(@NotEmpty(message = "Please enter your email address") @Email(message = "Invalid Email") String borrowersEmail,
                       Loan loan, @NotNull(message = "Please enter your estimated credit score") Integer estimatedCreditScore,
                       String occupancyType, String transactionType, String propertyType, Integer purchasePrice, Integer homeOwnersInsurance
                        ,String closingDate, String firstPaymentDate) {
        this.borrowersEmail = borrowersEmail;
        this.loan = loan;
        this.estimatedCreditScore = estimatedCreditScore;
        this.occupancyType = occupancyType;
        this.transactionType = transactionType;
        this.propertyType = propertyType;
        this.purchasePrice = purchasePrice;
        this.homeOwnersInsurance = homeOwnersInsurance;
        this.closingDate = closingDate;
        this.firstPaymentDate = firstPaymentDate;
    }

    public LoanDetails() {
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

    public String getOccupancyType() {
        return occupancyType;
    }

    public void setOccupancyType(String occupancyType) {
        this.occupancyType = occupancyType;
    }

    public String getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(String closingDate) {
        String[] customDateArr = closingDate.split("-");
        String customDate = "";
        for (int i = 0; i < customDateArr.length; i++){
            customDate.concat(customDateArr[i]).concat("/");
        }
        this.closingDate = customDate;
    }

    public String getFirstPaymentDate() {
        return firstPaymentDate;
    }

    public void setFirstPaymentDate(String firstPaymentDate) {
        this.firstPaymentDate = closingDate;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }
}