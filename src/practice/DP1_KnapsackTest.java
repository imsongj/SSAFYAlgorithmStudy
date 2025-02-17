package practice;

import java.util.Scanner;

//배낭채우기 : 보석개수 1개 버전
/**
 * @author taeheekim
 */
public class DP1_KnapsackTest {
 
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int W = sc.nextInt();
		
		int[] weights = new int[N+1];
		int[] profits = new int[N+1];

		int[] results = new int[W+1];
		
		// i=0은 0으로 그대로 둠.
		for (int i = 1; i <=N; i++) {
			weights[i] = sc.nextInt();
			profits[i] = sc.nextInt();
		}
		int itemWeight = 0, itemBenefit = 0; 
		// 모든 아이템에 대해서 반복
		for (int item = 1; item <= N; item++) {
			itemWeight = weights[item]; // 현 아이템의 무게	
			itemBenefit = profits[item]; // 현 아이템의 가치
			
			// 현 아이템의 1부터 목표무게 까지의 가치테이블을 만든다.
			for (int weight = W; weight > 0; weight--) {
				// 현 아이템의 무게가 가치테이블을 만들기 위한 무게보다 작거나 같다면
				// 선텍 가능하며, 아래 둘중 최대 가치를 선택한다.
				//  1) 현 아이템을 선택하지 않았을 경우의 가치는 가치테이블에서 같은 무게의 이전아이템까지의 가치
				//  2) 현 아이템을 선택했을때의 가치와 가치테이블에서 해당 아이템의 무게만큼 뺀 무게의 이전아이템까지의 가치
				if(itemWeight <= weight){	
					results[weight] = Math.max(results[weight], itemBenefit+results[weight-itemWeight]);
				}
			}
		}
		
		System.out.println(results[W]);
		sc.close();
	}

}
