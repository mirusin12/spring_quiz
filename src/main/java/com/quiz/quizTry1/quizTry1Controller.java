package com.quiz.quizTry1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.quizTry1.bo.BookmarkBO1;
import com.quiz.quizTry1.domain.Bookmark1;

@RequestMapping("/quizTry1")
@Controller // view에 보내주는 역할
public class quizTry1Controller {
	@Autowired
	private BookmarkBO1 bookmarkBO1;
	
	
	// 즐겨찾기 추가하기 화면
	// http://localhost:8080/quizTry1/add-bookmark-view
	@GetMapping("/add-bookmark-view")
	public String addBookmarkView() {
		return "quizTry1/addBookmark1";
	}
	
	// AJAX요청 즐겨찾기 추가하기
	@ResponseBody
	@PostMapping("/add-bookmark")
	public Map<String, Object> addBookmark(
			@RequestParam("name") String name
			, @RequestParam("url") String url) {
		
		// db insert
		bookmarkBO1.addBookmarkList(name, url);
		
		// 성공 여부
		// JSON String
		// {"code":200, "result":"성공"}
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("result", "성공");
		return result; // JSON String
	}
	
	
	// 즐겨찾기 목록
	// http://localhost:8080/quizTry1/bookmark-list-view
	@GetMapping("/bookmark-list-view")
	public String bookmarkListView(Model model) {
		List<Bookmark1> bookmarkList = bookmarkBO1.getBookmarkList();
		model.addAttribute("bookmarkList", bookmarkList);
		return "quizTry1/bookmarkList1";
	}
	
	// 즐겨찾기 중복 검사 - AJAX
	@ResponseBody
	@PostMapping("/is-duplication-url")
	public Map<String, Object> isDuplicationUrl (
			@RequestParam("url") String url) {
		
		// db select
		boolean isDuplication = bookmarkBO1.isDuplicationUrl(url);
		
		
		// 응답값 JSON
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("is_duplication", isDuplication);
		return result;
	}
	
	// 즐겨찾기 삭제 - AJAX 요청
	@ResponseBody
	@DeleteMapping("/delete-bookmark")
	// @GetMapping("/delete-bookmark")
	public Map<String, Object> deleteBookmark(
			@RequestParam("id") int id) {
		
		// delete db
		bookmarkBO1.deleteBookmarkById(id);
		
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("result", "성공");
		return result;
	}
	
	
	
	
	
	
	
	
}
