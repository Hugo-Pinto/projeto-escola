package io.github.HugoPinto.exception.professorexception;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.time.LocalDateTime;
import java.util.Map;

@Provider
public class ProfessorExceptionMapper
        implements ExceptionMapper<ProfessorNaoEncontradoException> {

    @Override
    public Response toResponse(
            ProfessorNaoEncontradoException ex) {

        Map<String, Object> erro = Map.of(
                "timestamp", LocalDateTime.now(),
                "status", 404,
                "erro", "Professor não encontrado",
                "mensagem", ex.getMessage()
        );

        return Response
                .status(Response.Status.NOT_FOUND)
                .type(MediaType.APPLICATION_JSON)
                .entity(erro)
                .build();
    }
}