import java.util.Arrays;

public class ArrayHelper {
    private final static int TRIGGER_NUMBER = 4;
    private final static int[] CONTROL_NUMBERS = {1, 4};

    public static int[] getNewArray(int[] arr) throws RuntimeException, NullPointerException {

        if (arr == null) throw new NullPointerException("Input array is null");

        int startPosition = -1;

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == TRIGGER_NUMBER) {
                startPosition = i + 1;
                break;
            }
        }

        //no TRIGGER_NUMBER in array
        if (startPosition == -1) throw new RuntimeException(TRIGGER_NUMBER + " is not in array.");

        //TRIGGER_NUMBER is the last element of array
        if (startPosition == arr.length) {
            return new int[0];
        }
        //copy array

        int[] resultArr = Arrays.copyOfRange(arr, startPosition, arr.length);

        //System.arraycopy(arr, startPosition, resultArr, 0, resultArr.length - 1);
        return resultArr;
    }

    public static boolean isNumbersInArray(int[] arr) {

        if (arr == null) throw new NullPointerException("Input array is null");

        for (int i = 0; i < CONTROL_NUMBERS.length; i++) {
            if (!containsValue(arr, CONTROL_NUMBERS[i])) return false;
        }
        return true;
    }

    private static boolean containsValue(int arr[], int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) return true;
        }
        return false;
    }
}
