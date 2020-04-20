package com.bridgelabz.java;

public class ModelAnalysisException extends  Exception{
    public enum ExceptionType{
        ENTERED_NULL,ENTERED_EMPTY,NO_SUCH_FIELD,NO_SUCH_METHOD,NO
    }

   public  ExceptionType type;

    public ModelAnalysisException(String message) {
        super(message);
    }

    public ModelAnalysisException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }

    public ModelAnalysisException(Throwable cause, ExceptionType type) {
        super(cause);
        this.type = type;
    }

    public ModelAnalysisException(String message, Throwable cause, ExceptionType type) {
        super(message, cause);
        this.type = type;
    }
}
