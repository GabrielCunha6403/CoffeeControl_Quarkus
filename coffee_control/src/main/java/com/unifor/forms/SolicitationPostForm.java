package com.unifor.forms;

import com.unifor.dtos.ProductInSolicitationDto;
import java.util.List;

public class SolicitationPostForm {
    public String name;
    public Long user_id;
    public List<ProductInSolicitationDto> products;
}
