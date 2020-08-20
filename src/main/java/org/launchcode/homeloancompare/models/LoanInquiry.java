package org.launchcode.homeloancompare.models;



public class LoanInquiry {

    private String subjectProperty;
    private String borrowersName;

    public LoanInquiry(String subjectProperty, String borrowersName) {
        this.subjectProperty = subjectProperty;
        this.borrowersName = borrowersName;
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

    @Override
    public String toString() {
        return subjectProperty;
    }
}
