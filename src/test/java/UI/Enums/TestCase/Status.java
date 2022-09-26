package UI.Enums.TestCase;

import UI.Enums.BaseEnum;

public enum Status implements BaseEnum {

    ACTUAL("Actual"), DRAFT("Draft"), DEPRECATED("Deprecated");

    private final String name;

    Status(String name) {
        this.name = name;
    }

    public static Status fromString(String text) {
        for (Status b : Status.values()) {
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
