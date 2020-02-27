package com.bridgelabz.java;

public class MoodAnalyzer {

    public String happymood(String mood) {
        try{
            if (mood.equals("BAD"))
                return "BAD";
            else
                return "HAPPY";
        }catch (NullPointerException e){

            return  "HAPPY";
        }

    }

}
