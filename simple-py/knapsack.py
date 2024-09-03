def knapsack_0_1(wt, val, W, N, dp):
    if W == 0 or N == 0:
        return 0

    if dp[W][N] != -1:
        return dp[W][N]

    if wt[N-1] <= W:
        dp[W][N] = max(
            val[N-1] + knapsack_0_1(wt, val, W-wt[N-1], N-1, dp),
            knapsack_0_1(wt, val, W, N-1, dp))

    else:
        dp[W][N] = knapsack_0_1(wt, val, W, N-1, dp)

    return dp[W][N]


def isSubsetSum(set, n, sum):
    subset = ([[False for i in range(sum + 1)]
               for i in range(n + 1)])

    for i in range(n+1):
        subset[i][0] = True

    for i in range(1, n+1):
        for j in range(1, sum+1):
            if set[i-1] <= j:
                subset[i][j] = subset[i-1][j] or subset[i-1][j-set[i-1]]
            else:
                subset[i][j] = subset[i-1][j]


# Example of usage:
def main():
    W = 50
    wt = [10, 20, 30]
    val = [60, 100, 120]
    N = len(wt)

    dp = [[-1 for _ in range(N+1)] for _ in range(W+1)]

    result = knapsack_0_1(wt, val, W, N, dp)
    print("Maximum value in Knapsack =", result)


if __name__ == "__main__":
    main()
