package com.mj.bookmarker.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mj.bookmarker.entity.Bookmark;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookmarksDTO {
    List<BookmarkDTO> data;
    long totalElements;
    int totalPages;
    int currentPages;
    @JsonProperty("isFirst")
    boolean isFirst;
    @JsonProperty("isLast")
    boolean isLast;
    boolean hasNext;
    boolean hasPrevious;

    public BookmarksDTO(Page<BookmarkDTO> bookmarkPage) {
        this.setData(bookmarkPage.getContent());
        this.setTotalElements(bookmarkPage.getTotalElements());
        this.setTotalPages(bookmarkPage.getTotalPages());
        this.setCurrentPages(bookmarkPage.getNumber()+1);
        this.setFirst(bookmarkPage.isFirst());
        this.setLast(bookmarkPage.isLast());
        this.setHasNext(bookmarkPage.hasNext());
        this.setHasPrevious(bookmarkPage.hasPrevious());

    }
}
