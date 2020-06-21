package chap5RealPractice;

public class K26_p4MultiplicationTableHorizontal {
	public static void main(String[] args) {
		// 9-9 단 (진행방향: 가로)
		// 1 줄의 raw 에 3 개의 단 출력 : 3 줄의 raw
		for(int k26_i = 1; k26_i < 4; k26_i++) {
			/*--------------- <HEADER> --------------- */
			System.out.printf("************** ************** **************\n");
			for(int k26_j = 1; k26_j < 4; k26_j++) {
				// 3*(i - 1) + j : 구구단의 단 수를 의미
				System.out.printf(" 구구단  %d 단%2s",3*(k26_i - 1) + k26_j," ");
			}	// for loop end
			System.out.printf("\n");
			System.out.printf("************** ************** **************\n");
			/*--------------- </HEADER> --------------- */
			/*--------------- <BODY> --------------- */
			for(int k26_k = 1; k26_k < 10; k26_k++) {
				for(int k26_j = 1; k26_j < 4; k26_j++) {
					System.out.printf("%2s%d * %d = %2d%3s"
							, " ", 3*(k26_i - 1) + k26_j, k26_k
							, (3*(k26_i - 1) + k26_j)*k26_k, " ");
				}	// for loop end
				System.out.printf("\n");
			}	// for loop end
			/*--------------- </BODY> --------------- */
		}	// for loop end
	}	// main method end
}	// K26_p4MultiplicationTableHorizontal Class end