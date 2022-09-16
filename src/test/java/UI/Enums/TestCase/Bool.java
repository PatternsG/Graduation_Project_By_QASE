package UI.Enums.TestCase;

import UI.Enums.BaseEnum;

public enum Bool implements BaseEnum {
    YES("Yes"), NO("No");

    private final String name;

    Bool(String name) {
        this.name = name;
    }

    public static Bool fromString(String text) {
        for (Bool b : Bool.values()) {
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
