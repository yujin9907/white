package site.meatacoding.white;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import site.meatacoding.white.domain.Third;

// 고급데이터받기 (json, x-www, text) 

@RestController
public class ThirdController {

	// get은 바디데이터를 못 받음
	@GetMapping("/third/{id}")
	public String getData(@PathVariable Integer id) {
		return "id : "+id;
	}
	// 바디데이터를 오브젝트로 받을 수 있음, 이런 오브젝트를 리퀘스트 dto라고 함(객체를 일일이 안 받아와도 됨)
	@PostMapping("/third")
	public String postData(Third third) {
		return "id : " +third.getId()+", title :"+third.getTitle()+", content:"+third.getContent();
	}
	// update third set title =?, content = ? where id = ?
	// where 절에 걸리는 건 무조건 주소로 받음 => 프로토콜 // 백엔드 개발자가 쿼리를 인식할 수 있도록 하는 약속임.
	// 2번데이터의 컨텐트를 수정, 2를 어떻게? 패스베리어블로 왜? 기본키니까
	
	// pumapping("/third")로 하고 그냥 바디에 담아준다면, id도 바꾸는 건 줄 알거임 근데 아이디는 기본킨데?... 이런 불필요한 질문이 생길 걸 프로토콜로 방지
	@PutMapping("/third/{id}/json")
	public String putData(@PathVariable Integer id, @RequestBody Third third) {
		return third.toString(); // 위의 리턴과정을 tostring으로 간단하게 할 수 있음
	}
	
	// 정리 : localhost:8000/third/1 PUT으로 요청
	// 로컬호스트 팔천에, 서드 테이블에, 기본키 1번을 업데이트하겟다
}
