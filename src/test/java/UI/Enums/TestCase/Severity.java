package UI.Enums.TestCase;

import UI.Enums.BaseEnum;

public enum Severity implements BaseEnum {

    NOT_SET("Not set"), BLOCKER("Blocker"), CRITICAL("Critical"),
    MAJOR("Major"), NORMAL("Normal"),
    MINOR("Minor"), TRIVIAL("Trivial");
    private final String name;

    Severity(String name) {
        this.name = name;
    }

    public static Severity fromString(String text) {
        for (Severity b : Severity.values()) {
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
