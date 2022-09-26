package UI.Utils;

import UI.Enums.TestCase.*;
import UI.Models.TestCase;

public class TestCaseFactory {
    private static final String TEST_SUITE = "Test Suite";

    public static TestCase getFullInfoTestCase() {
        return TestCase.builder()
                .title("Authorization")
                .description("Registered users can log in to the application " +
                        "using email and password.")
                .status(Status.DRAFT)
                .suite(TEST_SUITE)
                .severity(Severity.MAJOR)
                .priority(Priority.HIGH)
                .type(Type.ACCEPTANCE)
                .layer(Layer.E2E)
                .isFlaky(Bool.YES)
                .automationStatus(AutomationStatus.AUTOMATED)
                .preConditions("Valid registered user should exist")
                .postConditions("User logged out the system")
                .build();
    }
}
