package com.becoder.controller;



import com.becoder.service.ImageUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ImageUploader {

    @Autowired
    private com.becoder.service.ImageUploadService imageUploadService;

    @RequestMapping("/")
    public String index() {
        return "upload";
    }

    @PostMapping("/upload")
    public String uploadFile(MultipartFile file, RedirectAttributes redirectAttributes, Model model) {
        String message = imageUploadService.uploadFile(file);
        redirectAttributes.addFlashAttribute("message", message);
        return "redirect:/";
    }
}
