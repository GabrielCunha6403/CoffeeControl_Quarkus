package com.unifor.dtos;

import com.unifor.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class StorageDto {
    private Long id;
    private Long product_id;
    private Integer currentAmount;
    private Integer minAmount;
}
