package API_Models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorField {
    String field;
    String error;
}
