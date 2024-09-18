from typing import List


def count_subset_with_given_difference(elements: List[int], D: int) -> int:

    total_sum = sum(elements)

    if (D + total_sum) % 2 != 0:
        return 0

    N = len(elements)
    S = (D + total_sum) // 2

    dp = [[0 for _ in range(S + 1)] for _ in range(N + 1)]

    for n in range(N + 1):
        dp[n][0] = 1

    for n in range(1, N + 1):
        for s in range(1, S + 1):
            if elements[n - 1] <= s:
                dp[n][s] = dp[n - 1][s] + dp[n - 1][s - elements[n - 1]]
            else:
                dp[n][s] = dp[n - 1][s]

    return dp[N][S]
