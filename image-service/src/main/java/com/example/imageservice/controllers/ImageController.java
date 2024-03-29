package com.example.imageservice.controllers;

import com.example.imageservice.models.Image;
import com.example.imageservice.models.ImageUploadRequest;
import com.example.imageservice.models.NotificationItem;
import com.example.imageservice.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/image")
public class ImageController {
    @Autowired
    private Environment env;

    @Autowired
    private NotificationService notificationService;

    @GetMapping
    public List<Image> getImages() {
        List<Image> images = Arrays.asList(
                new Image(1, "Treehouse of Horror V", "https://www.imdb.com/title/tt0096697/mediaviewer/rm3842005760"),
                new Image(2, "The Town", "https://www.imdb.com/title/tt0096697/mediaviewer/rm3698134272"),
                new Image(3, "The Last Traction Hero", "https://www.imdb.com/title/tt0096697/mediaviewer/rm1445594112"));

        return images;
    }

    @PostMapping("/process")
    public void uploadImages(ImageUploadRequest imageUploadRequest) {
        notificationService.sendNotification(new NotificationItem("image-upload"));
    }

    @GetMapping("/ping")
    public String home() {
        return "Hello from Image Service running at port: " + env.getProperty("local.server.port");
    }
}
