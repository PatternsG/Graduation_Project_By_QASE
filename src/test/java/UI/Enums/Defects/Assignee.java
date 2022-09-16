package UI.Enums.Defects;

import UI.Enums.BaseEnum;

public enum Assignee implements BaseEnum {
    UNASSIGNED("Unassigned"), KOVALEVSIY_IVAN("Kovalevskiy Ivan"),
    OLEG("Oleg");

    private String name;

    @Override
    public String getName() {
        return this.name;
    }

    public static Assignee fromString(String text) {
        for (Assignee b : Assignee.values()) {
            if (b.name.equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null;
    }

    Assignee(String name) {
        this.name = name;
    }
}
