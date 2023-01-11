package com.unifor.models;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
@Getter @Setter
public class Solicitation {
    private Integer id;
    private String name;
    private LocalDateTime solicitation_date=LocalDateTime.now();
    private LocalDateTime solicitation_expiration;

    private Boolean enabled=true;
    private User assignedUser;
    private List<Contribution> contributions;
    private List<SolicitationProduct> products;
    

//    public Solicitation(SolicitationPostForm form, User user) {
//        this.name= form.getName();
//        this.assignedUser=user;
//        this.solicitation_expiration = this.solicitation_date.plusDays(getSolicitation_date().getMonth().maxLength());
//    }
}
