package rest.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import rest.model.Artists;

import java.util.Optional;

public interface ArtistsRepo extends MongoRepository<Artists,String> {
    Optional<Artists> findByMovieName(String name);
}
