package site.meatacoding.white.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor // 세터는 얘 쪼개서 스라고
@Getter // 제이슨 파싱을 위해 필요함 메시지 컨버팅
public class RespDto<T> {
	private Integer code; // 나만의 코드, -1 실패 1 성공
	private String msg; // 성공실패 떠나서 통신 결과를 메시지로 담기
	private T body; // 제네릭을 통해 뭘 담아도 ㄱㅊ도록 object를 해도 되는데, 그럼 다운캐스팅을 해줘야돼서...
}
