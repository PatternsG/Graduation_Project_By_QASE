package API_Models.Defect;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Tag {
    private String title;
    private int internal_id;
}
