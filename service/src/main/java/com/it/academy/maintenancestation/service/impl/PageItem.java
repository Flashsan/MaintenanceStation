package com.it.academy.maintenancestation.service.impl;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
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
