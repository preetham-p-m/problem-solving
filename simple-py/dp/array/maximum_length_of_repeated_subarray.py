from typing import List


def findLength(nums1: List[int], nums2: List[int]) -> int:
    N, M = len(nums1), len(nums2)
    dp = [[0 for _ in range(M + 1)] for _ in range(N + 1)]

    max_len = 0

    for n in range(1, N + 1):
        for m in range(1, M + 1):
            if nums1[n - 1] == nums2[m - 1]:
                dp[n][m] = 1 + dp[n - 1][m - 1]
                max_len = max(max_len, dp[n][m])

    return max_len


print(findLength([1, 2, 3, 2, 1], [3, 2, 1, 4, 7]))
