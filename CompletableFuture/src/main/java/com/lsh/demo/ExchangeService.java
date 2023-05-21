package com.lsh.demo;

/**
 * @Author lishaohui
 * @Date 2023/5/21 22:25
 */
public class ExchangeService {

    public enum Money {
        EUR(7.5714),
        USD(7.0079);
        private  double rate;
        Money(double rate) {
            this.rate = rate;
        }
        public double getRate() {
            return rate;
        }
    }

    public static double getRate(double rate, double toRate) {
        return toRate;
    }

}
