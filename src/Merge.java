import java.util.Arrays;

public class Merge {
	public static void main(String[] args) {
		int[] firstArray = {1, 24, 3, 6, 7};
		int[] secondArray = {43, 12, 25, 13, 16};

		System.out.println("First Array");
		displayArray(firstArray);
		System.out.println("Second Array");
		displayArray(secondArray);

		System.out.println("Merge sort Array");
		displayArray(mergeSort(firstArray, secondArray));
	}

	public static int[] bubbleSort(int[] array) {
		boolean isSorted = false;
		while (!isSorted) {
			isSorted = true;
			for (int i = 0; i < array.length - 1; i++) {
				if (array[i] > array[i + 1]) {
					swap(i, i + 1, array);
					isSorted = false;
				}
			}
		}
		return array;
	}

	public static int[] mergeSort(int[] firstArray, int[] secondArray) {
		int[] copyOfFirstArray = Arrays.copyOf(firstArray, firstArray.length);
		int[] copyOfSecondArray = Arrays.copyOf(secondArray, secondArray.length);

		bubbleSort(copyOfFirstArray);
		bubbleSort(copyOfSecondArray);

		int[] outArray = new int[copyOfFirstArray.length + copyOfSecondArray.length];
		int firstArrayNumberIndex = 0;
		int secondArrayNumberIndex = 0;
		int outArrayNumberIndex = 0;
		while (firstArrayNumberIndex < copyOfFirstArray.length && secondArrayNumberIndex < copyOfSecondArray.length) {
			outArray[outArrayNumberIndex++] = copyOfFirstArray[firstArrayNumberIndex] <
					copyOfSecondArray[secondArrayNumberIndex] ?
					copyOfFirstArray[firstArrayNumberIndex++] : copyOfSecondArray[secondArrayNumberIndex++];
		}
		if (firstArrayNumberIndex < copyOfFirstArray.length) {
			System.arraycopy(copyOfFirstArray, firstArrayNumberIndex, outArray,
					outArrayNumberIndex, copyOfFirstArray.length - firstArrayNumberIndex);
		} else if (secondArrayNumberIndex < copyOfSecondArray.length) {
			System.arraycopy(copyOfSecondArray, secondArrayNumberIndex, outArray,
					outArrayNumberIndex, copyOfSecondArray.length - secondArrayNumberIndex);
		}
		return outArray;
	}

	public static void swap(int firstNumberIndex, int secondNumberIndex, int[] array) {
		int buffer = array[firstNumberIndex];
		array[firstNumberIndex] = array[secondNumberIndex];
		array[secondNumberIndex] = buffer;
	}

	public static void displayArray(int[] array) {
		for (int x : array) {
			System.out.print(x + " ");
		}
		System.out.println();
	}
}