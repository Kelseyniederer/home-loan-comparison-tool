package org.launchcode.homeloancompare.models;

import java.util.ArrayList;

public class LoanData {


    /**
     * Returns the results of searching the Jobs data by field and search term.
     *
     * For example, searching for employer "Enterprise" will include results
     * with "Enterprise Holdings, Inc".
     *
     * @param column Job field that should be searched.
     * @param value Value of the field to search for.
     * @param allLoans The list of jobs to search.
     * @return List of all jobs matching the criteria.
     */
    public static ArrayList<Loan> findByColumnAndValue(String column, String value, Iterable<Loan> allLoans) {

        ArrayList<Loan> results = new ArrayList<>();

        if (value.toLowerCase().equals("all")){
            return (ArrayList<Loan>) allLoans;
        }

        if (column.equals("all")){
            results = findByValue(value, allLoans);
            return results;
        }
        for (Loan loan : allLoans) {

            String aValue = getFieldValue(loan, column);

            if (aValue != null && aValue.toLowerCase().contains(value.toLowerCase())) {
                results.add(loan);
            }
        }

        return results;
    }

    public static String getFieldValue(Loan loan, String fieldName){
        String theValue;
        if (fieldName.equals("borrowersName")){
            theValue = loan.getBorrowersName();
        } else {
            theValue = loan.getSubjectProperty().toString();
        }

        return theValue;
    }

    /**
     * Search all Job fields for the given term.
     *
     * @param value The search term to look for.
     * @param allLoans The list of jobs to search.
     * @return      List of all jobs with at least one field containing the value.
     */
    public static ArrayList<Loan> findByValue(String value, Iterable<Loan> allLoans) {
        String lower_val = value.toLowerCase();

        ArrayList<Loan> results = new ArrayList<>();

        for (Loan loan : allLoans) {

            if (loan.getBorrowersName().toLowerCase().contains(lower_val)) {
                results.add(loan);
            } else if (loan.getSubjectProperty().toString().toLowerCase().contains(lower_val)) {
                results.add(loan);
            } else {
                results.add(loan);
            }

        }

        return results;
    }


}
