package com.seo.mallapi.service;

import com.seo.mallapi.domain.Todo;
import com.seo.mallapi.dto.PageRequestDTO;
import com.seo.mallapi.dto.PageResponseDTO;
import com.seo.mallapi.dto.TodoDTO;

public interface TodoService {
    Long register(TodoDTO todoDTO);
    TodoDTO get(Long tno);
    void modify(TodoDTO todoDTO);
    void remove(Long tno);
    PageResponseDTO<TodoDTO> list(PageRequestDTO pageRequestDTO);
    PageResponseDTO<TodoDTO> getList(PageRequestDTO pageRequestDTO);

    default TodoDTO entityToDTO(Todo todo){
        return
                TodoDTO.builder()
                        .tno(todo.getTno())
                        .title(todo.getTitle())
                        .content(todo.getContent())
                        .writer(todo.getWriter())
                        .complete(todo.isComplete())
                        .dueDate(todo.getDueDate())
                        .build();
    }

    default Todo dtoToEntity(TodoDTO todoDTO){
        return
                Todo.builder()
                        .tno(todoDTO.getTno())
                        .title(todoDTO.getTitle())
                        .content(todoDTO.getContent())
                        .writer(todoDTO.getWriter())
                        .complete(todoDTO.isComplete())
                        .dueDate(todoDTO.getDueDate())
                        .build();
    }
}
