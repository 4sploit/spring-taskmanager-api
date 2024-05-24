package io.github.sploit.projects.taskmanager.list;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "lists")
public class ListServiceImpl implements ListService {
    private final ListRepository listRepository;
    private final ListMapper listMapper;

    ListServiceImpl(
            ListRepository listRepository,
            ListMapper listMapper) {
        this.listRepository = listRepository;
        this.listMapper = listMapper;
    }

    @Override
    @Cacheable
    public java.util.List<ListDto> getAll() {
        return listRepository.findAll()
                .stream()
                .map(listMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    @Cacheable(key = "#id")
    public Optional<ListDto> getById(Long id) {
        return listRepository.findById(id)
                .stream()
                .map(listMapper::entityToDto)
                .findFirst();
    }

    @Override
    @CacheEvict(key = "#newList.id")
    public ListDto add(ListDto dto) {
        List newList = listRepository.save(
                listMapper.dtoToEntity(dto));

        return listMapper.entityToDto(newList);
    }

    @Override
    @CacheEvict(key = "#id")
    public ListDto update(Long id, ListDto dto) {
        return listRepository.findById(id)
                .map(list -> {
                    listMapper.updateEntityFromDto(dto, list);
                    List updatedList = listRepository.save(list);
                    return listMapper.entityToDto(updatedList);
                })
                .orElseGet(() -> {
                    List listToAdd = new List();
                    listMapper.updateEntityFromDto(dto, listToAdd);
                    List newList = listRepository.save(listToAdd);
                    return listMapper.entityToDto(newList);
                });
    }

    @CacheEvict(key = "#id")
    @Override
    public Boolean deleteById(Long id) {
        listRepository.deleteById(id);
        return listRepository.existsById(id);
    }
}
