package com.benefiz.fbaas.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class Utilisateur {
    @Id
    @GeneratedValue
    private Long id;

    private String ip;

    @OneToMany(mappedBy = "utilisateur")
    private List<Requete> requetes;
}
