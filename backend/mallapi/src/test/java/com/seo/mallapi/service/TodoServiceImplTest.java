package com.seo.mallapi.service;

import com.seo.mallapi.dto.PageRequestDTO;
import com.seo.mallapi.dto.PageResponseDTO;
import com.seo.mallapi.dto.TodoDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Log4j2
class TodoServiceImplTest {

    @Autowired
    private TodoService todoService;

    @Test
    void register() {
        TodoDTO todoDto = TodoDTO.builder()
                .title("서비스 테스트")
                .content("서비스 테스트 입니다")
                .dueDate(LocalDate.of(2025,8,13))
                .build();

        Long tno = todoService.register(todoDto);

        log.info("tno: {}", tno);
    }

    @Test
    void get() {
        Long tno = 50L;

        TodoDTO todoDTO = todoService.get(tno);

        log.info(todoDTO);
    }

    @Test
    void list() {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .page(2)
                .size(10)
                .build();

        PageResponseDTO<TodoDTO> response = todoService.list(pageRequestDTO);

        log.info(response);
    }

    @Test
    void testGetList(){
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().build();

        log.info(todoService.getList(pageRequestDTO));
    }
}







