package rest.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "movie-info-store")
public class MovieInfoStore {

    @Id
    private String id;
    private String name;
    private String about;
    private String director;
    private String producer;
    private Long budget;
    private String date;
}
