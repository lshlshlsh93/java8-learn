package com.lsh.demo;

/**
 * @Author lishaohui
 * @Date 2023/5/21 21:50
 */
public class Discount {

    public enum Code {
        NONE(0),
        SLAVER(5),
        GOLD(10),
        PLATINUM(15),
        DIAMOND(20)
        ;

        private final int percentage;

        Code(int percentage) {
            this.percentage = percentage;
        }
    }

    public static String applyDiscountIntoProduct(Quote quote) {
        return quote.getShopName() + " price is : " + Discount.apply(quote.getPrice(), quote.getDiscountCode());
    }



    private static double apply(double price, Code code) {
        try {
            Thread.sleep(1_000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return price * (100 - code.percentage) / 100;
    }

}
