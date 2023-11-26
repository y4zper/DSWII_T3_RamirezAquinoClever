package com.CL3RamirezAquinoClever.ExamenCL3.controller;

import com.CL3RamirezAquinoClever.ExamenCL3.model.response.ResponseFile;
import com.CL3RamirezAquinoClever.ExamenCL3.service.FileService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/file")
public class FileController {
    private FileService fileService;
    @PostMapping("/upload")
    public ResponseEntity<ResponseFile> subirArchivos(
            @RequestParam("files")List<MultipartFile> files) throws  Exception{
        fileService.guardarArchivos(files);
        return ResponseEntity.status(HttpStatus.OK)
                .body(
                        ResponseFile.builder().message("Los archivos fueron cargados correctamente")
                                .build()
                );
    }
}