package org.launchcode.homeloancompare.models;


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

    private String estimatedCreditScore;

    private String occupancyType;

    private String transactionType;

    private String propertyType;

    private Integer purchasePrice;

    private String zipCode;

    private Integer homeOwnersInsurance;

    private Integer realEstateInsurance;

    private String closingDate;

    private String firstPaymentDate;

    private Integer lenderFees;

    private Double interestRate;


    public LoanDetails(@NotEmpty(message = "Please enter your email address") @Email(message = "Invalid Email") String borrowersEmail,
                       Loan loan, @NotNull(message = "Please enter your estimated credit score") String estimatedCreditScore,
                       String transactionType, String propertyType, Integer purchasePrice, Integer homeOwnersInsurance
                        ,Double interestRate,String closingDate, String firstPaymentDate, String zipCode, Integer lenderFees, Integer realEstateInsurance) {
        this.borrowersEmail = borrowersEmail;
        this.loan = loan;
        this.estimatedCreditScore = estimatedCreditScore;
        this.transactionType = transactionType;
        this.propertyType = propertyType;
        this.purchasePrice = purchasePrice;
        this.homeOwnersInsurance = homeOwnersInsurance;
        this.closingDate = closingDate;
        this.firstPaymentDate = firstPaymentDate;
        this.realEstateInsurance = realEstateInsurance;
        this.zipCode = zipCode;
        this.lenderFees = lenderFees;
        this.interestRate = interestRate;
    }

    public LoanDetails() {
    }

    public String getBorrowersEmail() {
        return borrowersEmail;
    }

    public void setBorrowersEmail(String borrowersEmail) {
        this.borrowersEmail = borrowersEmail;
    }

    public String getEstimatedCreditScore() {
        return estimatedCreditScore;
    }

    public void setEstimatedCreditScore(String estimatedCreditScore) {
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

    public Double getInterestRate() { return interestRate; }

    public void setInterestRate(Double interestRate) { this.interestRate = interestRate; }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(String closingDate) {
        this.closingDate = closingDate;
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

    public Integer getLenderFees() {
        return lenderFees;
    }

    public void setLenderFees(Integer lenderFees) {
        this.lenderFees = lenderFees;
    }

    public Integer getRealEstateInsurance() {
        return realEstateInsurance;
    }

    public void setRealEstateInsurance(Integer realEstateInsurance) {
        this.realEstateInsurance = realEstateInsurance;
    }
}
