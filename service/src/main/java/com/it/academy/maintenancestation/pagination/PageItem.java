package com.it.academy.maintenancestation.pagination;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PageItem {

    private PageItemType pageItemType;

    private int index;

    private boolean active;
}
