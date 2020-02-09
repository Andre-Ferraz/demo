package com.example.demo.dao;

import com.example.demo.model.Media;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/*
    data access in memory
 */

@Repository("fakeDao")
public class FakeMediaDataAccessService implements MediaDao {

    private static List<Media> db = new ArrayList<>();

    @Override
    public int insertMedia(Media media) {
        db.add(media);
        return 1;
    }

    @Override
    public List<Media> selectAllMedia() {
        return db;
    }

    @Override
    public Optional<Media> selectMediaById(Integer id) {
        return db.stream()
                .filter(media -> media.getId().equals(id))
                .findFirst();
    }
}
