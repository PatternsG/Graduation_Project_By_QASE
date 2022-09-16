package UI.Enums.TestRuns;

import UI.Enums.BaseEnum;

public enum UpdateSelected implements BaseEnum {
    ASSIGN("Assign"), UNASSIGN("Unassign"),
    REMOVE_FROM_RUN("Remove from run");

    private final String name;

    UpdateSelected(String name) {
        this.name = name;
    }

    public static UpdateSelected fromString(String text) {
        for (UpdateSelected b : UpdateSelected.values()) {
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
