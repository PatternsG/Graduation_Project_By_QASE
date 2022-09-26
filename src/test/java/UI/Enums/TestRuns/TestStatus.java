package UI.Enums.TestRuns;

import UI.Enums.BaseEnum;

public enum TestStatus implements BaseEnum {
    PASSED("Passed"), FAILED("Failed"), BLOCKED("Blocked"),
    INVALID("Invalid"), SKIPPED("Skipped");
    private final String name;

    @Override
    public String getName() {
        return this.name;
    }

    TestStatus(String name) {
        this.name = name;
    }
}
