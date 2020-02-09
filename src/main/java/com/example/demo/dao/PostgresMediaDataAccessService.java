package com.example.demo.dao;

import com.example.demo.model.Media;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("postgres")
public class PostgresMediaDataAccessService implements MediaDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PostgresMediaDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertMedia(Media media) {
        final String sql = "INSERT INTO media (name, url, media_length) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, media.getName(), media.getUrl(), media.getLength());
    }

    @Override
    public List<Media> selectAllMedia() {
        final String sql = "SELECT id, name, url, media_length FROM media";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            Integer id = Integer.parseInt(resultSet.getString("id"));
            String name = resultSet.getString("name");
            String url = resultSet.getString("url");
            String length = resultSet.getString("media_length");
            Integer mediaLength = parseMediaLength(length);

            return new Media(id, name, url, mediaLength);
        });
    }

    @Override
    public Optional<Media> selectMediaById(Integer id) {
        final String sql = "SELECT id, name, url, media_length FROM media WHERE id = ?";

        Media media = jdbcTemplate.queryForObject(
                sql,
                new Object[]{id},
                (resultSet, i) -> {
                    String name = resultSet.getString("name");
                    String url = resultSet.getString("url");
                    String length = resultSet.getString("media_length");
                    Integer mediaLength = parseMediaLength(length);

                    return new Media(id, name, url, mediaLength);
                });

        return Optional.ofNullable(media);
    }

    private Integer parseMediaLength(String length){
        if (length == null)
            return null;
        return Integer.parseInt(length);
    }
}
