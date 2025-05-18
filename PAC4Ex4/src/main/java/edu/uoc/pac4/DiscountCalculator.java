package edu.uoc.pac4;

public class DiscountCalculator {

    public static DiscountStrategy getStrategy(String customerType) {
        if (customerType == null) {
            return new DefaultDiscountStrategy();
        }
        switch (customerType.trim().toUpperCase()) {
            case "VIP":
                return new VipDiscountStrategy();
            case "PREMIUM":
                return new PremiumDiscountStrategy();
            case "REGULAR":
                return new RegularDiscountStrategy();
            default:
                return new DefaultDiscountStrategy();
        }
    }

    public static double calculateDiscount(double price, String customerType) {
        DiscountStrategy strategy = getStrategy(customerType);
        return price * strategy.getDiscount();
    }
}
