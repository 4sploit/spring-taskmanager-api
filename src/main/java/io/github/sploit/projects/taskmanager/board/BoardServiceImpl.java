package io.github.sploit.projects.taskmanager.board;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames =  "boards")
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
    @Cacheable
    public List<BoardDto> getAll() {
        return boardRepository.findAll()
                .stream()
                .map(boardMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    @Cacheable(key = "#id")
    public Optional<BoardDto> getById(Long id) {
        return boardRepository.findById(id)
                .stream()
                .map(boardMapper::entityToDto)
                .findFirst();
    }

    @Override
    @CacheEvict(key = "#newBoard.id")
    public BoardDto add(BoardDto dto) {
        Board newBoard = boardRepository.save(
                boardMapper.dtoToEntity(dto));

        return boardMapper.entityToDto(newBoard);
    }

    @Override
    @CacheEvict(key = "#id")
    public BoardDto update(Long id, BoardDto dto) {
        return boardRepository.findById(id)
                .map(board -> {
                    boardMapper.updateEntityFromDto(dto, board);
                    Board updatedBoard = boardRepository.save(board);
                    return boardMapper.entityToDto(updatedBoard);
                })
                .orElseGet(() -> {
                    Board boardToAdd = new Board();
                    boardMapper.updateEntityFromDto(dto, boardToAdd);
                    Board newBoard = boardRepository.save(boardToAdd);
                    return boardMapper.entityToDto(newBoard);
                });
    }

    @Override
    @CacheEvict(key = "#id")
    public Boolean deleteById(Long id) {
        boardRepository.deleteById(id);
        return boardRepository.existsById(id);
    }
}
