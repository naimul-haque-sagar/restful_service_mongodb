package rest.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rest.dto.ArtistsDto;
import rest.exception.AppException;
import rest.mapper.ArtistsMapper;
import rest.repo.ArtistsRepo;

@Service
@Transactional
@AllArgsConstructor
public class ArtistsService {
    private final ArtistsRepo artistsRepo;

    private final ArtistsMapper artistsMapper;

    public void postArtists(ArtistsDto artistsDto) {
        artistsRepo.save(artistsMapper.toModel(artistsDto));
    }

    public ArtistsDto getArtistsByName(String name) {
        return artistsMapper
                .toDto(artistsRepo.findByMovieName(name).orElseThrow(()->new AppException("Artists not found")));
    }
}
