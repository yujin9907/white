package site.meatacoding.white;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

// Http Method -> Mapping 기술
// get -> 주소창 하이퍼링크
// post, get -> form 태그
// put, delete, get, post -> js

// 포스트맨은 네가지 요청을 다 테스트하기 쉽게 해주는 프로그램


@RestController
public class FirstController {
	@GetMapping("/first")
	public String getData() {
		return "<h1>data</h1>";
	}
	
	@PostMapping("/first")
	public String postData() {
		return "<h1>insert Data</h1>";
	}
	@PutMapping("/first")
	public String putData() {
		return "<h1>update Data</h1>";
	}
	@DeleteMapping("/first")
	public String deleteData() {
		return "<h1>delete Data</h1>";
	}
}
