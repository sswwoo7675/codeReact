package com.seo.mallapi.repository.search;

import com.seo.mallapi.domain.Todo;
import org.springframework.data.domain.Page;

public interface TodoSearch {
    Page<Todo> search1();
}
