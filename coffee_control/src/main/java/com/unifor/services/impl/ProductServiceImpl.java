package com.unifor.services.impl;

import com.unifor.dtos.ProductDto;
import com.unifor.forms.ProductPostForm;
import com.unifor.mappers.ProductMapper;
import com.unifor.services.ProductService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class ProductServiceImpl implements ProductService {

    @Inject
    ProductMapper productMapper;

    public List<ProductDto> list(){
        return productMapper.getProducts();
    }

    public ProductDto getSpecificProduct(Long id){
        return productMapper.getProduct(id);
    }

    @Override
    public void saveProduct(ProductPostForm form) {
        productMapper.saveProduct(form.name, form.description, form.minUserAmount, form.enabled);
    }

    @Override
    public void deleteProduct(Long id) {
        productMapper.deleteProduct(id);
    }
}
