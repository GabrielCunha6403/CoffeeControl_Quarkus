package com.unifor.forms;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class ContributionPostForm {
    public LocalDate data;
    public Long user_id;
    public Long solicitation_id;
    public List<ContributionProductForm> products;
}
