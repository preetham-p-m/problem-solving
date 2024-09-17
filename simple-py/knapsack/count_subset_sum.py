
from typing import List


def count_subset_sum(elements: List[int], N: int, S: int) -> int:
    print('')

    dp = [[0 for _ in range(S+1)] for _ in range(N+1)]

    for n in range(N+1):
        dp[n][0] = 1

    for n in range(1, N+1):
        for s in range(1, S+1):
            if elements[n-1] <= s:
                dp[n][s] = dp[n-1][s] + dp[n-1][s-elements[n-1]]
            else:
                dp[n][s] = dp[n-1][s]

    return dp[N][S]
