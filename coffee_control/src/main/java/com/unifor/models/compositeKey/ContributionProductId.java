package com.unifor.models.compositeKey;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
public class ContributionProductId implements Serializable {
    private Integer contributionId;
    private Integer productId;

    public ContributionProductId(Integer contributionId, Integer productId) {
        super();
        this.contributionId = contributionId;
        this.productId = productId;
    }
}
