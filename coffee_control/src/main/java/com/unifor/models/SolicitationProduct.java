package com.unifor.models;


import com.unifor.models.compositeKey.SolicitationProductId;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SolicitationProduct {
    private SolicitationProductId id=new SolicitationProductId();
    private Solicitation solicitation;
    private Product product;
    private Integer amountAsked;

    public SolicitationProduct(SolicitationProductId id,Integer amountAsked) {
        this.id = id;
        this.amountAsked = amountAsked;
    }
}
