package com.example.demo.resource;

import com.example.demo.model.Media;
import com.example.demo.service.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("medias")
@RestController
public class MediaController {

    private final MediaService mediaService;

    @Autowired
    public MediaController(MediaService mediaService) {
        this.mediaService = mediaService;
    }

    @PostMapping
    public void addMedia(@NonNull @RequestBody Media media){
        mediaService.addMedia(media);
    }

    @GetMapping
    public List<Media> getAllMedia(){
        return mediaService.getAllMedia();
    }

    @GetMapping(path = "{id}")
    public Media getMediaById(@PathVariable("id") Integer id){
        return mediaService.getMediaById(id).orElse(null);
    }
}
