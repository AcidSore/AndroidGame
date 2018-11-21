package ru.bukova.se;

import java.util.ArrayList;
import java.util.Collections;

public class AnyClass <T> {
    public AnyClass(){
    }
    public void swap(T[] arr, int index1, int index2){
        T temp;
        temp = arr[index1];
        arr[index1]=arr[index2];
        arr[index2]=temp;
    }
    public void ToArrayList(T[] arr){
        ArrayList <T> List = new ArrayList<>();
        Collections.addAll( List, arr);
    }
}
