package com.lsh.demo;

/**
 * @Author lishaohui
 * @Date 2023/5/21 21:50
 */
public class Quote {

    private final String shopName;

    private final double price;

    private final Discount.Code discountCode;

    public Quote(String shopName, double price, Discount.Code discountCode) {
        this.shopName = shopName;
        this.price = price;
        this.discountCode = discountCode;
    }

    public static Quote parse(String str){
        String[] strings = str.split(":");
        String shopName = strings[0];
        double price = Double.parseDouble(strings[1]);
        Discount.Code code = Discount.Code.valueOf(strings[2]);
        return new Quote(shopName,price,code);
    }

    public String getShopName() {
        return shopName;
    }

    public double getPrice() {
        return price;
    }

    public Discount.Code getDiscountCode() {
        return discountCode;
    }
}
