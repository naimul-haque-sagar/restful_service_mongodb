package rest.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import rest.model.MovieDetails;

import java.util.Optional;

public interface MovieDetailsRepo extends MongoRepository<MovieDetails,String> {
     Optional<MovieDetails> findByMovieName(String name);
}
