package com.unifor.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    public Long id;
    public String name;
    public String description;
    public Integer minUserAmount;
    public Boolean enabled;
    public List<ContributionProduct> contributions;
    public List<SolicitationProduct> solicitations;

}
