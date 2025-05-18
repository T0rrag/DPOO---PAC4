package edu.uoc.pac4;

public class PremiumDiscountStrategy implements DiscountStrategy {
    @Override
    public double getDiscount() {
        return 0.20;
    }
}
