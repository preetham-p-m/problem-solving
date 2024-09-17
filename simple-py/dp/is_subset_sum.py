from typing import List


def is_subset_sum(elements: List[int], N: int, S: int):
    subset = [[False for _ in range(S + 1)] for _ in range(N + 1)]

    for n in range(N + 1):
        subset[n][0] = True

    for n in range(1, N + 1):
        for s in range(1, S + 1):
            if elements[n - 1] <= s:
                subset[n][s] = subset[n - 1][s] or subset[n - 1][s - elements[n - 1]]
            else:
                subset[n][s] = subset[n - 1][s]

    return subset[N][S]


def is_equal_sum(elements: List[int]):
    N = len(elements)
    S = sum(elements)

    if S % 2 != 0:
        return False

    S = S // 2

    return is_subset_sum(elements, N, S)
