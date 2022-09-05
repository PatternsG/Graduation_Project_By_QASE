package Utils;

import Enums.Common.Bool;
import Enums.Common.Severity;
import Enums.Test_case.*;
import Models.TestCase;

public class TestCaseFactory {
    private static final String TEST_SUITE = "Test Suite";
    private static final String TEST_MILESTONE = "Test Milestone";

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
                .milestone(TEST_MILESTONE)
                .automationStatus(AutomationStatus.AUTOMATED)
                .preConditions("Valid registered user should exist")
                .postConditions("User logged out the system")
                .build();
    }
}
