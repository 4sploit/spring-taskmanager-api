package io.github.sploit.projects.taskmanager.board;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/board")
public class BoardController implements BoardApiController {
    private final BoardService boardService;

    BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @Override
    public ResponseEntity<List<BoardDto>> getAll() {
        List<BoardDto> boards = boardService.getAll();
        return ResponseEntity.ok(boards);
    }

    @Override
    public ResponseEntity<BoardDto> getById(Long id) {
        BoardDto board = boardService.getById(id);
        return ResponseEntity.ok(board);
    }

    @Override
    public ResponseEntity<BoardDto> add(BoardDto req) {
        BoardDto newBoard = boardService.add(req);
        return ResponseEntity.ok(newBoard);
    }

    @Override
    public ResponseEntity<BoardDto> update(Long id, BoardDto req) {
        BoardDto updatedBoard = boardService.update(id, req);
        return ResponseEntity.ok(updatedBoard);
    }

    @Override
    public ResponseEntity<Boolean> deleteById(Long id) {
        boolean isDeleted = boardService.deleteById(id);
        return ResponseEntity.ok(isDeleted);
    }
}
