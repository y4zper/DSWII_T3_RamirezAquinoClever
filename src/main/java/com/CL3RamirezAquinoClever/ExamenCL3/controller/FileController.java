package com.CL3RamirezAquinoClever.ExamenCL3.controller;

import com.CL3RamirezAquinoClever.ExamenCL3.model.response.ResponseFile;
import com.CL3RamirezAquinoClever.ExamenCL3.service.FileService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
@RestController
@CrossOrigin(origins = "https://www.cibertec.edu.pe")
public class FileController {
    private static final String IMAGES_DIRECTORY = "images";
    private static final String DOCUMENTS_DIRECTORY = "documents";
    private static final long MAX_FILE_SIZE = 1_500_000; // 1.5MB

    @PostMapping("/filesimages")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) throws IOException {
        validateFileExtension(file, "png");
        return saveFile(file, IMAGES_DIRECTORY);
    }

    @PostMapping("/filesexcel")
    public ResponseEntity<String> uploadExcelFile(@RequestParam("file") MultipartFile file) throws IOException {
        validateFileExtension(file, "xlsx");
        validateFileSize(file, MAX_FILE_SIZE);
        return saveFile(file, DOCUMENTS_DIRECTORY);
    }

    private ResponseEntity<String> saveFile(MultipartFile file, String directory) throws IOException {


        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/download/")
                .path(file.getOriginalFilename())
                .toUriString();

        return ResponseEntity.ok("Archivo subido correctamente. URL de descarga: " + fileDownloadUri);
    }

    private void validateFileExtension(MultipartFile file, String allowedExtension) {
        if (!file.getOriginalFilename().toLowerCase().endsWith(allowedExtension)) {
            throw new IllegalArgumentException("Extensión no permitida");
        }
    }

    private void validateFileSize(MultipartFile file, long maxSize) {
        if (file.getSize() > maxSize) {
            throw new IllegalArgumentException("Tamaño no permitido");
        }
    }
}