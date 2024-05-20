package io.github.sploit.projects.taskmanager.board;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import io.github.sploit.projects.taskmanager.common.exceptions.NotFoundException;

@Service
public class BoardServiceImpl implements BoardService {
    private final BoardRepository boardRepository;
    private final BoardMapper boardMapper;

    BoardServiceImpl(
        BoardRepository boardRepository,
        BoardMapper boardMapper) {
        this.boardRepository = boardRepository;
        this.boardMapper = boardMapper;
    }

    @Override
    public List<BoardDto> getAll() {
        return boardRepository.findAll()
                    .stream()
                    .map(board -> {
                        return boardMapper.entityToDto(board);
                     })
                     .collect(Collectors.toList());
    }

    @Override
    public BoardDto getById(Long id) {
        return boardRepository.findById(id)
                    .stream()
                    .map(board -> boardMapper.entityToDto(board))
                    .findFirst()
                    .orElseThrow(() -> new NotFoundException(id));
    }

    @Override
    public BoardDto add(BoardDto dto) {
        Board newBoard = boardRepository.save(
            boardMapper.dtoToEntity(dto)
        );

        return boardMapper.entityToDto(newBoard);
    }

    @Override
    public BoardDto update(Long id, BoardDto dto) {
        return boardRepository.findById(id)
                    .map(board -> {
                        board.setTitle(dto.getTitle());
                        Board updatedBoard = boardRepository.save(board);
                        return boardMapper.entityToDto(updatedBoard);
                    })
                    .orElseGet(() -> {
                        Board boardToAdd = new Board();
                        boardToAdd.setTitle(dto.getTitle());
                        Board newBoard = boardRepository.save(boardToAdd);
                        return boardMapper.entityToDto(newBoard);
                    });
    }

    @Override
    public Boolean deleteById(Long id) {
        boardRepository.deleteById(id);
        return boardRepository.existsById(id);
    }
}
