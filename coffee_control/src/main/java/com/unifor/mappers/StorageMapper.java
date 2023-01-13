package com.unifor.mappers;

import com.unifor.models.Solicitation;
import com.unifor.models.Storage;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface StorageMapper {

    @Select("SELECT * FROM product_storage")
    List<Storage> getStorages();

    @Select("SELECT * FROM product_storage WHERE id = #{id}")
    Storage getStorage(Long id);

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

    @Update("UPDATE product_storage SET current_amount = #{new_amount} WHERE id = #{id}")
    Integer updateAmount(Long id, Integer new_amount);
}
