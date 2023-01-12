package com.unifor.resources;

import com.unifor.dtos.ProductDto;
import com.unifor.forms.ProductPostForm;
import com.unifor.services.ProductService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.List;

@ApplicationScoped
@Path("/products")
public class ProductResource {

    @Inject
    ProductService productService;

    @GET
    public List<ProductDto> list(){
        return productService.list();
    }

    @GET
    @Path("/{id}")
    public ProductDto getSpecificProduct(Long id){
        return productService.getSpecificProduct(id);
    }

    @POST
    public void saveProduct(ProductPostForm form){
        productService.saveProduct(form);
    }

    @DELETE
    @Path("/{id}")
    public void deleteProduct(Long id){
        productService.deleteProduct(id);
    }

}
