package ru.bukova.se;

import java.util.ArrayList;
import java.util.Collections;

import static java.util.Collections.swap;

public class App {

    public static void main(String[] args ){
       Apple apple1 = new Apple("one");
       Apple apple2 = new Apple("two");
       Apple apple3 = new Apple("three");
       Orange orange1 = new Orange("orange1");
       Orange orange2 = new Orange("orange2");
       Box box1 = new Box();
       Box box2 = new Box();
       box1.add(apple1);
       box1.add(apple2);
       //box1.add(orange1);
       box2.add(orange1);
       System.out.println(box2.getWeight());
       System.out.println(box1.compare(box2));
       box1.pour(box2);
//      String [] ts = {"1","2","3"};
//      AnyClass<String> tt = new AnyClass<>();
//      tt.swap(ts,0,2);
//      System.out.println(ts[0]+ts[2]);
//      tt.ToArrayList(ts);
    }
}
