package rest.mapper;

import org.mapstruct.Mapper;
import rest.dto.ReleasePlaceDto;
import rest.model.ReleasePlace;

@Mapper(componentModel = "spring")
public interface ReleasePlaceMapper {
    ReleasePlace toModel(ReleasePlaceDto releasePlaceDto);

    ReleasePlaceDto toDto(ReleasePlace byMovieName);
}
