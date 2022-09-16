package UI.Enums.TestCase;

import UI.Enums.BaseEnum;

public enum Layer implements BaseEnum {
    NOT_SET("Not set"), E2E("E2E"),
    API("API"), UNIT("Unit");

    private final String name;

    Layer(String name) {
        this.name = name;
    }

    public static Layer fromString(String text) {
        for (Layer b : Layer.values()) {
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
