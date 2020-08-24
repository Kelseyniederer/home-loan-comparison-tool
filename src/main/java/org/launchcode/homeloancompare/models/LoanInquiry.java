package org.launchcode.homeloancompare.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;
public class LoanInquiry {

    private int id;
    private static int nextId = 1;


    @Size(min = 3, max = 75, message = "Address must be between 3 and 75 characters")
    @NotBlank
    private String subjectProperty;


    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    @NotBlank
    private String borrowersName;

    @NotBlank
    @Email(message = "Invalid Email")
    private String borrowersEmail;

    public LoanInquiry(String subjectProperty, String borrowersName, String borrowersEmail) {
        this.subjectProperty = subjectProperty;
        this.borrowersName = borrowersName;
        this.borrowersEmail = borrowersEmail;
        this.id = nextId;
        nextId++;
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

    public int getId() {
        return id;
    }

    public String getBorrowersEmail() {
        return borrowersEmail;
    }

    public void setBorrowersEmail(String borrowersEmail) {
        this.borrowersEmail = borrowersEmail;
    }

    @Override
    public String toString() {
        return subjectProperty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoanInquiry that = (LoanInquiry) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
