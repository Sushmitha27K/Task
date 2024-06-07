package com.becoder.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Iterator;

@RestController
@RequestMapping("/api")
public class ImageController {

    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return new ResponseEntity<>("File is empty", HttpStatus.BAD_REQUEST);
        }

        try {
            // Validate file size
            if (file.getSize() > 100 * 1024 * 1024) {
                return new ResponseEntity<>("File size exceeds limit", HttpStatus.BAD_REQUEST);
            }

            // Validate the TIFF image
            try (ByteArrayInputStream bais = new ByteArrayInputStream(file.getBytes());
                 ImageInputStream iis = ImageIO.createImageInputStream(bais)) {
                
                Iterator<javax.imageio.ImageReader> readers = ImageIO.getImageReaders(iis);
                if (!readers.hasNext()) {
                    return new ResponseEntity<>("File is not a valid TIFF image", HttpStatus.BAD_REQUEST);
                }

                javax.imageio.ImageReader reader = readers.next();
                reader.setInput(iis);
                BufferedImage image = reader.read(0);
                if (image == null) {
                    return new ResponseEntity<>("File is not a valid TIFF image", HttpStatus.BAD_REQUEST);
                }
                // Additional validation for multi-page TIFF can be added here if needed
            }

            return new ResponseEntity<>("File uploaded successfully", HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>("Error processing file", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
