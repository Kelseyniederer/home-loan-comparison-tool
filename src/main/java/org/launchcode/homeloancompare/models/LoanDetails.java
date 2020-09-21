package org.launchcode.homeloancompare.models;


import org.springframework.format.annotation.NumberFormat;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

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

    private Integer purchasePrice;

    private Integer homeOwnersInsurance;

    private Date closingDate;

    private Date firstPaymentDate;

    public LoanDetails(@NotEmpty(message = "Please enter your email address") @Email(message = "Invalid Email") String borrowersEmail, @NotNull(message = "Please enter your estimated credit score") Integer estimatedCreditScore, Integer purchasePrice, Integer homeOwnersInsurance, Date closingDate, Date firstPaymentDate) {
        this.borrowersEmail = borrowersEmail;
        this.estimatedCreditScore = estimatedCreditScore;
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
}