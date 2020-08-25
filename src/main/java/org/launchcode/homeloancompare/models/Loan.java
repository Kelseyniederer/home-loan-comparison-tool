package org.launchcode.homeloancompare.models;

import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.*;
import java.util.Objects;
public class Loan {

    private int id;
    private static int nextId = 1;


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

    public Loan(String subjectProperty, String borrowersName, String borrowersEmail,
                       Integer estimatedCreditScore, Integer purchasePrice, Integer homeOwnersInsurance) {
        this.subjectProperty = subjectProperty;
        this.borrowersName = borrowersName;
        this.borrowersEmail = borrowersEmail;
        this.estimatedCreditScore = estimatedCreditScore;
        this.purchasePrice = purchasePrice;
        this.homeOwnersInsurance = homeOwnersInsurance;
        this.id = nextId;
        nextId++;
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

    public int getId() {
        return id;
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

    @Override
    public String toString() {
        return subjectProperty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Loan that = (Loan) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
