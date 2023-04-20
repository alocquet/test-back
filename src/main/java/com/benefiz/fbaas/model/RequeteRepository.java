package com.benefiz.fbaas.model;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface RequeteRepository extends CrudRepository<Requete, UUID> {
}
