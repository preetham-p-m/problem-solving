package array;

import java.util.Arrays;

public class RepeatingAndMissing {
	public static void main(String[] args) {
		int[] array = new int[] { 1, 2, 3, 1, 5 };

		int[] result = start(array);

		System.out.println(Arrays.toString(result));
	}

	public static int[] start(int[] array) {
		long sumOfN = 0;
		long sumOfN2 = 0;

		long realSumOfN = 0;
		long realSumOfN2 = 0;

		for (int i = 0; i < array.length; i++) {
			realSumOfN += (i + 1);
			realSumOfN2 += (i + 1) * (i + 1);

			sumOfN += array[i];
			sumOfN2 += array[i] * array[i];
		}

		long rMd = realSumOfN - sumOfN;
		long r2Md2 = realSumOfN2 - sumOfN2;

		long rPd = r2Md2 / rMd;

		long repeting = (rPd + rMd) / 2;
		long duplicate = rPd - repeting;

		return new int[] { (int) repeting, (int) duplicate };
	}
}
