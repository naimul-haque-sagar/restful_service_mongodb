package rest.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "ReleasePlace")
public class ReleasePlace {
    @Id
    private String id;
    private String movieName;
    private String city;
    private String country;
}
