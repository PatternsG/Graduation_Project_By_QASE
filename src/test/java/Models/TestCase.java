package Models;

import Enums.Common.Bool;
import Enums.Common.Severity;
import Enums.Test_case.*;
import lombok.Builder;
import lombok.Data;

@Builder
@Data

public class TestCase {
    private String title;
    private Status status;
    private String description;
    private String suite;
    private Severity severity;
    private Priority priority;
    private Type type;
    private Layer layer;
    private Bool isFlaky;
    private String milestone;
    private Behavior behavior;
    private AutomationStatus automationStatus;
    private String preConditions;
    private String postConditions;
}
