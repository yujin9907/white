package site.meatacoding.white;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

// 데이터 받기
// 아래 규칙을 알아야 됨 이해 x 

// get => QueryString => form 태그 가능 => 브라우저에서 주소 뒤?붙여서 가능
	// 기본키질의는 패스베리어블로( dfjl:8000/board/1), 다른 컬럼은 쿼리스트링으로 (sdlkf:8000/board/?content=스프링) ; 요즘 프로토콜
// 데이터를 주는 게 아니라, 쿼리스트링으로 구체적 질의를 추가한 요청 => 바디 없음 
// post, put => 데이터를 주는 거, http body에 데이터를 담아 전송(헤더는 정보에 대한 정보로 포함됨) -> form(post 요청) -> js 가능
// delete => 데이터를 주는 게 아니라, 뭘 삭제해줘의 구체적 질의를 추가한 요청 
	// 겟과 비슷한 형식으로 요청 => 바디 없음 => 쿼리스트링, 패스베리어블(프라이머리키일 때만 사용 가능)

@RestController // 메모리에 띄우기
public class SecondController {
	@GetMapping("/second/{id}")
	public String getData(@PathVariable Integer id) {
		// pk가 1인 걸 찾기
		return "id : "+id;
	}
	
	// 겟 = 주소 = 쿼리스트링은 x-www-form~ 타입. 바디 데이터를 담지 않음. 바디 내용 못 담음.
	@GetMapping("/second")
	public String getData2(String title, String content) {
		return "title : "+title+", content : "+content;
	}
	
	// 주소가 아닌 바디에 데이터를 담아(쿼리스트링도 파싱해서 받을 순 있지만 프로토콜!) = 바디데이터는 형식이 여러가지임. 바디든 쿼리든 다 받음.
	@PostMapping("/second")
	public String postData(String title, String content) {
		return "title : "+title+", content : "+content;
	}
	
	@PutMapping("/second")
	public String putData(String title, String content) {
		return "title : "+title+", content : "+content;
	}
	@DeleteMapping("/second/{id}")
	public String deleteData(@PathVariable Integer id) {
		return id+" delete ok";
	}
	
}
