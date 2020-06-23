package rest.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import rest.model.ReleasePlace;

import java.util.List;

public interface ReleasePlaceRepo extends MongoRepository<ReleasePlace,String> {
    List<ReleasePlace> findByMovieName(String name);
}
