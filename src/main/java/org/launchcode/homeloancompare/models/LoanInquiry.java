package org.launchcode.homeloancompare.models;



public class LoanInquiry {

    private String subjectProperty;

    public LoanInquiry(String subjectProperty) {
        this.subjectProperty = subjectProperty;
    }

    public String getSubjectProperty() {
        return subjectProperty;
    }

    public void setSubjectProperty(String subjectProperty) {
        this.subjectProperty = subjectProperty;
    }

    @Override
    public String toString() {
        return subjectProperty;
    }
}
