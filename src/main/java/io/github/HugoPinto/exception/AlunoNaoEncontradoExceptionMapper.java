package io.github.HugoPinto.exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class AlunoNaoEncontradoExceptionMapper implements ExceptionMapper<AlunoNaoEncontradoException> {
    @Override
    public Response toResponse(AlunoNaoEncontradoException exception) {
        ErrorResponse error = new ErrorResponse(
                "USUARIO_NAO_ENCONTRADO",
                exception.getMessage(),
                404
        );

        return Response.status(Response.Status.NOT_FOUND)
                .entity(error)
                .type("application/json")
                .build();
    }
}
