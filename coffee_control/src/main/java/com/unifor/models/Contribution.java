package com.unifor.models;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter @Setter
public class Contribution {
    private Integer id;
    private LocalDateTime contributionDate=LocalDateTime.now();
    private User user;
    private Solicitation solicitation;
    private List<ContributionProduct> products;


    public Contribution(User user, Solicitation solicitation) {
        this.user=user;
        this.solicitation=solicitation;
    }
}
