package org.launchcode.homeloancompare.models;

import javax.validation.constraints.Size;
import java.util.Objects;
public class LoanInquiry {

    private int id;
    private static int nextId = 1;

    @Size
    private String subjectProperty;
    private String borrowersName;

    public LoanInquiry(String subjectProperty, String borrowersName) {
        this.subjectProperty = subjectProperty;
        this.borrowersName = borrowersName;
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
