package com.unifor.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contribution {
    public Long id;
    public LocalDate contributionDate=LocalDate.now();
    public User user;
    public Solicitation solicitation;
    public List<ContributionProduct> products;


    public Contribution(User user, Solicitation solicitation) {
        this.user=user;
        this.solicitation=solicitation;
    }
}
