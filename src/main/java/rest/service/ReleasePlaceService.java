package rest.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rest.dto.ReleasePlaceDto;
import rest.exception.AppException;
import rest.mapper.ReleasePlaceMapper;
import rest.repo.ReleasePlaceRepo;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class ReleasePlaceService {
    private final ReleasePlaceRepo releasePlaceRepo;

    private final ReleasePlaceMapper releasePlaceMapper;

    public void postReleasePlace(ReleasePlaceDto releasePlaceDto) {
        releasePlaceRepo.save(releasePlaceMapper.toModel(releasePlaceDto));
    }

    public List<ReleasePlaceDto> getReleasePlaceByName(String name) {
        return releasePlaceRepo.findByMovieName(name).stream().map(releasePlaceMapper::toDto).collect(Collectors.toList());
    }
}
