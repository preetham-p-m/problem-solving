import sys
from typing import List


# class Solution:
def minimumDifference(nums: List[int]) -> int:

    N = len(nums)
    sum_of_all = sum(nums)
    S = sum_of_all // 2

    dp = [[False for _ in range(S + 1)] for _ in range(N + 1)]

    for n in range(N + 1):
        dp[n][0] = True

    for n in range(1, N + 1):
        for s in range(1, S + 1):
            if nums[n - 1] <= s:
                dp[n][s] = dp[n - 1][s] or dp[n - 1][s - nums[n - 1]]
            else:
                dp[n][s] = dp[n - 1][s]

    probable_elements = []

    for s in range(S + 1):
        if dp[N][s]:
            probable_elements.append(s)

    minimum_value = sum_of_all

    for i in probable_elements:
        minimum_value = min(abs(sum_of_all - 2 * i), minimum_value)

    return minimum_value


minimumDifference([2, -1, 0, 4, -2, -9])
