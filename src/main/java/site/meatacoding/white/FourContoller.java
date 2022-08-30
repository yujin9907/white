package site.meatacoding.white;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import site.meatacoding.white.domain.Four;
import site.meatacoding.white.dto.RespDto;

@RestController // 이걸 거는 순간 ioc 컨테이너에 등록됨. 디스패처서블릿은 ioc 컨트룰러에 있는 컨트룰러를 가져와 때리는 거
public class FourContoller {

	@GetMapping("/four")
	public Four getData() {
		Four four = new Four();
		four.setTitle("제목");
		four.setContent("내용");
		
		return four; // 디스패처서블릿이 얘를 제이슨으로 변경해서 리턴함
		// ds 가 four 오브젝트를 받아서 해당 오브젝트를 메시지 컨버터에게 전달함
		// 스프링 웹 mvc, 라이브러리로 메시지 컨버터 자동 적용
		// 리턴 타입이 string이 아닌 다른 게 왔을 때, 파싱
		// 디폴트 파싱전략이 json
		// json 형식으로 받은 데이터를 자바 오브젝트로 바꿔 로직을 처리해주고 리턴은 다시 json으로(단 받을 때 기본값은 x-www임.. ㅠ)-> 지금은 json 형식을 받으려면
		// requestbody를 파라미터에 걸어줘야 됨
		// 즉 ds가 하는 일은 gson g = new gson(), tojson() 하는 귀찮은 일을 해줌
		// 메시지 컨버터는 실제로 get를 건드려 접근했을 거임, 즉 데이터를 리턴하고 싶으면 오브젝트를 만들면 됨
		// 단 통신시에는 이런 식으로 리턴하면 안 좋음
	}
	
	@GetMapping("/four/data")
	public ResponseEntity<Four> getData2() {
		Four four = new Four();
		four.setTitle("제목");
		four.setContent("내용");
		ResponseEntity<Four> response = new ResponseEntity<>(four, HttpStatus.OK); // 응답을 위한 엔티티, 원래 상태코드를 같이 보내줌 : 프로토콜
		return response;
	}
	// 더 나은 방법, 상태코드만 추가됨. 상태코드를 보면서 어떤 상탠지 알 수 있음(프론트앤드개발자나 뭐...) 즉 정보를 전달해줄 수 있음. 상태코드로
	
	// 와일드카드, 뭘 리턴하든 됨 ? extends object 라는 뜻, 
	public ResponseEntity<?> getData3() {
		Four four = new Four();
		four.setTitle("제목");
		four.setContent("내용");
		ResponseEntity<Four> response = new ResponseEntity<>(four, HttpStatus.OK); // 응답을 위한 엔티티, 원래 상태코드를 같이 보내줌 : 프로토콜
		return response;
	}
	// 바디값만으로는 통신이 잘 된 건지 알수가 없음. 리턴이 없는지 하난지 알 수 없기 때문에(나혼자개발하는 거 아니면)
	
	//http 상태코드 대신 나만의 코드만들어줄 수도 있음. 
	//http 상태코드는 헤더로 알려주고, 이건 바디에 오류 데이터를 보내주는 거. 
	//우리는 뷰 리졸버로 데이터를 받아오기 때문에 respDto 리턴 타입을 하지 않음(이렇게 안 함 그럼 어케?)
	// 오늘 이 코드들은 짤 수 있어야 됨. 디스패처는 몰라도 됨
	// 왜 오류를 굳이 보내주냐? 서버에서 오류가 나지 않더라도 '오류'인 경우가 있음. 30번 데이터가 없으면 오류처리 아니지만 어쨋든 오류 결과. 이런 경우를 표시해주기 위해서
	@GetMapping("/four/dto")
	public RespDto<Four> getData4() {
		Four four = new Four();
		four.setTitle("제목");
		four.setContent("내용");
		return new RespDto<>(1, "성공", four);
	}
}
