package io.github.sploit.projects.taskmanager.board;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.sploit.projects.taskmanager.common.ApiController;

@RestController
@RequestMapping("/api/board")
public class BoardController implements ApiController<BoardDto, BoardDto, Long> {
    private final BoardService boardService;

    BoardController(BoardService boardService) {
        this.boardService = boardService;
    }
    
    @Override
    public List<BoardDto> getAll() {
        return boardService.getAll();
    }

    @Override
    public BoardDto getById(Long id) {
        return boardService.getById(id);
    }

    @Override
    public BoardDto add(BoardDto req) {
        return boardService.add(req);
    }

    @Override
    public BoardDto update(Long id, BoardDto req) {
        return boardService.update(id, req);
    }

    @Override
    public Boolean deleteById(Long id) {
        return boardService.deleteById(id);
    }
}
