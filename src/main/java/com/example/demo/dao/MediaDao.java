package com.example.demo.dao;

import com.example.demo.model.Media;

import java.util.List;
import java.util.Optional;

public interface MediaDao {

    int insertMedia(Media media);

    List<Media> selectAllMedia();

    Optional<Media> selectMediaById(Integer id);
}
