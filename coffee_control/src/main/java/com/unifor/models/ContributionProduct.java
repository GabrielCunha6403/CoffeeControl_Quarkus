package com.unifor.models;

import com.unifor.models.compositeKey.ContributionProductId;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ContributionProduct {
    private ContributionProductId id;
    private Contribution contribution;
    private Product product;
    private Integer GivenAmount;

//    public ContributionProduct(ContributionProductId id, Integer givenAmount) {
//        this.id = id;
//        GivenAmount = givenAmount;
//    }
}
