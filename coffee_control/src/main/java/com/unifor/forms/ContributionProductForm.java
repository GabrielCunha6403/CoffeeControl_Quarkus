package com.unifor.forms;

import com.unifor.models.ContributionProduct;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class ContributionProductForm {
    private Integer productId;
    private Integer givenAmount;

    public ContributionProductForm(Integer productId, Integer givenAmount) {
        this.productId = productId;
        this.givenAmount = givenAmount;
    }
    public ContributionProductForm(ContributionProduct cp) {
        this.productId =cp.getId().getProductId();
        this.givenAmount = cp.getGivenAmount();
    }

}
