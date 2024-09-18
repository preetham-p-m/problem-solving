import heapq
from typing import Dict, List, Tuple


def dijkstra(graph: Dict[str, Dict[str, int]], start: str) -> Dict[str, int]:
    queue: List[Tuple[int, str]] = [(0, start)]

    distances: Dict[str, int] = {node: float("infinity") for node in graph}

    distances[start] = 0

    while queue:
        current_distance, current_node = heapq.heappop(queue)

        if current_distance > distances[current_node]:
            continue

        for neighbor, weight in graph[current_node].items():
            distance = current_distance + weight

            if distance < distances[neighbor]:
                distances[neighbor] = distance
                heapq.heappush(queue, (distance, neighbor))

    return distances
