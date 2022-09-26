package UI.Enums.TestCase;

import UI.Enums.BaseEnum;

public enum Type implements BaseEnum {
    OTHER("Other"), FUNCTIONAL("Functional"),
    SMOKE("Smoke"), REGRESSION("Regression"),
    SECURITY("Security"), USABILITY("Usability"),
    PERFORMANCE("Performance"), ACCEPTANCE("Acceptance"),
    COMPATIBILITY("Compatibility"), INTEGRATION("Integration"),
    EXPLORATORY("Exploratory");

    private final String name;

    Type(String name) {
        this.name = name;
    }

    public static Type fromString(String text) {
        for (Type b : Type.values()) {
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
