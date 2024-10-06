from typing import List


def superEggDrop(k: int, n: int) -> int:
    def egg_drop(k: int, n: int, dp: List[List[int]]) -> int:
        # Base cases
        if n == 0 or n == 1:
            return n
        if k == 1:
            return n

        if dp[n][k] != -1:
            return dp[n][k]

        low, high = 1, n
        minimum = float("infinity")

        while low <= high:
            mid = (low + high) // 2
            egg_breaks = egg_drop(k - 1, mid - 1, dp)
            egg_doesnt_break = egg_drop(k, n - mid, dp)

            worst_case = max(egg_breaks, egg_doesnt_break) + 1

            minimum = min(minimum, worst_case)

            if egg_breaks > egg_doesnt_break:
                high = mid - 1
            else:
                low = mid + 1

        dp[n][k] = minimum
        return minimum

    dp = [[-1 for _ in range(k + 1)] for _ in range(n + 1)]

    return egg_drop(k, n, dp)
