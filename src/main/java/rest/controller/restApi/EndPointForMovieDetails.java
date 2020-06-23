package rest.controller.restApi;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rest.dto.MovieDetailsDto;
import rest.dto.MovieDetails_Dto;
import rest.exception.AppException;
import rest.model.Artists;
import rest.model.ReleasePlace;
import rest.repo.ArtistsRepo;
import rest.repo.ReleasePlaceRepo;
import rest.service.MovieDetailsService;

import java.util.List;

@RestController
@RequestMapping("mongo/movieDetails")
@AllArgsConstructor
public class EndPointForMovieDetails {
    private final MovieDetailsService movieDetailsService;

    private final ArtistsRepo artistsRepo;

    private final ReleasePlaceRepo releasePlaceRepo;

    @PostMapping("postMovieDetails")
    public ResponseEntity saveMovieDetails(@RequestBody MovieDetails_Dto movieDetails_Dto){
        System.out.println("posted");
        Artists artists=artistsRepo.findByMovieName(movieDetails_Dto.getMovieName()).orElseThrow(()->new AppException("No artists found"));
        List<ReleasePlace> releasePlace=releasePlaceRepo.findByMovieName(movieDetails_Dto.getMovieName());

        MovieDetailsDto movieDetailsDto=new MovieDetailsDto();
        movieDetailsDto.setMovieName(movieDetails_Dto.getMovieName());
        movieDetailsDto.setRatings(movieDetails_Dto.getRatings());
        movieDetailsDto.setArtists(artists);
        movieDetailsDto.setReleasePlaceList(releasePlace);

        movieDetailsService.saveMovieDetails(movieDetailsDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("getMovieDetails")
    public ResponseEntity<List<MovieDetailsDto>> getAllMovieDetails(){
        System.out.println("got");
        return ResponseEntity.status(HttpStatus.OK).body(movieDetailsService.getAllMovieDetails());
    }

    @GetMapping("getMovieDetailsById/{id}")
    public ResponseEntity<MovieDetailsDto> findById(@PathVariable String id){
        System.out.println("got by id");
        return ResponseEntity.status(HttpStatus.OK).body(movieDetailsService.findById(id));
    }

    @GetMapping("getMovieDetailsByName/{name}")
    public MovieDetailsDto findByName(@PathVariable String name){
        System.out.println("got by name");
        return movieDetailsService.findByMovieName(name);
    }

    @PutMapping("updateMovieDetailsById/{id}")
    public ResponseEntity updateMovieDetails(@RequestBody MovieDetails_Dto movieDetails_Dto, @PathVariable String id){
        System.out.println("updated");
        movieDetailsService.updateMovieDetails(movieDetails_Dto,id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("deleteMovieDetailsById/{id}")
    public ResponseEntity deleteMovieDetails(@PathVariable String id){
        System.out.println("deleted");
        movieDetailsService.deleteMovieDetails(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
