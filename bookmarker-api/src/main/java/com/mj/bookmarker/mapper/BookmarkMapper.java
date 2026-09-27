package com.mj.bookmarker.mapper;

import com.mj.bookmarker.dto.BookmarkDTO;
import com.mj.bookmarker.entity.Bookmark;
import org.springframework.stereotype.Component;

@Component
public class BookmarkMapper {
    public BookmarkDTO toDTO(Bookmark bookmark){
        return BookmarkDTO.builder()
                .id(bookmark.getId())
                .title(bookmark.getTitle())
                .url(bookmark.getUrl())
                .createdAt(bookmark.getCreatedAt())
                .build();
    }
}
