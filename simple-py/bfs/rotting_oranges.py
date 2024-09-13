from collections import deque
from typing import List


def orangesRotting(self, grid: List[List[int]]) -> int:
    FRESH, ROTTEN = 1, 2
    m, n = len(grid), len(grid[0])

    fresh_count = 0
    minutes_to_rot_all = -1
    queue = deque()

    for i in range(len(grid)):
        for j in range(len(grid[0])):
            if grid[i][j] == ROTTEN:
                queue.append((i, j))
            elif grid[i][j] == FRESH:
                fresh_count += 1

    if fresh_count == 0 and len(queue) == 0:
        return 0

    while queue:
        minutes_to_rot_all += 1

        for _ in range(len(queue)):
            i, j = queue.popleft()

            for i_off, j_off in [(0, 1), (1, 0), (-1, 0), (0, -1)]:
                r, c = i + i_off, j + j_off

                if 0 <= r < m and 0 <= c < n and grid[r][c] == FRESH:
                    grid[r][c] = ROTTEN
                    fresh_count -= 1
                    queue.append((r, c))

    if fresh_count > 0:
        return -1
    else:
        return minutes_to_rot_all
