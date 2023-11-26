package com.CL3RamirezAquinoClever.ExamenCL3.model.response;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UsuarioResponse {
    private Integer idusuario;
    private String nomusuario;
    private String token;
}