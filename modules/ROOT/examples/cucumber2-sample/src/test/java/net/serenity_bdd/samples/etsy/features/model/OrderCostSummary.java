package net.serenity_bdd.samples.etsy.features.model;

/**
 * Created by john on 13/11/14.
 */
public class OrderCostSummary {
    private final String name;
    private final double itemTotal;


    public OrderCostSummary(String name, double itemTotal) {
        this.name = name;
        this.itemTotal = itemTotal;

    }

    public String getName() {
        return name;
    }

    public double getItemTotal() {
        return itemTotal;
    }

}
