package API_Utils;

import API_Models.Project.Counts;
import API_Models.Project.Defects;
import API_Models.Project.Project;
import API_Models.Project.Runs;

public class ProjectFactory {
        public static Project getFirstProjectInfo() {
            return Project.builder()
                .code("DEMO")
                .title("Demo Project")
                .counts(Counts.builder()
                    .cases(Integer.parseInt("10"))
                    .suites(Integer.parseInt("3"))
                    .milestones(Integer.parseInt("0"))
                    .runs(Runs.builder().build())
                    .defects(Defects.builder().build())
                    .build())
                .build();
        }

    public static Project getSecondProjectInfo() {
        return Project.builder()
            .code("SHARELANE")
            .title("Ivan_Kovalevskiy")

            .counts(Counts.builder()
                    .cases(Integer.parseInt("7"))
                    .suites(Integer.parseInt("2"))
                    .milestones(Integer.parseInt("0"))
                .runs(Runs.builder().build())
                .defects(Defects.builder()
                    .total(Integer.parseInt("5"))
                    .open(Integer.parseInt("5"))
                    .build())
                .build())
            .build();
        }
    }
