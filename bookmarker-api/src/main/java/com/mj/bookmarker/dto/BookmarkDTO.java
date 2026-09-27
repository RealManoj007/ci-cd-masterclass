package com.mj.bookmarker.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Component
public class BookmarkDTO {
    private Long id;
    private String title;
    private String url;
    private Instant createdAt;
}
