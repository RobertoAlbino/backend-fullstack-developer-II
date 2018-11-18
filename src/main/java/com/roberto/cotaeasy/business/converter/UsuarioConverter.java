package com.roberto.cotaeasy.business.converter;

import com.roberto.cotaeasy.business.models.Usuario;
import com.roberto.cotaeasy.business.dto.UsuarioDto;

public class UsuarioConverter implements Converter<Usuario, UsuarioDto> {

    @Override
    public Usuario toEntity(UsuarioDto dto) {
        try {
            Usuario usuario = new Usuario();
            usuario.setId(dto.getId());
            usuario.setNome(dto.getNome());
            usuario.setEmail(dto.getEmail());
            usuario.setSenha(dto.getSenha());
            usuario.setTelefone(dto.getTelefone());
            usuario.setPerfil(dto.getPerfil());
            return usuario;
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public UsuarioDto toDto(Usuario entity) {
        UsuarioDto dto = new UsuarioDto();
        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setEmail(entity.getEmail());
        dto.setSenha(entity.getSenha());
        dto.setTelefone(entity.getTelefone());
        dto.setPerfil(entity.getPerfil());
        return dto;
    }
}
