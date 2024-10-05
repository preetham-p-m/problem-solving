from typing import List


def superEggDrop(k: int, n: int) -> int:

    def egg_drop(k: int, n: int, dp: List[List[int]]) -> int:

        if n == 0 or n == 1:
            return n

        if k == 1:
            return n

        if dp[n][k] != -1:
            return dp[n][k]

        minimum: int = float("infinity")

        for a in range(1, n):
            temp: int = 1 + max(egg_drop(k - 1, a - 1, dp), egg_drop(k, n - a, dp))
            minimum = min(minimum, temp)

        dp[n][k] = minimum
        return minimum

    dp = [[-1 for _ in range(k + 1)] for _ in range(n + 1)]
    return egg_drop(k, n, dp)
