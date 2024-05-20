package io.github.sploit.projects.taskmanager.list;

import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import io.github.sploit.projects.taskmanager.common.exceptions.ItemNotFoundException;

@Service
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
    public java.util.List<ListDto> getAll() {
        return listRepository.findAll()
                    .stream()
                    .map(list -> listMapper.entityToDto(list))
                     .collect(Collectors.toList());
    }

    @Override
    public ListDto getById(Long id) {
        return listRepository.findById(id)
                    .stream()
                    .map(list -> listMapper.entityToDto(list))
                    .findFirst()
                    .orElseThrow(() -> new ItemNotFoundException(id));
    }

    @Override
    public ListDto add(ListDto dto) {
        List newList = listRepository.save(
            listMapper.dtoToEntity(dto)
        );

        return listMapper.entityToDto(newList);
    }

    @Override
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

    @Override
    public Boolean deleteById(Long id) {
        listRepository.deleteById(id);
        return listRepository.existsById(id);
    }
}
