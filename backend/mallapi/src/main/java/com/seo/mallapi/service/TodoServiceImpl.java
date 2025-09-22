package com.seo.mallapi.service;

import com.seo.mallapi.domain.Todo;
import com.seo.mallapi.dto.PageRequestDTO;
import com.seo.mallapi.dto.PageResponseDTO;
import com.seo.mallapi.dto.TodoDTO;
import com.seo.mallapi.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@Log4j2
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService{

    private final ModelMapper modelMapper;

    private final TodoRepository todoRepository;

    @Override
    public Long register(TodoDTO todoDTO){
        log.info("------------");

        Todo todo = modelMapper.map(todoDTO, Todo.class);
        Todo savedTodo = todoRepository.save(todo);

        return savedTodo.getTno();
    }

    @Override
    public TodoDTO get(Long tno){
        Optional<Todo> result = todoRepository.findById(tno);
        Todo todo = result.orElseThrow();

        return entityToDTO(todo);
    }

    @Override
    public void modify(TodoDTO todoDTO){
        Optional<Todo> result = todoRepository.findById(todoDTO.getTno());

        Todo todo = result.orElseThrow();

        todo.changeTitle(todoDTO.getTitle());
        todo.changeContent(todoDTO.getContent());
        todo.changeDueDate(todoDTO.getDueDate());
        todo.changeComplete(todo.isComplete());

        todoRepository.save(todo);
    }

    @Override
    public void remove(Long tno){
        todoRepository.deleteById(tno);
    }

    @Override
    public PageResponseDTO<TodoDTO> list(PageRequestDTO pageRequestDTO) {
        Pageable pageable = PageRequest.of(
                pageRequestDTO.getPage() -1,
                pageRequestDTO.getSize(),
                Sort.by("tno").descending());

        Page<Todo> result = todoRepository.findAll(pageable);

        List<TodoDTO> dtoList = result.getContent().stream()
                .map(todo->modelMapper.map(todo, TodoDTO.class))
                .toList();

        long totalCount = result.getTotalElements();

        return PageResponseDTO.<TodoDTO>withAll()
                .dtoList(dtoList)
                .pageRequestDTO(pageRequestDTO)
                .totalCount(totalCount)
                .build();
    }
}
