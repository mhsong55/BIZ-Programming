package chap5RealPractice;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class K26_p7Receipt1 {

	public static void main(String[] args) {
		int k26_iPrice = 11;	// 주문 합계
		int k26_discountVal = 0;	// 할인 금액
		int k26_point = 0;			// 포인트
		
		int k26_cash = 0;			// 현금
		int k26_card = k26_iPrice;	// 카드
		
		double k26_taxRate = 10;	// 세율 (10 %)
		int k26_taxFreeVal = 0;		// 면세 총액
		// 과세액, 부동 소수점 문제 해결
		double k26_taxation = k26_iPrice / (100 + k26_taxRate) * 100;
		int k26_iTaxation = (int) k26_taxation;	// 세전가격은 항상 버림 처리
						
		// 세액은 항상 올림 처리
		double k26_tax = k26_iTaxation * k26_taxRate/100;
		int k26_iTax;
		/* 실수형 전체 환전 수수료 -> 정수로 형변환 -> 다시 실수형으로 형변환 했을 때 
		 * 원상복귀가 된다는 것은 소수점 이하 숫자가 존재한다는 뜻*/
		if (k26_tax != (double) ((int) k26_tax)) {	// 소수점 이하 숫자가 있다면
			k26_iTax = (int) k26_tax + 1;			// 올림 처리해준다.
		} else {							// 소수점 이하 숫자가 없다면 == 정수
			k26_iTax = (int) k26_tax;		// 정수형으로 형변환
		}
		
		// k26_totalPrice = 받을 금액
		int k26_totalPrice = k26_iPrice - k26_discountVal - k26_point - k26_taxFreeVal;
		// k26_receipt = 영수 금액
		int k26_receipt = k26_cash + k26_card;
		// CASHIER
		String k26_cashier = "직원";
		
		/* DecimalFormat 클래스는 format method를 사용해 특정 패턴으로 값을 포맷할 수 있다
		 * 반환값의 type = String, 패턴형식의 지정은 '0', '#'을 사용해서 가능하다.
		 * "0.###", "000.###", "00.#" 등으로 패턴 지정 가능 
		 * 예를 들어 78.53981633 의 경우
		 * "0.###" : 78.54, "000.##" : 078.54, "00.#" : 78.5 
		 * "###,###,###,###,###" : 100조까지 3자리 단위로 ","를 끊어 표시하기 */
		DecimalFormat k26_dFormat = new DecimalFormat("###,###,###,###,###");
		
		Calendar k26_calTime = Calendar.getInstance();	// System의 현재 시간을 얻기 위한 Calendar instance 생성
		
		// Date type의 format을 지정하기 위한 SimpleDateFormat instance 생성
		SimpleDateFormat k26_sdfY4M2d2H2m2s2 = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
		SimpleDateFormat k26_sdfY4M2d2H2m2 = new SimpleDateFormat("YYYY-MM-dd HH:mm");
		
		/*----------------- <Header> -----------------*/
		System.out.printf("%15s영  수  증\n", " ");	// 전체 가로 길이 = 41
		System.out.printf("-----------------------------------------\n");
		System.out.printf("종로상회(분당서현점)%2s129-17-77924\n", " ");
		System.out.printf("이상철%2s031 781 1596\n", " ");
		System.out.printf("성남시 분당구 서현동 269-3\n");
		/*----------------- </Header> -----------------*/
		/*----------------- <Body> -----------------*/
		System.out.printf("테이블명 : 12\n");
		System.out.printf("주문번호 : 20160425 01 00041\n");
		System.out.printf("-----------------------------------------\n");
		System.out.printf("주문합계%33.33s\n", k26_dFormat.format(k26_iPrice));		// iPrice 33글자까지 출력 가능
		System.out.printf("할인금액%33.33s\n", k26_dFormat.format(k26_discountVal));	// discountVal 33글자까지 출력 가능
		System.out.printf("받을금액%33.33s\n", k26_dFormat.format(k26_totalPrice));	// totalPrice 33글자까지 출력 가능
		System.out.printf("-----------------------------------------\n");
		System.out.printf("현  금%13.13s%3s과  세%13.13s\n"
				, k26_dFormat.format(k26_cash), " ", k26_dFormat.format(k26_iTaxation));	// cash, taxation 13글자까지
		System.out.printf("카  드%13.13s%3s세  액%13.13s\n"
				, k26_dFormat.format(k26_card), " ", k26_dFormat.format(k26_iTax));	// card, tax 13글자까지 출력 가능
		System.out.printf("포인트%13.13s%3s면  세%13.13s\n"	// 42 - 12 = 30
				, k26_dFormat.format(k26_point), " ", k26_dFormat.format(k26_taxFreeVal));	// point, taxFreeVal 13글자까지
		System.out.printf("%22s영수금액%11.11s\n", " ", k26_dFormat.format(k26_receipt));	// receipt 11글자까지
		System.out.printf("-----------------------------------------\n");
		System.out.printf("%10s[우리카드 신용 승인]\n", " "); // 41 - 20 = 21
		
		// Calender Class의 getTime method로 System 상 현재 시간을 k26_simpleDateFormat 형태로 출력
		System.out.printf("승 인 일 시 : %s\n", k26_sdfY4M2d2H2m2s2.format(k26_calTime.getTime()));
		System.out.printf("카 드 번 호 : 55222059****2021\n");
		// %02d : 정수를 포함하여 2칸의 공간을 확보. 빈 공간은 0으로 채운다
		System.out.printf("승 인 번 호 : 79753574  할부개월 : %02d\n", 0);	
		System.out.printf("승 인 금 액 : %.27s\n", k26_dFormat.format(k26_receipt));	// receipt 27 글자까지
		System.out.printf("가 맹 번 호 : 730461774%2s/%2s비씨카드사\n", " ", " ");
		System.out.printf("사업자 번호 : 129-17-77924\n");
		System.out.printf("-----------------------------------------\n");
		/*----------------- </Body> -----------------*/
		/*----------------- <Tail> -----------------*/
		System.out.printf("%s%2sCASHIER :%12.12s\n"	// 전체 가로 길이 : 41
				, k26_sdfY4M2d2H2m2.format(k26_calTime.getTime())
				, " ", k26_cashier);
		System.out.printf("-----------------------------------------\n");
		System.out.printf("감사 합니다.");
		/*----------------- </Tail> -----------------*/
	}
}