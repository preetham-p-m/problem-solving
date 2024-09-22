from typing import List


def knapsack_unbounded(weights: List[int], profit: List[int], W: int):

    N = len(profit)

    dp = [[0 for _ in range(W + 1)] for _ in range(N + 1)]

    for n in range(1, N + 1):
        for w in range(1, W + 1):
            if weights[n - 1] <= w:
                dp[n][w] = max(dp[n - 1][w], profit[n - 1] + dp[n][w - weights[n - 1]])
            else:
                dp[n][w] = dp[n - 1][w]

    return dp[N][W]
