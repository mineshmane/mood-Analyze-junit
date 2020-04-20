package com.bridgelabz.java;
import com.bridgelabz.java.ModelAnalysisException;

public class MoodAnalyzer {
    public String message;
    public MoodAnalyzer(String message){
        this.message=message;
    }

    public String AnalyzeMood(String message) throws ModelAnalysisException{

    this.message=message;
    return moodAnalys();
    }

    public String analyzeMood(String message) throws ModelAnalysisException {
        try{
            if (message.contains("sad")){
                System.out.println(" in else sad part"+message);

                return "SAD";
            }else {
                System.out.println(" in else Happy part"+message);
                return "HAPPY";
            }
        }catch (NullPointerException e){
            throw  new ModelAnalysisException(" minesh please Enter proper message  ");

        }
    }

    public String  moodAnalys() throws ModelAnalysisException{
       try{
           System.out.println(" length " +message.length());
           if (message.length()==0) {
               System.out.println("in emty" );
               throw new ModelAnalysisException("empty field ",ModelAnalysisException.ExceptionType.ENTERED_EMPTY);
           }
           if (message.contains("BAD")){
               System.out.println("in bad");
               return "BAD";
           }

           else{
               System.out.println("else part happy");
               return "HAPPY";
           }

       }catch (NullPointerException | ModelAnalysisException e){

           throw new ModelAnalysisException("please enter proper mood",ModelAnalysisException.ExceptionType.ENTERED_NULL);
       }

    }



}
