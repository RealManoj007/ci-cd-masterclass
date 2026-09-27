package com.mj.bookmarker.service;

import com.mj.bookmarker.dto.BookmarkDTO;
import com.mj.bookmarker.dto.BookmarksDTO;
import com.mj.bookmarker.mapper.BookmarkMapper;
import com.mj.bookmarker.projection.BookmarkProjection;
import com.mj.bookmarker.repository.BookmarkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class BookmarkService {

    private final BookmarkRepository bookmarkRepository;
    private final BookmarkMapper bookmarkMapper;

    @Transactional(readOnly = true)
    public BookmarksDTO getBookmarks(Integer page){
        int pageNo = page<1?0:page -1;
        Pageable pageable = PageRequest.of(pageNo, 10, Sort.Direction.DESC, "createdAt");
        Page<BookmarkDTO> bookmarkDTOPage = bookmarkRepository.findBookmarks(pageable);
        return new BookmarksDTO(bookmarkDTOPage);
    }

}
