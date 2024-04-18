package com.quiz.quizTry1.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.quizTry1.domain.Bookmark1;
import com.quiz.quizTry1.mapper.BookmarkMapper1;

@Service
public class BookmarkBO1 {
	@Autowired
	private BookmarkMapper1 bookmarkMapper;
	
	public List<Bookmark1> getBookmarkList() {
		return bookmarkMapper.selectBookmarkList();
	}
	
	public void addBookmarkList(String name, String url) {
		bookmarkMapper.insertBookmarkList(name, url);
	}
	
	// input: url
	// output: boolean
	public boolean isDuplicationUrl(String url) {
		// 중복 있음:List    중복 없음: []   
		List<Bookmark1> bookmarkList = bookmarkMapper.selectBookmarkListByUrl(url);
		
		// [] => false, 비어있지 않으면 => true
		return bookmarkList.isEmpty() ? false : true;
	}
	
	public void deleteBookmarkById(int id) {
		bookmarkMapper.deleteBookmarkById(id);
	}
	
}
