package io.github.HugoPinto.rest.turmarest;


import io.github.HugoPinto.dto.turmadto.TurmaDto;
import io.github.HugoPinto.facade.turmafacade.TurmaFacade;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Produces(MediaType.APPLICATION_JSON)
@Path("/turma")
public class TurmaRest {

    @Inject
    TurmaFacade turmaFacade;

    @POST
    @Path("/")
    public Response cadastrarTurma(TurmaDto turmaDto){
        return Response.ok(turmaFacade.executar(turmaDto)).build();
    }
}
