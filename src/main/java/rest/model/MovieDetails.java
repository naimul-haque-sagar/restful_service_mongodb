package rest.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.List;

@Data
@Document(collection = "MovieDetails")
public class MovieDetails {
    @Id
    private String id;
    private Instant created;
    private Instant lastUpdated;
    private String name;
    private String ratings;
    private String details;
    private String director;
//    private Artist artist;
//    private List<ReleasePlace> releasePlaceList;
}
