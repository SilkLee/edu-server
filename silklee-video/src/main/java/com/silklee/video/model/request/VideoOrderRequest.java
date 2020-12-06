package com.silklee.video.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import lombok.experimental.Tolerate;

@Data
@SuperBuilder
public class VideoOrderRequest {

    @JsonProperty("video_id")
    private int videoId;

    @Tolerate
    public VideoOrderRequest() {
        super();
    }
}
