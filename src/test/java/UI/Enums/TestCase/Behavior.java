package UI.Enums.TestCase;

import UI.Enums.BaseEnum;

public enum Behavior implements BaseEnum {
    NOT_SET("Not set"), POSITIVE("Positive"),
    NEGATIVE("Negative"), DESTRUCTIVE("Destructive");

    private final String name;

    Behavior(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

}
