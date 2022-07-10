package com.it.academy.maintenancestation.pagination;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Paged <T> {
    private Page<T> page;

    private Paging paging;

}
