package rest.controller.restApi;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rest.dto.MovieDetailsDto;
import rest.service.MovieDetailsService;

import java.util.List;

@RestController
@RequestMapping("mongo/movieDetails")
@AllArgsConstructor
public class MovieDetailsController {
    private final MovieDetailsService movieDetailsService;

    @PostMapping("postMovieDetails")
    public ResponseEntity saveMovieDetails(@RequestBody MovieDetailsDto movieDetailsDto){
        movieDetailsService.saveMovieDetails(movieDetailsDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("getMovieDetails")
    public ResponseEntity<List<MovieDetailsDto>> getAllMovieDetails(){
        return ResponseEntity.status(HttpStatus.OK).body(movieDetailsService.getAllMovieDetails());
    }

    @GetMapping("getMovieDetailsById/{id}")
    public ResponseEntity<MovieDetailsDto> findById(@PathVariable String id){
        return ResponseEntity.status(HttpStatus.OK).body(movieDetailsService.findById(id));
    }

    @GetMapping("getMovieDetailsByName/{name}")
    public MovieDetailsDto findByName(@PathVariable String name){
        return movieDetailsService.findByName(name);
    }

    @PutMapping("updateMovieDetailsById/{id}")
    public ResponseEntity updateMovieDetails(@RequestBody MovieDetailsDto movieDetailsDto, @PathVariable String id){
        movieDetailsService.updateMovieDetails(movieDetailsDto,id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("deleteMovieDetailsById/{id}")
    public ResponseEntity deleteMovieDetails(@PathVariable String id){
        movieDetailsService.deleteMovieDetails(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
