from typing import List


def min_number_of_coin(coins: List[int], amount: int) -> int:

    N = len(coins)
    # It is initialized to (infinity - 1) because in the following step, if we add +1 to infinity, it will become a negative number. Therefore, we initialize it to infinity - 1.
    dp = [[float("infinity") - 1 for _ in range(amount + 1)] for _ in range(N + 1)]

    # The minimum number of coins needed to make 0 rupees is 0.
    for n in range(N + 1):
        dp[n][0] = 0

    for n in range(1, N + 1):
        for a in range(1, amount + 1):
            if coins[n - 1] <= a:
                dp[n][a] = min(dp[n - 1][a], 1 + dp[n][a - coins[n - 1]])
            else:
                dp[n][a] = dp[n - 1][a]

    return dp[N][amount] if dp[N][amount] != float("infinity") else -1


def max_ways_of_changes(coins: List[int], amount: int) -> int:

    N = len(coins)
    dp = [[0 for _ in range(amount + 1)] for _ in range(N + 1)]

    # The maximum number of ways to make 0 rupees is 1, which is by not selecting any coins.
    for i in range(N + 1):
        dp[i][0] = 1

    for n in range(1, N + 1):
        for a in range(1, amount + 1):
            if coins[n - 1] <= a:
                dp[n][a] = dp[n - 1][a] + dp[n][a - coins[n - 1]]
            else:
                dp[n][a] = dp[n - 1][a]

    return dp[N][amount]
