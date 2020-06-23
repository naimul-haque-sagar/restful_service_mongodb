package rest.dto;

import lombok.Data;
import rest.model.Artists;
import rest.model.ReleasePlace;

import java.util.List;

@Data
public class MovieDetailsDto {
    private String movieName;
    private String ratings;
    private Artists artists;
    private List<ReleasePlace> releasePlaceList;
}
