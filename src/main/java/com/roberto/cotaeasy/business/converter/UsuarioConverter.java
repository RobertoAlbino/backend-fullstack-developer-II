package com.roberto.cotaeasy.business.converter;

import com.roberto.cotaeasy.business.models.Usuario;
import com.roberto.cotaeasy.business.dto.UsuarioDto;

public class UsuarioConverter extends Converter<UsuarioDto, Usuario> {

    public UsuarioConverter(UsuarioDto dto, Usuario entity) {
        super(userDto -> entity, user -> dto);
    }
}
