package com.unifor.forms;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ContributionPostForm {
    private Long solicitationId;
    private List<ContributionProductForm> products;
}
