from typing import List


def dfsOfGraph(V, adj):

    def dfs(
        node: int, adjList: List[List[int]], visited: List[bool], ansList: List[int]
    ):
        visited[node] = True
        ansList.append(node)

        for adj in adjList[node]:
            if not visited[adj]:
                dfs(adj, adjList, visited, ansList)

    visited: List[bool] = [False for _ in range(V)]
    answerList = []

    for i in range(V):  # This for loop is in case of connected components
        if not visited[i]:
            dfs(i, adj, visited, answerList)

    return answerList


V = 5
adj = [[2, 3, 1], [0], [0, 4], [0], [2]]

print(dfsOfGraph(V, adj))
