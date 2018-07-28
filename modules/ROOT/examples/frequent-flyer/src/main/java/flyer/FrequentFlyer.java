package flyer;

import static java.util.Arrays.stream;
import static java.util.Comparator.reverseOrder;

public class FrequentFlyer {

    private int points;
    private Status status;

    public FrequentFlyer(int initialBalance) {
        this.points = initialBalance;
        this.status = Status.Bronze;
    }

    public static FrequentFlyer withInitialBalanceOf(int initialBalance) {
        return new FrequentFlyer(initialBalance);
    }

    public Status getStatus() {
        return status;
    }

    public void recordFlightDistanceInKilometers(int distance) {
        points = points + (distance / 10);

        reevaluateStatus();
    }

    private void reevaluateStatus() {
        status = stream(Status.values())
                        .filter(status -> points >= status.requiredPoints)
                        .sorted(reverseOrder())
                        .findFirst()
                        .orElse(Status.Bronze);
    }
}
