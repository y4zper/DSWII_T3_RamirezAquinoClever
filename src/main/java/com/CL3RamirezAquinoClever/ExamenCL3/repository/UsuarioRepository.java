package com.CL3RamirezAquinoClever.ExamenCL3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.CL3RamirezAquinoClever.ExamenCL3.model.bd.Usuario;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository  extends
        JpaRepository<Usuario, Integer>{

    Usuario findByNomusuario(String nomusuario);
}
