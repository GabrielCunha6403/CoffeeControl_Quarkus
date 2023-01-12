package com.unifor.dtos;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ProductDto {
    public Long id;
    public String product_name;
    public String description;
    public Integer min_user_amount;
    public Boolean enable;
}
