package com.unifor.models.compositeKey;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
public class SolicitationProductId implements Serializable {
    private Integer solicitationId;
    private Integer productId;

    public SolicitationProductId(Integer solicitationId, Integer productId) {
        super();
        this.solicitationId = solicitationId;
        this.productId = productId;
    }

    public SolicitationProductId() {

    }
}
