package array.sorting;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int[] array = new int[] { 1, 5, 4, 3, 2 };
		start(array);
		System.out.println(Arrays.toString(array));
	}

	public static void start(int[] array) {
		mergeSort(array, 0, array.length - 1);
	}

	public static void mergeSort(int[] array, int start, int end) {
		if (start >= end)
			return;

		int mid = (start + end) / 2;
		mergeSort(array, start, mid);
		mergeSort(array, mid + 1, end);
		merge(array, start, mid, end);
	}

	public static void merge(int[] array, int start, int mid, int end) {
		int[] temp = new int[end - start + 1];

		int low = start;
		int right = mid + 1;
		int index = 0;

		while (low <= mid && right <= end) {
			if (array[low] <= array[right]) {
				temp[index++] = array[low++];
			} else {
				temp[index++] = array[right++];
			}
		}

		while (low <= mid) {
			temp[index++] = array[low++];
		}

		while (right <= end) {
			temp[index++] = array[right++];
		}

		for (int i = start, j = 0; i <= end; i++, j++) {
			array[i] = temp[j];
		}
	}
}
