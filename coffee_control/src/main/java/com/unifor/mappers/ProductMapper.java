package com.unifor.mappers;

import com.unifor.models.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductMapper {
    @Select("SELECT * FROM products")
    List<Product> getProduct();

    @Select("SELECT * FROM products WHERE id = #{id}")
    Product getProduct(Long id);

    @Insert("INSERT INTO products (id, product_name, description, min_user_amount, enabled) VALUES (DEFAULT, #{name}, #{description}, #{min_amount}, #{enabled})")
    Integer saveProduct(@Param("name") String name, @Param("description") String description, @Param("min_amount") Integer min_amount, @Param("enabled") Boolean enabled);

    @Delete("DELETE FROM products WHERE id = #{id}")
    Integer deleteProduct(Long id);
}
