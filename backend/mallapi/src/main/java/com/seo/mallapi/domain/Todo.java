package com.seo.mallapi.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name="tbl_todo")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long tno;

    private String title;

    private String content;

    private String writer;

    private boolean complete;

    private LocalDate dueDate;

    public void changeTitle(String title){
        this.title = title;
    }

    public void changeContent(String content) {
        this.content = content;
    }

    public void changeComplete(boolean complete){
        this.complete = complete;
    }

    public void changeDueDate(LocalDate dueDate){
        this.dueDate = dueDate;
    }
}