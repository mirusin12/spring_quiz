package com.quiz.quizTry1.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.quiz.quizTry1.domain.Bookmark1;

@Mapper
public interface BookmarkMapper1 {
	public List<Bookmark1> selectBookmarkList();
	
	public void insertBookmarkList(
			@Param("name") String name
			, @Param("url") String url);
	
	// input: url  output: List<Bookmark>
	public List<Bookmark1> selectBookmarkListByUrl(String url);
	
	public void deleteBookmarkById(int id);
}
