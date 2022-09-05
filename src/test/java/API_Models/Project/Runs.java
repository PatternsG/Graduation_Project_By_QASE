package API_Models.Project;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Runs {
    private int total;
    private int active;
}
