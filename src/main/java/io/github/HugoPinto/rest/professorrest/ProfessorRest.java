package io.github.HugoPinto.rest.professorrest;

import io.github.HugoPinto.dto.professordto.ProfessorDto;
import io.github.HugoPinto.facade.professorfacade.*;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/professor")
@Produces(MediaType.APPLICATION_JSON)
public class ProfessorRest {

    @Inject
    CriarProfessorFacade criarProfessorFacade;

    @Inject
    ListarProfessorFacade listarProfessorFacade;

    @Inject
    ExcluirProfessorFacade excluirProfessorFacade;

    @Inject
    ListarTodosProfessoresFacade listarTodosProfessoresFacade;

    @Inject
    AtualizarProfessorFacade atualizarProfessorFacade;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cadastrarProfessor(ProfessorDto professor){

        return Response
                .status(Response.Status.CREATED)
                .entity(criarProfessorFacade.executar(professor))
                .build();
    }

    @GET
    @Path("/{id}")
    public Response findProfessoryById(@PathParam("id") Long id){

        return Response
                .status(Response.Status.OK)
                .entity(listarProfessorFacade.executar(id))
                .build();
    }

    @GET
    public Response listarTodosProfessores(){

        return Response
                .status(Response.Status.OK)
                .entity(listarTodosProfessoresFacade.executar())
                .build();
    }

    @PUT
    public Response AtualizarProfessorFacade(@PathParam("id") Long id, ProfessorDto professorDto){

        return Response
                .status(Response.Status.OK)
                .entity(atualizarProfessorFacade.executar(id, professorDto))
                .build();
    }

    @DELETE
    @Path("/{id}")
    public Response excluirProfessor(@PathParam("id") Long id){

        return Response
                .status(Response.Status.OK)
                .entity(excluirProfessorFacade.executar(id))
                .build();
    }
}
