package UI.Enums.TestCase;

import UI.Enums.BaseEnum;

public enum Priority implements BaseEnum {
    HIGH("High"), MEDIUM("Medium"), LOW("Low");

    private final String name;

    Priority(String name) {
        this.name = name;
    }

    public static Priority fromString(String text) {
        for (Priority b : Priority.values()) {
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
