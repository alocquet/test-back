package com.benefiz.fbaas.controller;

import com.benefiz.fbaas.model.Requete;
import com.benefiz.fbaas.model.RequeteRepository;
import com.benefiz.fbaas.model.Utilisateur;
import com.benefiz.fbaas.model.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@RestController
public class RequeteHistoController {

    @Autowired
    private RequeteRepository repo;
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public void log(final String userIp,
                    final String from,
                    final Optional<String> to) {
        var user = utilisateurRepository.findByIp(userIp).orElseGet(() -> utilisateurRepository.save(Utilisateur.builder().ip(userIp).build()));
        repo.save(Requete.builder()
                .utilisateur(user)
                .query(from + to.map(val -> "/" + val).orElse(""))
                .build());
    }

    @GetMapping("fb/log")
    public List<RequeteHistoDto> getLogs() {
        return StreamSupport.stream(repo.findAll().spliterator(), false)
                .map(histo -> new RequeteHistoDto(histo.getId(), histo.getQuery(),histo.getUtilisateur().getId(), histo.getUtilisateur().getIp()))
                .toList();
    }

    @GetMapping("fb/log/{userId}")
    public List<RequeteHistoDto> getLogs(@PathVariable Long userId) {
        var utilisateur = utilisateurRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException());

        return utilisateur.getRequetes().stream()
                .map(histo -> new RequeteHistoDto(histo.getId(), histo.getQuery(), histo.getUtilisateur().getId(), histo.getUtilisateur().getIp()))
                .toList();
    }

}