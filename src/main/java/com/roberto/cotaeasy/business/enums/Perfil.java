package com.roberto.cotaeasy.business.enums;

public enum Perfil {
    USUARIO(0),
    FORNECEDOR(1);

    private int perfil;

    Perfil(int perfil) {
        this.perfil = perfil;
    }

    public int getPerfil() {
        return perfil;
    }
}
