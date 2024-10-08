from typing import List


def knapsack_0_1(wt, val, W, N, dp):
    if W == 0 or N == 0:
        return 0

    if dp[W][N] != -1:
        return dp[W][N]

    if wt[N - 1] <= W:
        dp[W][N] = max(
            val[N - 1] + knapsack_0_1(wt, val, W - wt[N - 1], N - 1, dp),
            knapsack_0_1(wt, val, W, N - 1, dp),
        )

    else:
        dp[W][N] = knapsack_0_1(wt, val, W, N - 1, dp)

    return dp[W][N]


def knapsack_0_1_top_down(wt, val, W, N):
    dp = [[-1 for _ in range(W + 1)] for _ in range(N + 1)]

    for i in range(N + 1):
        dp[i][0] = 0

    for j in range(W + 1):
        dp[0][j] = 0

    for n in range(1, N + 1):
        for w in range(1, W + 1):

            if wt[n - 1] <= w:
                dp[n][w] = max(val[n - 1] + dp[n - 1][w - wt[n - 1]], dp[n - 1][w])
            else:
                dp[n][w] = dp[n - 1][w]

    return dp[N][W]


# Example of usage:
def main():
    W = 50
    wt = [10, 20, 30]
    val = [60, 100, 120]
    N = len(wt)

    dp = [[-1 for _ in range(N + 1)] for _ in range(W + 1)]

    result = knapsack_0_1(wt, val, W, N, dp)
    print("Knapsack = ", result)


if __name__ == "__main__":
    main()
