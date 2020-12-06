package com.silklee.video.model.entity;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import lombok.experimental.Tolerate;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Data
@SuperBuilder
public class Chapter {

    private int id;

    private int videoId;

    private String title;

    private List<Episode> episodeList;

    @Tolerate
    public Chapter() {
        super();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chapter chapter = (Chapter) o;
        return id == chapter.id &&
                videoId == chapter.videoId &&
                Objects.equals(title, chapter.title) &&
                Objects.equals(episodeList, chapter.episodeList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, videoId, title, episodeList);
    }
}
