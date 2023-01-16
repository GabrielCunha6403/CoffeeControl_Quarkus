package com.unifor.mappers;

import com.unifor.dtos.StorageDto;
import com.unifor.models.Solicitation;
import com.unifor.models.Storage;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface StorageMapper {

    @Select("SELECT * FROM product_storage")
    List<StorageDto> getStorages();

    @Select("SELECT * FROM product_storage WHERE product_id = #{product_id}")
    StorageDto getStorageByProductId(Long product_id);

    @Insert("INSERT INTO product_storage (id, " +
            "product_id, " +
            "current_amount, " +
            "min_amount) " +
            "VALUES (" +
            "DEFAULT, " +
            "#{product_id}, " +
            "#{current_amount}, " +
            "#{min_amount}")
    Integer saveStorage(
            @Param("product_id") Integer product_id,
            @Param("current_amount") Integer current_amount,
            @Param("min_amount") Integer min_amount
    );

    @Delete("DELETE FROM product_storage WHERE id = #{id}")
    Integer deleteStorage(Long id);

    @Update("UPDATE product_storage SET current_amount = #{new_amount} WHERE product_id = #{product_id}")
    Integer updateAmountByProductId(Long product_id, Integer new_amount);
}
