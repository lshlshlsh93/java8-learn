package com.lsh.design.strategy;

/**
 * @Author lishaohui
 * @Date 2023/5/19 12:05
 */
public class ValidatorClient {

    private final ValidationStrategy<String> validationStrategy;

    public ValidatorClient(ValidationStrategy<String> validationStrategy) {
        this.validationStrategy = validationStrategy;
    }

    public boolean validate(String s) {
        return validationStrategy.execute(s);
    }

    public static void main(String[] args) {
        ValidatorClient numericValidator = new ValidatorClient(new IsNumeric());
        System.out.println("numericValidator.validate(\"aaaa\") = " + numericValidator.validate("aaaa"));
        ValidatorClient lowerValidator = new ValidatorClient(new IsAllLowCase());
        System.out.println("lowerValidator.validate(\"bbb\") = " + lowerValidator.validate("aaaa"));

        ValidatorClient numValidator = new ValidatorClient((s)->s.matches("\\d+"));
        System.out.println("numValidator.validate(\"aaaa\") = " + numValidator.validate("aaaa"));
        ValidatorClient lowValidator = new ValidatorClient((s)->s.matches("[a-z]+"));
        System.out.println("lowValidator.validate(\"bbb\") = " + lowValidator.validate("aaaa"));
    }

}
