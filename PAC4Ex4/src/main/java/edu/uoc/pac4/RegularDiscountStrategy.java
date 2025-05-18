package edu.uoc.pac4;

public class RegularDiscountStrategy implements DiscountStrategy {
    @Override
    public double getDiscount() {
        return 0.10;
    }
}
