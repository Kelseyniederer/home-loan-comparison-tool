package org.launchcode.homeloancompare.data;

import org.launchcode.homeloancompare.models.LoanInquiry;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class LoanInquiryData {


    private static final Map<Integer, LoanInquiry> loanInquires = new HashMap<>();


    public static Collection<LoanInquiry> getAll(){
        return loanInquires.values();
    }


    public static LoanInquiry getById(int id){
        return loanInquires.get(id);
    }


    public static void add(LoanInquiry loanInquiry){
        loanInquires.put(loanInquiry.getId(), loanInquiry);
    }


    public static void remove(int id){
        loanInquires.remove(id);
    }
}
