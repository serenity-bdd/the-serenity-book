package flyer;

public enum Status {
    Bronze(0), Silver(1000), Gold(5000), Platinum(10000);

    public final int requiredPoints;

    Status(int requiredPoints) {
        this.requiredPoints = requiredPoints;
    }
}
