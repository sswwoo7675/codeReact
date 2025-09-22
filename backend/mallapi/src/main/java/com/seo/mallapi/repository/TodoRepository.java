package com.seo.mallapi.repository;

import com.seo.mallapi.domain.Todo;
import com.seo.mallapi.repository.search.TodoSearch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long>, TodoSearch {
}
