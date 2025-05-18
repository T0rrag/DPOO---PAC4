package edu.uoc.pac4;

public class DefaultDiscountStrategy implements DiscountStrategy {
    @Override
    public double getDiscount() {
        return 0.0;
    }
}
