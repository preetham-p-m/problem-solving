from collections import deque
from typing import List


def bfsOfGraph(V: int, adj: List[List[int]]) -> List[int]:

    bfs: List[int] = []
    queue = deque()
    visited: List[bool] = [False] * V

    queue.append(0)

    while queue:
        node = queue.popleft()
        bfs.append(node)

        for adjNode in adj[node]:
            if not visited[adjNode]:
                visited[adjNode] = True
                queue.append(adjNode)

    return bfs


print(bfsOfGraph(5, [[1, 2, 3], [], [4], [], []]))
