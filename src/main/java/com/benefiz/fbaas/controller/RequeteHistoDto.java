package com.benefiz.fbaas.controller;

import java.util.UUID;

public record RequeteHistoDto(
        UUID id,
        String query,
        Long user,
        String ip
) {
}
