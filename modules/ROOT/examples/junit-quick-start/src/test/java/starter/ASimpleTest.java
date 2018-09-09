package starter;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import starter.steps.MathWizSteps;

// tag::testcase[]
@RunWith(SerenityRunner.class)      // <1>
public class ASimpleTest {

    @Steps
    MathWizSteps michael;           // <2>

    @Test
    public void addingSums() {
        // Given
        michael.startsWith(1);       // <3>

        // When
        michael.adds(2);             // <3>

        // Then
        michael.shouldHave(3);       // <3>
    }
}
// end::testcase[]