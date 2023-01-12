package com.unifor.forms;

import com.unifor.models.ContributionProduct;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class ContributionProductForm {
    private Long productId;
    private Integer givenAmount;

    public ContributionProductForm(Long productId, Integer givenAmount) {
        this.productId = productId;
        this.givenAmount = givenAmount;
    }

}
