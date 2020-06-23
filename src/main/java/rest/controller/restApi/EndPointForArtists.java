package rest.controller.restApi;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rest.dto.ArtistsDto;
import rest.service.ArtistsService;

@RestController
@RequestMapping("mongo/artists")
@AllArgsConstructor
public class EndPointForArtists {
    private final ArtistsService artistsService;

    @PostMapping("postArtists")
    public ResponseEntity postArtists(@RequestBody ArtistsDto artistsDto){
        artistsService.postArtists(artistsDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("getArtistsByName/{name}")
    public ResponseEntity<ArtistsDto> getArtistsByName(@PathVariable String name){
        return ResponseEntity.status(HttpStatus.OK)
                .body(artistsService.getArtistsByName(name));
    }
}
