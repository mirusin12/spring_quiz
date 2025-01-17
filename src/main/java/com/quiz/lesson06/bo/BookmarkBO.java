package com.quiz.lesson06.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson06.domain.Bookmark;
import com.quiz.lesson06.mapper.BookmarkMapper;

@Service
public class BookmarkBO {
	
	@Autowired
	private BookmarkMapper bookmarkMapper;

	public void addBookmark(String name, String url) {
		bookmarkMapper.insertBookmark(name, url);
	}
	
	public List<Bookmark> getBookmarkList() {
		return bookmarkMapper.selectBookmarkList();
	}
	
	// input: url
	// output: boolean
	public boolean isDuplicationUrl(String url) {
		// 중복 있음:List     중복 없음:[]
		List<Bookmark> bookmarkList = bookmarkMapper.selectBookmarkListByUrl(url);
		// [] => false, 비어있지 않으면 => true
		return bookmarkList.isEmpty() ? false : true;
	}
	
	public void deleteBookmarkById(int id) {
		bookmarkMapper.deleteBookmarkById(id);
	}
}
