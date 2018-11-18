package com.roberto.cotaeasy.rest.resources;

import com.roberto.cotaeasy.business.dto.LoginDto;
import com.roberto.cotaeasy.business.dto.UsuarioDto;
import com.roberto.cotaeasy.business.services.UsuarioService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("usuarios")
public class UsuarioResource  {

    @Inject
    private UsuarioService service;

    @POST
    @Path("login")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(LoginDto dto) {
        return Response.ok(service.login(dto)).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response criar(UsuarioDto dto) {
        return Response.ok(service.criar(dto)).build();
    }
}
