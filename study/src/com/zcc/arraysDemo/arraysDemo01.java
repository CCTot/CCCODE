package com.zcc.arraysDemo;

import java.util.Arrays;
import java.util.Comparator;

import static java.util.Arrays.compare;

public class arraysDemo01 {
    public static void main(String[] args) {

        Integer[] arr = {1,5,8,7,9,6,2,3};

        //System.out.println(Arrays.toString(arr));

        //System.out.println(Arrays.binarySearch(arr, 10));

        //int[] ints = Arrays.copyOf(arr, 9);
        //System.out.println(Arrays.toString(ints));

        //Arrays.fill(ints,100);
        //System.out.println(Arrays.toString(ints));

        Arrays.sort(arr,new Comparator<Integer>() {
            public int compare(Integer o1,Integer o2){
                return o2-o1;
            }
        });

        System.out.println(Arrays.toString(arr));
    }
}
