package rest.mapper;

import org.mapstruct.Mapper;
import rest.dto.ArtistsDto;
import rest.model.Artists;

@Mapper(componentModel = "spring")
public interface ArtistsMapper {
    Artists toModel(ArtistsDto artistsDto);

    ArtistsDto toDto(Artists artists);
}
