package edu.hw2.Task4;

public class CallingInfoExtractor {
    private CallingInfoExtractor() {

    }

    private static final int MIN = 3;

    public static CallingInfo callingInfo() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace.length >= MIN) {
            StackTraceElement caller = stackTrace[2];
            String className = caller.getClassName();
            String methodName = caller.getMethodName();
            return new CallingInfo(className, methodName);
        } else {
            return null;
        }
    }

    public record CallingInfo(String className, String methodName) {
    }
}
