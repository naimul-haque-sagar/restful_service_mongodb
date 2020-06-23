package rest.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Artists")
public class Artists {
    @Id
    private String id;
    private String movieName;
    private String director;
    private String actor;
    private String actress;
}
