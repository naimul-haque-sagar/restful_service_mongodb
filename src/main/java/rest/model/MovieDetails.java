package rest.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Data
@Document(collation = "MovieDetails")
public class MovieDetails {
    @Id
    private String id;
    private Instant created;
    private Instant lastUpdated;
    private String name;
    private String ratings;
    private String details;
    private String director;
}
