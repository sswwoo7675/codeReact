package com.seo.mallapi.service;

import com.seo.mallapi.dto.PageRequestDTO;
import com.seo.mallapi.dto.PageResponseDTO;
import com.seo.mallapi.dto.TodoDTO;

public interface TodoService {
    Long register(TodoDTO todoDTO);
    TodoDTO get(Long tno);
    void modify(TodoDTO todoDTO);
    void remove(Long tno);
    PageResponseDTO<TodoDTO> list(PageRequestDTO pageRequestDTO);
}
