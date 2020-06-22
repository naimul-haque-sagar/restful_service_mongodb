package rest.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import rest.dto.MovieDetailsDto;
import rest.exception.AppException;
import rest.mapper.MovieDetailsMapper;
import rest.model.MovieDetails;
import rest.repo.MovieDetailsRepo;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MovieDetailsService {
    private final MovieDetailsRepo movieDetailsRepo;

    private final MovieDetailsMapper movieDetailsMapper;

    public List<MovieDetailsDto> getAllMovieDetails() {
        return movieDetailsRepo.findAll().stream()
                .map(movieDetailsMapper::toDto).collect(Collectors.toList());
    }

    public void saveMovieDetails(MovieDetailsDto movieDetailsDto) {
        movieDetailsRepo.save(movieDetailsMapper.toModel(movieDetailsDto));
    }

    public MovieDetailsDto findById(String id) {
        return movieDetailsMapper.toDto(movieDetailsRepo.findById(id)
                .orElseThrow(()->new AppException("Error occurred finding movie details by id")));
    }

    public MovieDetailsDto findByName(String name) {
        return movieDetailsMapper.toDto(movieDetailsRepo.findByName(name)
                .orElseThrow(()->new AppException("Error occurred finding movie details by name")));
    }

    public void updateMovieDetails(MovieDetailsDto movieDetailsDto, String id) {
        MovieDetails response=movieDetailsRepo.findById(id).orElseThrow(()->new AppException("Didn't find any movie details"));
        response.setName(movieDetailsDto.getName());
        response.setDetails(movieDetailsDto.getDetails());
        response.setDirector(movieDetailsDto.getDirector());
        response.setRatings(movieDetailsDto.getRatings());
        response.setLastUpdated(java.time.Instant.now());

        movieDetailsRepo.save(response);
    }

    public void deleteMovieDetails(String id) {
        movieDetailsRepo.deleteById(id);
    }
}
