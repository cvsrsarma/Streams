package com.org.streams.first.jpmhackerrank;

import java.util.Arrays;

public class CoinChange {

	public static void main(String[] args) {
	

	}
	public static int coinChange(int[] coins, int amount) {
		int[] dp = new int[amount + 1];
		dp[0] = 0;
		for(int i=0; i<=amount;i++) {
			for(int coin:coins) {
				if(coin<=i) {
					dp[i]=Math.min(dp[i], dp[i-coin]+1);
				}
			}
		}
		return dp[amount] > amount ? -1 : dp[amount];
	}
    public static int coinChange1(int[] coins, int amount) {
        
        int[] dp = new int[amount + 1];
        int max = amount + 1;
        Arrays.fill(dp, max);

        dp[0] = 0;

        for(int coin: coins) {

            for(int i = coin; i <= amount; i++) {

                dp[i] = Math.min(dp[i], dp[i-coin] + 1);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
