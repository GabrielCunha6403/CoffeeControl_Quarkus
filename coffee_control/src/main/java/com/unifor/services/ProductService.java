package com.unifor.services;

import com.unifor.dtos.ProductDto;
import com.unifor.forms.ProductPostForm;

import java.util.List;

public interface ProductService {

    public List<ProductDto> list();

    public  ProductDto getSpecificProduct(Long id);

    public void saveProduct(ProductPostForm form);

    public void deleteProduct(Long id);

}
