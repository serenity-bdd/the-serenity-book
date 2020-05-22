public class TestSteps {

    @Step
    public void initialization() {
        action();
    }

    @Step
    public void when_example_action_for(final int value) {
        action();
        Assert.assertTrue(true);
    }

    @Step
    public void then_example_result_should_be(final int value) {
        action();
        Assert.assertTrue(true);
    }

    private void action() {
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(50, 200));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
