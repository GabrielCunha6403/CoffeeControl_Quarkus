package com.unifor.dtos;

import com.unifor.models.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class StorageDto {
    private Long id;
    private Long product_id;
    private Integer currentAmount;
    private Integer minAmount;
}
