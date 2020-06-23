package rest.controller.restConsumer;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import rest.dto.MovieDetailsDto;
import rest.dto.MovieDetails_Dto;

@RestController
@RequestMapping("mongo/consumer")
@AllArgsConstructor
public class RestConsumer {
    private final WebClient.Builder webClientBuilder;

    static String GET_MOVIE_DETAILS_BY_ID="http://localhost:8080/mongo/movieDetails/getMovieDetailsById";
    static String GET_MOVIE_DETAILS_BY_NAME="http://localhost:8080/mongo/movieDetails/getMovieDetailsByName";
    static String GET_MOVIE_DETAILS="http://localhost:8080/mongo/movieDetails/getMovieDetails";
    static String DELETE_MOVIE_DETAILS_BY_ID="http://localhost:8080/mongo/movieDetails/deleteMovieDetailsById";
    static String UPDATE_MOVIE_DETAILS_BY_ID="http://localhost:8080/mongo/movieDetails/updateMovieDetailsById";
    static String POST_MOVIE_DETAILS="http://localhost:8080/mongo/movieDetails/postMovieDetails";

    @GetMapping("getMovieDetailsByid/{id}")
    public Mono<MovieDetailsDto> getMovieDetailsByid(@PathVariable String id){
        return webClientBuilder.build().get().uri(GET_MOVIE_DETAILS_BY_ID+"/"+id).retrieve().bodyToMono(MovieDetailsDto.class);
    }

    @GetMapping("getMovieDetailsByname/{name}")
    public Mono<MovieDetailsDto> getMovieDetailsByname(@PathVariable String name){
        return webClientBuilder.build().get().uri(GET_MOVIE_DETAILS_BY_NAME+"/"+name).retrieve().bodyToMono(MovieDetailsDto.class);
    }

    @GetMapping("getMovieDetails")
    public Flux<MovieDetailsDto> getAllMovieDetails(){
        return webClientBuilder.build().get().uri(GET_MOVIE_DETAILS).retrieve().bodyToFlux(MovieDetailsDto.class);
    }

    @PostMapping("postMovieDetails2")
    public Mono<MovieDetailsDto> postMovieDetails2(@RequestBody MovieDetails_Dto movieDetails_Dto){
        return webClientBuilder.build()
                .post().uri(POST_MOVIE_DETAILS).body(BodyInserters.fromValue(movieDetails_Dto)).retrieve().bodyToMono(MovieDetailsDto.class);
    }

    @PostMapping("postMovieDetails")
    public Mono<MovieDetailsDto> postMovieDetails(@RequestBody MovieDetails_Dto movieDetails_Dto){
        return webClientBuilder.build()
                .post().uri(POST_MOVIE_DETAILS).syncBody(movieDetails_Dto).retrieve().bodyToMono(MovieDetailsDto.class);
    }

    @PostMapping("postMovieDetails1")
    public Mono<String> postMovieDetails1(@RequestBody MovieDetails_Dto movieDetails_Dto){
        return webClientBuilder.build()
                .post().uri(POST_MOVIE_DETAILS).syncBody(movieDetails_Dto).retrieve().bodyToMono(String.class);
    }

    @PutMapping("updateMovieDetailsById/{id}")
    public Mono<MovieDetailsDto> updateMovieDetailsById(@PathVariable String id, @RequestBody MovieDetails_Dto movieDetails_Dto){
        return webClientBuilder.build().put().uri(UPDATE_MOVIE_DETAILS_BY_ID+"/"+id).body(BodyInserters.fromValue(movieDetails_Dto)).retrieve()
                .bodyToMono(MovieDetailsDto.class);
    }

    @DeleteMapping("deleteMovieDetailsById/{id}")
    public Mono deleteMovieDetailsById(@PathVariable String id){
        return webClientBuilder.build().delete().uri(DELETE_MOVIE_DETAILS_BY_ID+"/"+id).retrieve().bodyToMono(MovieDetailsDto.class);
    }


}
