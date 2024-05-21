package io.github.sploit.projects.taskmanager.list;

import java.util.List;

import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<ListDto>> getAll() {
        List<ListDto> lists = listService.getAll();
        return ResponseEntity.ok(lists);
    }

    @Override
    public ResponseEntity<ListDto> getById(Long id) {
        ListDto list = listService.getById(id);
        return ResponseEntity.ok(list);
    }

    @Override
    public ResponseEntity<ListDto> add(ListDto req) {
        ListDto newList = listService.add(req);
        return ResponseEntity.ok(newList);
    }

    @Override
    public ResponseEntity<ListDto> update(Long id, ListDto req) {
        ListDto updatedList = listService.update(id, req);
        return ResponseEntity.ok(updatedList);
    }

    @Override
    public ResponseEntity<Boolean> deleteById(Long id) {
        boolean isDeleted = listService.deleteById(id);
        return ResponseEntity.ok(isDeleted);
    }
}
