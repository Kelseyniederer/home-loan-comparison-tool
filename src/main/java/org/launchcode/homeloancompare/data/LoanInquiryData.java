package org.launchcode.homeloancompare.data;

import org.launchcode.homeloancompare.models.Loan;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class LoanInquiryData {


    private static final Map<Integer, Loan> loanInquires = new HashMap<>();


    public static Collection<Loan> getAll(){
        return loanInquires.values();
    }


    public static Loan getById(int id){
        return loanInquires.get(id);
    }


    public static void add(Loan loanInquiry){
        loanInquires.put(loanInquiry.getId(), loanInquiry);
    }


    public static void remove(int id){
        loanInquires.remove(id);
    }
}
