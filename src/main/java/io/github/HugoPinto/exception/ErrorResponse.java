package io.github.HugoPinto.exception;

public record ErrorResponse(
        String code,
        String message,
        int status
) {}
