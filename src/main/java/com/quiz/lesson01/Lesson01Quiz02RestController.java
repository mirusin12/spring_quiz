package com.quiz.lesson01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("lesson01/quiz02")
@RestController
public class Lesson01Quiz02RestController {
	// http://localhost:8080/lesson01/quiz02/1
	@RequestMapping("/1")
	public List<Map<String, Object>> quiz02_1() {
		List<Map<String, Object>> list = new ArrayList<>();
		Data data1 = new Data();
		data1.setRate(15);
		data1.setDirector("봉준호");
		data1.setTime(131);
		data1.setTitle("기생충");
		Map<String, Object> map1 = new HashMap<>();
		map1.put("rate", data1.getRate());
		map1.put("director", data1.getDirector());
		map1.put("time", data1.getTime());
		map1.put("title", data1.getTitle());
		
		
		Data data2 = new Data();
		data2.setRate(0);
		data2.setDirector("도베르토 베니니");
		data2.setTime(116);
		data2.setTitle("인생은 아름다워");
		Map<String, Object> map2 = new HashMap<>();
		map2.put("rate", data2.getRate());
		map2.put("director", data2.getDirector());
		map2.put("time", data2.getTime());
		map2.put("title", data2.getTitle());
		
		
		Data data3 = new Data();
		data3.setRate(12);
		data3.setDirector("크리스토퍼 놀란");
		data3.setTime(147);
		data3.setTitle("인셉션");
		Map<String, Object> map3 = new HashMap<>();
		map3.put("rate", data3.getRate());
		map3.put("director", data3.getDirector());
		map3.put("time", data3.getTime());
		map3.put("title", data3.getTitle());
		
		
		Data data4 = new Data();
		data4.setRate(19);
		data4.setDirector("윤종빈");
		data4.setTime(133);
		data4.setTitle("범죄와의 전쟁 : 나쁜놈들 전성시대");
		Map<String, Object> map4 = new HashMap<>();
		map4.put("rate", data4.getRate());
		map4.put("director", data4.getDirector());
		map4.put("time", data4.getTime());
		map4.put("title", data4.getTitle());
		
		
		Data data5 = new Data();
		data5.setRate(15);
		data5.setDirector("프란시스 로렌스");
		data5.setTime(137);
		data5.setTitle("헝거게임");
		Map<String, Object> map5 = new HashMap<>();
		map5.put("rate", data5.getRate());
		map5.put("director", data5.getDirector());
		map5.put("time", data5.getTime());
		map5.put("title", data5.getTitle());
		
		list.add(map1);
		list.add(map2);
		list.add(map3);
		list.add(map4);
		list.add(map5);
		
		return list;
	}
	// 2번 ////////////////////////////////////
	// http://localhost:8080/lesson01/quiz02/2
	@RequestMapping("/2")
	public List<introduce> quiz02_2() {
		// @ResponseBody + return String => HttpMessageConverter HTML
		// @ResponseBody + return 객체(Map, 클래스, List) => HttpMessageConverter => jackson lib => JSON
		
		List<introduce> list2 = new ArrayList<>();
		introduce intro1 = new introduce();
		intro1.setTitle("안녕하세요 가입인사 드립니다.");
		intro1.setUser("marobiana");
		intro1.setContent("안녕하세요. 가입했어요. 앞으로 잘 부탁드립니다. 활동 열심히 하겠습니다.");
		
		introduce intro2 = new introduce();
		intro2.setTitle("헐 대박");
		intro2.setUser("baba");
		intro2.setContent("오늘 목요일이었어... 금요일인줄");
		
		introduce intro3 = new introduce();
		intro3.setTitle("오늘 데이트 한 이야기 해드릴게요.");
		intro3.setUser("dulumary");
		intro3.setContent("...");
		
		list2.add(intro1);	
		list2.add(intro2);	
		list2.add(intro3);	
		return list2;
		
	}
	
	// 3번 ////////////////////////////////////
	// http://localhost:8080/lesson01/quiz02/3
	@RequestMapping("/3")
	public ResponseEntity<introduce> quiz02_3() {
		
		introduce intro1 = new introduce();
		intro1.setTitle("안녕하세요 가입인사 드립니다.");
		intro1.setUser("marobiana");
		intro1.setContent("안녕하세요. 가입했어요. 앞으로 잘 부탁드립니다. 활동 열심히 하겠습니다.");
		
		return new ResponseEntity<>(intro1, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
}
