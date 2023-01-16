package com.unifor.forms;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class ContributionProductForm {
    private Long product_id;
    private Integer givenAmount;

    public ContributionProductForm(Long product_id, Integer givenAmount) {
        this.product_id = product_id;
        this.givenAmount = givenAmount;
    }

}
