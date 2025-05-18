package edu.uoc.pac4;

public class Main {
    public static void main(String[] args) {
        System.out.println(DiscountCalculator.calculateDiscount(100, "VIP"));      // 30.0
        System.out.println(DiscountCalculator.calculateDiscount(100, "Premium"));  // 20.0
        System.out.println(DiscountCalculator.calculateDiscount(100, "Regular"));  // 10.0
        System.out.println(DiscountCalculator.calculateDiscount(100, "Other"));    // 0.0
    }
}
