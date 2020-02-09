package com.example.demo.service;

import com.example.demo.dao.MediaDao;
import com.example.demo.model.Media;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MediaService {

    private final MediaDao mediaDao;

    @Autowired
    public MediaService(@Qualifier("postgres") MediaDao mediaDao) {
        this.mediaDao = mediaDao;
    }

    public int addMedia(Media media) {
        if (lengthIsValid(media.getLength())
                && nameIsValid(media.getName())
                && urlIsValid(media.getUrl()))
            return mediaDao.insertMedia(media);
        return 0;
    }

    public List<Media> getAllMedia() {
        return mediaDao.selectAllMedia();
    }

    public Optional<Media> getMediaById(Integer id) {
        return mediaDao.selectMediaById(id);
    }

    private boolean lengthIsValid(Integer length) {
        if (length == null)
            return true;
        return length < (Math.pow(10, 7)) && length > 0;
    }

    private boolean urlIsValid(String url) {
        if (url == null)
            return true;
        return url.length() <= 512;
    }

    private boolean nameIsValid(String name) {
        if (name == null)
            return false;
        return name.length() <= 512;
    }
}
