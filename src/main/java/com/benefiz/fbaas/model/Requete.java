package com.benefiz.fbaas.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class Requete {
    @Id
    @GeneratedValue
    private UUID id;

    private String query;

    @ManyToOne
    private Utilisateur utilisateur;

}
