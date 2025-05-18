package edu.uoc.pac4;

public class VipDiscountStrategy implements DiscountStrategy {
    @Override
    public double getDiscount() {
        return 0.30;
    }
}
