package Algorithms;
import java.util.*;

public class SelectionSort {
    public static List<Integer> sortList(List<Integer> input){
        List<Integer> output = new ArrayList<>();
        while (!input.isEmpty()){
            Integer min = Collections.min(input);
            input.remove(min);
            output.add(min);
        }
        return output;
    }

    public static void sortArray(int[] input){
        for (int i = 0; i < input.length; i++){
            int minIndex = i; //Index of first unsorted number;
            for (int j = i+1; j < input.length; j++){
                if (input[j] < input[minIndex]){
                    minIndex = j;
                }
            }
            if (minIndex != i){
                int temp = input[i];
                input[i] = input[minIndex];
                input[minIndex] = temp;
            }
        }
    }
}
