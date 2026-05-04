/**
 * Create an insertion sort algorithm that sorts an array of inputs. The array is randomly generated with the user
 * choosing the large value of the number and the size of the array. Create a method that counts the inversion
 * that are present in the array before the array gets sorted.
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Test 1
        Test.getInputsTest();

        // Test 2
        Test.exampleTest();
    }
}

class Test {
    private Test() {}

    /**
     * Normal test with taking the inputs from the user.
     */
    static void getInputsTest() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int arraySize = scanner.nextInt();
        System.out.println("Enter the data: ");
        int[] testArray = new int[arraySize];
        for(int i = 0; i < arraySize; i++) {
            testArray[i] = scanner.nextInt();
        }
        System.out.println("Original Array: ");
        InsertionSort.printArray(testArray);
        System.out.println("Inversion: ");
        inversions(testArray);
        System.out.println("Sorting: ");
        InsertionSort.sort(testArray);
    }

    /**
     * An example test with already specified input.
     */
    static void exampleTest() {
        int[] testArray2 = new int[] {1,2,4,3,5,0};
        System.out.println("Original Array: ");
        InsertionSort.printArray(testArray2);
        System.out.println("Inversion(s): ");
        inversions(testArray2);
        System.out.println("Sorting: ");
        InsertionSort.sort(testArray2);
    }

    /**
     * Looks up the inversions that needs to be changed to sort the array beside counting them.
     * @param array the array that will be inspected.
     */
    static void inversions(int[] array) {
        int count = 0;
        for(int i = 0; i < array.length - 1; i++) {
            for(int j = i + 1; j < array.length; j++) {
                if(array[i] > array[j]) {
                    count++;
                    printInversion(array, i, j);
                }
            }
        }
        System.out.println("The count of inversion: " + count);
    }

    /**
     * Prints the inversion in a specific style. [i,array[i]],[j,array[j]]
     * @param array the array that was inspected.
     * @param i the index for the first position.
     * @param j the index for the followed position.
     */
    static void printInversion(int[] array, int i, int j) {
        String inversion = "["+ i +"," + array[i] + "], " + "["+ j +"," + array[j] + "]";
        System.out.println(inversion);
    }
}

/**
 * The insertion sort algorithm which will be used to sort the array.
 * Heavily inspired from the book "Algorithms 4th Edition" by Robert Sedgewick, Kevin Wayne.
 */
class InsertionSort {
    private InsertionSort() {}

    /**
     * Sort the array using the insertion sort method.
     * @param unsortedArray the array that wanted to be sorted.
     */
    static void sort(int[] unsortedArray) {
        int arrayLength = unsortedArray.length;
        int swaps = 0;
        for (int i = 1; i < arrayLength; i++) {
            for (int j = i; j > 0 && less(unsortedArray[j], unsortedArray[j-1]); j--) {
                exchange(unsortedArray, j, j-1);
                swaps++;
                printArray(unsortedArray);
            }
            assert isSorted(unsortedArray, 0, i);
        }
        assert isSorted(unsortedArray);
        System.out.println("The number of swaps preformed: " + swaps);
    }

    /**
     * Check whether the first number is smaller than the second number.
     * @param num1 the first number.
     * @param num2 the second number.
     * @return ture or false depending on the condition.
     */
    private static boolean less(int num1, int num2) {
        return num1 < num2;
    }

    /**
     * Swap between two numbers that are in the array.
     * @param array in which the swap wanted to be.
     * @param i the position for the first number.
     * @param j the position for the second number.
     */
    private static void exchange(int[] array, int i, int j) {
        int swap = array[i];
        array[i] = array[j];
        array[j] = swap;
    }

    /**
     * Print the content of an array. the style is {x, x, x, ...}
     * @param array which will be printed.
     */
    static void printArray(int[] array) {
        String arrString = "{";
        for(int i = 0; i < array.length; i++) {
            arrString += array[i];
            if(i != array.length -1) {
                arrString += ", ";
            }
            if(i % 10 == 0 && i != 0) {
                arrString += "\n";
            }
        }
        arrString += "}";
        System.out.println(arrString);
    }

    /**
     * Checks if the array is sorted or not.
     * @param sortedArray the array which assumed to be sorted.
     * @return false of true depending on the condition.
     */
    private static boolean isSorted(int[] sortedArray) {
        return isSorted(sortedArray, 0, sortedArray.length);
    }

    /**
     *
     * @param sortedArray the assumed sorted array.
     * @param lo the smallest index in the array.
     * @param hi the highest index that the array offers.
     * @return if is it sorted or not.
     */
    private static boolean isSorted(int[] sortedArray, int lo, int hi) {
        for (int i = lo + 1; i < hi; i++)
            if (less(sortedArray[i], sortedArray[i-1])) return false;
        return true;
    }
}