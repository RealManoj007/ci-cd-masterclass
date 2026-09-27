package com.mj.bookmarker.projection;

import jakarta.persistence.Column;

import java.time.Instant;

public interface BookmarkProjection {
    Long getId();
    String getTitle();
    String getUrl();
    Instant getCreatedAt();
}
