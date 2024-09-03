package array;

public class FindDuplicate {

	public static void main(String[] args) {
		int[] array = new int[] { 1, 5, 4, 2, 3, 4 };

		System.out.println(start(array));
	}

	public static int start(int[] nums) {
		int slow = nums[0];
		int fast = nums[0];
		do {
			slow = nums[slow];
			fast = nums[nums[fast]];
		} while (slow != fast);

		fast = nums[0];
		while (slow != fast) {
			slow = nums[slow];
			fast = nums[fast];
		}
		return slow;
	}
}
