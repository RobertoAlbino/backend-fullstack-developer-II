package com.roberto.cotaeasy.rest.resources;

import com.roberto.cotaeasy.business.dto.UsuarioDto;
import com.roberto.cotaeasy.business.models.Usuario;
import com.roberto.cotaeasy.business.services.AbstractCrudService;
import com.roberto.cotaeasy.business.services.UsuarioService;
import com.roberto.cotaeasy.rest.common.AbstractCrudResource;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("usuarios")
public class UsuarioResource extends AbstractCrudResource<Usuario> {

    @Inject
    private UsuarioService service;

    @Override
    protected AbstractCrudService<Usuario> getService() {
        return service;
    }

    @POST
    @Path("login")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(UsuarioDto dto) {
        return Response.ok(service.login(dto)).build();
    }
}
