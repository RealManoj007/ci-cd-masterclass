package com.mj.bookmarker.repository;

import com.mj.bookmarker.dto.BookmarkDTO;
import com.mj.bookmarker.entity.Bookmark;
import com.mj.bookmarker.projection.BookmarkProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {

    @Query("SELECT new com.mj.bookmarker.dto.BookmarkDTO(b.id, b.title, b.url, b.createdAt) FROM Bookmark b")
    Page<BookmarkDTO> findBookmarks(Pageable pageable);
}