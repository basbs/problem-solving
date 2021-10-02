package common;

import javax.lang.model.util.ElementScanner6;

public class BinarySearch {

    /**
     * input = [1,2,3,4,5]
     * 
     * case-1 : target = 1
     *  loop-1: mid = 2, midValue = 3, low = 0, high = 1
     *  loop-2: mid = 0, midValue = 1, low = 0, high = 1 --> result found!
     * 
     * case-2: target = 5
     *  loop-1: low = 0, high = 4, mid = 2, midValue = 3 
     *      -> because midValue < target, low => 3, high = 4
     *  loop-2: low = 3, high = 4, mid = 3, midValue = 4
     *      -> because midValue < target, low => 4, high = 4
     *  loop-3: low = 4, high = 4, mid = 4, midValue = 5
     *      -> because midValue is neither lesser nor greater it must be equal to target, else block return the value.
     * 
     * case-3: target = 4
     *  loop-1: low = 0, high = 4, mid = 2, midValue = 3
     *      -> because midValue < target, low => 3, high = 4 
     *  loop-2: low = 3, high = 4, mid = 3, midValue = 4
     *      -> because midValue is neither lesser nor greater it must be equal to target, i.e. else block return the value.
     * 
     * case-4: target = 8
     *  loop-1: low = 0, high = 4, mid = 2, midValue = 3
     *      -> because midValue < target, low => 3, high = 4
     *  loop-2: low = 3, high = 4, mid = 3, midValue = 4
     *      -> because midValue < target, low => 4, high = 4
     *  loop-3: low = 4, high = 4, mid = 4, midValue = 5
     *      -> because midValue < target, low => 5, high = 4
     *  loop-4: because low > high loo breaks, returns -1. 
     * 
     * 
     * NOTE: 
     * Using the below formula to calculate the mid value has issue
     * -> mid = (low + high) / 2 ==> it fails for large values of the int variables low and high. 
     * Specifically, it fails if the sum of low and high is greater than the maximum positive int value (2^31 - 1). 
     * The sum overflows to a negative value, and the value stays negative when divided by two. 
     * In Java, it throws ArrayIndexOutOfBoundsException.
     * 
     * To eliminate the above problem -> mid = low + ((high - low) / 2) or int mid = (low + high) >>> 1 
     */
    public static int search(int[] input, int target) {
        int low = 0;
        int high = input.length - 1;
        // finds the mid index
        while (low <= high) {
            int mid = low + ((high - low) / 2);
            int midValue = input[mid];
            if (midValue < target)
                low = mid + 1;
            else if (midValue > target)
                high = mid - 1;
            else
                return mid;
        }
        return -1;
    }

    /**
     * Recursive approach
     */
    public static int searchRecursive(int[] input, int target) {
        return recursiveSearch(input, target, 0, input.length);
    }

    private static int recursiveSearch(int[] input, int target, int low, int high) {
        if(low > high)
            return -1;
        int mid = (low + high) >>> 1;
        if(input[mid] < target)
           return recursiveSearch(input, target, mid + 1, high);
        else if (input[mid] > target)
            return recursiveSearch(input, target, low, mid - 1);
        else
            return mid;
    }
}
