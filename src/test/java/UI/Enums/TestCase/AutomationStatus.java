package UI.Enums.TestCase;

import UI.Enums.BaseEnum;

public enum AutomationStatus implements BaseEnum {
    NOT_AUTOMATED("Not automated"), TO_BE_AUTOMATED("To be automated"),
    AUTOMATED("Automated");

    private final String name;

    AutomationStatus(String name) {
        this.name = name;
    }

    public static AutomationStatus fromString(String text) {
        for (AutomationStatus b : AutomationStatus.values()) {
            if (b.name.equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null;
    }

    public String getName() {
        return this.name;
    }

}
