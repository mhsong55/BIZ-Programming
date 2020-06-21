package chap5RealPractice;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

class K26_Item {
	private String k26_name;
	private String k26_barcode;
	private int k26_unitPrice;
	private int k26_amount;
	
	public K26_Item(String k26_name, String k26_barcode, int k26_unitPrice, int k26_amount) {
		this.k26_name = k26_name;
		this.k26_barcode = k26_barcode;
		this.k26_unitPrice = k26_unitPrice;
		this.k26_amount = k26_amount;
	}
	public String k26_getName() {
		return k26_name;
	}
	public void k26_setName(String name) {
		this.k26_name = name;
	}
	public String k26_getBarcode() {
		return k26_barcode;
	}
	public void k26_setBarcode(String barcode) {
		this.k26_barcode = barcode;
	}
	public int k26_getUnitPrice() {
		return k26_unitPrice;
	}
	public void k26_setUnitPrice(int unitPrice) {
		this.k26_unitPrice = unitPrice;
	}
	public int k26_getAmount() {
		return k26_amount;
	}
	public void k26_setAmount(int amount) {
		this.k26_amount = amount;
	}
}

public class K26_p8Receipt2 {
	public static void main(String[] args) {
		List<K26_Item> k26_itemList = new ArrayList<>();
		K26_Item k26_water = new K26_Item("풀무원샘물", "8809169718205", 600, 1); 
		K26_Item k26_drinkYoghurt = new K26_Item("드링킹요구르트(딸기외2종)", "8801155822828", 1600, 1);
		
		k26_itemList.add(k26_water);
		k26_itemList.add(k26_drinkYoghurt);
		
		/* DecimalFormat 클래스는 format method를 사용해 특정 패턴으로 값을 포맷할 수 있다
		 * 반환값의 type = String, 패턴형식의 지정은 '0', '#'을 사용해서 가능하다.
		 * "0.###", "000.###", "00.#" 등으로 패턴 지정 가능 
		 * 예를 들어 78.53981633 의 경우
		 * "0.###" : 78.54, "000.##" : 078.54, "00.#" : 78.5 
		 * "###,###,###,###,###" : 100조까지 3자리 단위로 ","를 끊어 표시하기 */
		DecimalFormat k26_dFormat = new DecimalFormat("###,###,###,###,###");
		
		Calendar k26_calTime = Calendar.getInstance();	// System의 현재 시간을 얻기 위한 Calendar instance 생성
		SimpleDateFormat k26_sdfY4M2d2H2m2s2Space1 = new SimpleDateFormat("YYYYMMdd HHmmss");
		SimpleDateFormat k26_sdfY4M2d2H2m2s2Space0 = new SimpleDateFormat("YYYYMMddHHmmss");
		SimpleDateFormat k26_sdfY4M2d2 = new SimpleDateFormat("YYYY/MM/dd");
		String k26_cardNumber = "5522-20**-****-BADD";
		
		// 가로 전체 길이 : 42
		/*------------ HEADER ------------*/
		System.out.printf("충주(양평)휴게소\n");
		System.out.printf("충북충주시가금면용전리380-4\n");
		System.out.printf("최병권 677-85-00239 TEL:043-857-9229\n");
		System.out.printf("\n\n");
		
		System.out.printf("[정상등록]%s%4sPOS번호: 0002\n"
				, k26_sdfY4M2d2H2m2s2Space1.format(k26_calTime.getTime())," ");
		System.out.printf("------------------------------------------\n");
		System.out.printf("품목코드%15s단가%2s수량%5s금액\n"," "," "," ");
		System.out.printf("------------------------------------------\n");
		/*------------- BODY -------------*/
		for(K26_Item item : k26_itemList) {
			System.out.printf("%s\n",item.k26_getName());
			System.out.printf("%s%14s%6d%9s\n"
					,item.k26_getBarcode()
					,k26_dFormat.format(item.k26_getUnitPrice())
					,item.k26_getAmount()
					,k26_dFormat.format(item.k26_getUnitPrice() * item.k26_getAmount()));
		}
		System.out.printf("\n");
		System.out.printf("과세 물품 합계%28s\n", k26_dFormat.format(2000)); // 42 - 14 = 28
		System.out.printf("부%4s가%4s세%28s\n"," ", " ", k26_dFormat.format(200)); // 42 - 14 = 28
				System.out.printf("합%10s계%28s\n", " ", k26_dFormat.format(2200));
		System.out.printf("026-비씨카드사%28s\n","00/00A");
		System.out.printf("카%2s드%2s번%2s호 :%26s\n"," "," "," ",k26_cardNumber);
		System.out.printf("카%2s드%2s매%2s출 :%26s\n"," "," "," ",k26_dFormat.format(2200));
		System.out.printf("거%2s래%2s구%2s분 :%23s\n"," "," "," ","일시불");
		System.out.printf("승%2s인%2s번%2s호 : 04-KICC%18d\n"," "," "," ",75549250);
		System.out.printf("가 맹 점 번 호 :\n");
		System.out.printf("받%2s은%2s금%2s액 :%26s\n"," "," "," ",k26_dFormat.format(2200));
		System.out.printf("거%4s스%4s름 :%26s\n"," "," ",k26_dFormat.format(0));
		/*------------- TAIL -------------*/
		System.out.printf("------------------------------------------\n");
		System.out.printf("주문번호:%12s\n","0920");
		System.out.printf("------------------------------------------\n");
		System.out.printf("판매원 : %06d %s\n",2,"편의점2");
		System.out.printf("%s-0002-0922\n",k26_sdfY4M2d2.format(k26_calTime.getTime()));
		System.out.printf("연동모듈:[00138705%2s%s]\n"," ",k26_sdfY4M2d2H2m2s2Space0.format(k26_calTime.getTime()));
	}
}