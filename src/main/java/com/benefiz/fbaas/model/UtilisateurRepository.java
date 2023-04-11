package com.benefiz.fbaas.model;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UtilisateurRepository extends CrudRepository {
    Optional<Utilisateur> findByIp(String ip);
    Utilisateur save(Utilisateur entity);
    Optional<Utilisateur> findById(Long id);
}
