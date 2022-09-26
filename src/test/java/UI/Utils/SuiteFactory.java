package UI.Utils;

import UI.Models.Suite;

public class SuiteFactory {

    public static Suite getFullInfoSuite() {
        return Suite.builder()
                .suiteName("Smoke")
                .description("")
                .preconditions("")
                .build();
    }
}
