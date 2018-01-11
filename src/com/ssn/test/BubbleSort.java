package com.ssn.test;

import java.util.Arrays;
import java.util.List;

public class BubbleSort {


    public static void main(String[] args) {
        Integer[] mass = new Integer[]{5, 2, 1, 3, 0, 5, 0};
        sort(mass);

//        System.out.println(Arrays.toString(mass));

        mass = new Integer[]{1, 2, 3, 4, 5, 6, 7};



//        bubbleSort(mass);

        System.out.println(Arrays.toString(mass));
        System.out.println(indexedBinarySearch(Arrays.asList(mass), 0, 0, mass.length - 1));
        System.out.println(indexedBinarySearch(Arrays.asList(mass), 1, 0, mass.length - 1));
        System.out.println(indexedBinarySearch(Arrays.asList(mass), 4, 0, mass.length - 1));
        System.out.println(indexedBinarySearch(Arrays.asList(mass), 7, 0, mass.length - 1));

    }


    public static void sort(Integer[] mass) {
        for (int i = 0; i < mass.length; i++) {
            for (int j = i + 1; j < mass.length; j++) {
                if (mass[i].compareTo(mass[j]) > 0) {
                    Integer temp = mass[i];
                    mass[i] = mass[j];
                    mass[j] = temp;
                }
            }
        }
    }

    private static <T> int indexedBinarySearch(List<? extends Comparable<? super T>> list, T key, int start, int end) {
        int mid = (start + end) >>> 1;
        if (start == end && list.get(mid).compareTo(key) != 0){
            return -1;
        } else if (list.get(mid).compareTo(key) < 0) {
            return indexedBinarySearch(list, key, mid + 1, end);
        } else if (list.get(mid).compareTo(key) > 0) {
            return indexedBinarySearch(list, key, start, mid - 1);
        } else  {
            return mid;
        }
    }
}
