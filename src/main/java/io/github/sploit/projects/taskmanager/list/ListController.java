package io.github.sploit.projects.taskmanager.list;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/list")
public class ListController implements ListApiController {
    private final ListService listService;

    ListController(ListService listService) {
        this.listService = listService;
    }
    
    @Override
    public List<ListDto> getAll() {
        return listService.getAll();
    }

    @Override
    public ListDto getById(Long id) {
        return listService.getById(id);
    }

    @Override
    public ListDto add(ListDto req) {
        return listService.add(req);
    }

    @Override
    public ListDto update(Long id, ListDto req) {
        return listService.update(id, req);
    }

    @Override
    public Boolean deleteById(Long id) {
        return listService.deleteById(id);
    }
}
