package com.roberto.cotaeasy.rest.common;

import java.util.Objects;

public class RespostaDefault {

    private Boolean sucesso;
    private String mensagem;
    private Object objeto;

    public Boolean getSucesso() {
        return sucesso;
    }

    public String getMensagem() {
        return mensagem;
    }

    public Object getObjeto() {
        return objeto;
    }

    private RespostaDefault(RespostaDefaultBuilder builder) {
        this.sucesso = builder.sucesso;
        this.mensagem = builder.mensagem;
        this.objeto = builder.objeto;
    }

    public static class RespostaDefaultBuilder {

        private Boolean sucesso;
        private String mensagem;
        private Object objeto;

        public RespostaDefaultBuilder(Boolean sucesso) {
            if (Objects.isNull(sucesso)) {
                throw new IllegalArgumentException("Sucesso é obrigatório");
            }
            this.sucesso = sucesso;
        }

        public RespostaDefaultBuilder addMensagem(String mensagem) {
            this.mensagem = mensagem;
            return this;
        }

        public RespostaDefaultBuilder addObjeto(Object objeto) {
            this.objeto = objeto;
            return this;
        }

        public RespostaDefault build() {
            return new RespostaDefault(this);
        }
    }
}
