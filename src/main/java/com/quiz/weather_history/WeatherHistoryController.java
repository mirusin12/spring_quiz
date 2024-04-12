package com.quiz.weather_history;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.weather_history.bo.WeatherHistoryBO;
import com.quiz.weather_history.domain.WeatherHistory;

@RequestMapping("/weather-history")
@Controller
public class WeatherHistoryController {
	
	@Autowired
	private WeatherHistoryBO weatherHistoryBO;
	
	// http://localhost:8080/weather-history/weather-history-view
	// 날씨 목록 화면
	@GetMapping("/weather-history-view")
	public String weatherHistoryView(Model model) {
		List<WeatherHistory> weatherHistoryList =  weatherHistoryBO.getWeatherHistoryList();
		model.addAttribute("weatherHistoryList", weatherHistoryList);
		return "weather_history/weatherList";
	}
	
	// http://localhost:8080/weather-history/add-weather-view
	// 날씨 추가 화면
	@GetMapping("/add-weather-view")
	public String addWeatherView(Model model) {
		
		return "weather_history/addWeather";
	}
	
	// 날씨 추가
	@PostMapping("/add-weather")
	public String addWeather(
			@RequestParam("date") @DateTimeFormat(pattern="yyyy-MM-dd") Date date,
			@RequestParam("weather") String weather,
			@RequestParam("microDust") String microDust,
			@RequestParam("temperatures") double temperatures,
			@RequestParam("precipitation") double precipitation,
			@RequestParam("windSpeed") double windSpeed) {
		// db insert
		weatherHistoryBO.addWeatherHistory(date, weather, microDust, temperatures, precipitation, windSpeed);
		
		// 목록 화면 => 302 redirect
		return "redirect:/weather-history/weather-history-view";
		
	}
	
	
}
