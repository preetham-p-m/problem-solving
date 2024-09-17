from typing import List


class Solution:
    def max_area(self, height: List[int]) -> int:
        """Find the maximum water stored in the container

        Args:
            height (List[int]): _description_

        Returns:
            int: _description_
        """

        left = 0
        right = len(height) - 1

        maximum = 0
        while left <= right:
            min_height = min(height[left], height[right])
            maximum = max(maximum, min_height * (right - left))

            if height[left] < height[right]:
                left += 1
            else:
                right -= 1

        return maximum
