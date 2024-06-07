package Algorithms;

public class InsertionSort {
    public static void sortArray(int[] input){
        for (int i = 1; i < input.length; i++){
            int current = input[i];
            int j = i - 1;

            //Moves elements that are greater than current to one position ahead of their current.
            while (j >= 0 && input[j] > current){
                input[j + 1] = input[j];//Move ahead by one
                j = j - 1;
            }
            input[j + 1] = current;//One step ahead of J is now current.
        }
    }
}
