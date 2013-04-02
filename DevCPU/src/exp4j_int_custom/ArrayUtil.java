package exp4j_int_custom;

public abstract class ArrayUtil {
    public static int[] reverse(int[] data) {
        int left = 0;
        int right = data.length - 1;

        while (left < right) {
            // swap the values at the left and right indices
            int temp = data[left];
            data[left] = data[right];
            data[right] = temp;

            // move the left and right index pointers in toward the center
            left++;
            right--;
        }
        return data;
    }
}
