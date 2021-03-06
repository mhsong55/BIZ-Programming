package chap4SelecIterArray;

import java.text.DecimalFormat;

public class K26_p27SpaceFitting {
	public static void main(String[] args) {
		// 칸 맞추기 실습
		String k26_item = "사과";	// Item의 이름을 저장할 String 변수
		int k26_unit_price = 5000;	// Item의 단가를 저장할 int 변수
		int k26_num = 100;		// Item의 수량을 저장할 int 변수
		int k26_total = 0;		// Item의 총 가격을 저장할 int 변수
		
		/* DecimalFormat 클래스는 format method를 사용해 특정 패턴으로 값을 포맷할 수 있다
		 * 반환값의 type = String, 패턴형식의 지정은 '0', '#'을 사용해서 가능하다.
		 * "0.###", "000.###", "00.#" 등으로 패턴 지정 가능 
		 * 예를 들어 78.53981633 의 경우
		 * "0.###" : 78.54, "000.##" : 078.54, "00.#" : 78.5 
		 * "###,###,###,###,###" : 100조까지 3자리 단위로 ","를 끊어 표시하기 */
		DecimalFormat k26_df = new DecimalFormat("###,###,###,###,###");
		
		/*--------------- <HEADER> --------------- */
		System.out.printf("==========================================================\n");
		/* %20.20s 
		 * - 점 앞의 20은 문자열을 포함하여 20s의 공간을 확보 (오른쪽 정렬) 
		 * - 점 뒤의 20은 문자열을 20글자까지 출력하라는 의미
		 * - 주의] 한글을 1s로 인식한다 */
		System.out.printf("%20.20s%8.8s%8.8s%8.8s\n", "품목","단가","수량","합계");
		System.out.printf("==========================================================\n");
		/*--------------- </HEADER> --------------- */
		/*--------------- <BODY> --------------- */
		System.out.printf("%20.20s%10.10s%10.10s%10.10s\n"
				, k26_item, k26_df.format(k26_unit_price)	// comma를 적용해 unit_price 출력
				, k26_df.format(k26_num)					// comma를 적용해 num 출력
				, k26_df.format(k26_unit_price * k26_num));	// comma를 적용해 전체 가격 출력
		/*--------------- </BODY> --------------- */
		/*--------------- <TAIL> --------------- */
		System.out.printf("==========================================================\n");
		/*--------------- </TAIL> --------------- */
	}
}