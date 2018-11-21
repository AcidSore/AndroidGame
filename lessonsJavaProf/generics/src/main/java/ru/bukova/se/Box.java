package ru.bukova.se;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Box<T extends Fruit> {
    public ArrayList<T> content;
    public  int BoxType;
    private Map<String,Integer> map=new HashMap<String,Integer>();

    public Box(){
        this.BoxType = 0;
        this.content = new ArrayList<>();
        this.map.put( "ru.bukova.se.Apple",1);
        this.map.put( "ru.bukova.se.Orange",2);
    }
    public void add(T fruit){
        if(this.content.isEmpty()){
            String type = fruit.getClass().getName();
            if(type == "ru.bukova.se.Apple"){
                this.BoxType=1;
                this.content.add(fruit);
            } else if(type == "ru.bukova.se.Orange"){
                this.BoxType=2;
                this.content.add(fruit);
            }
            else {System.out.println("не подходящий фрукт");}
        }
        else{
            if (this.map.get(fruit.getClass().getName()) == (Integer) this.BoxType){
                this.content.add(fruit);
            }
            else {System.out.println("тип коробки не подходит для этого фрукта");}
        }
    }
    public double getWeight() {
        double weigth = 0;
        if (this.BoxType == 1) {
             weigth = (double) content.size();
        }
        else if (this.BoxType == 2) {
           weigth = (double) (content.size() * 1.5);
        }
        else {System.out.print("коробка пуста");}

        return weigth;
    }
    public boolean compare(Box box){
        if(this.getWeight()==box.getWeight()){
            return true;
        }else
        return false;
    }
    public void pour(Box to){
       if(this.BoxType==to.BoxType){
           Collections.addAll( to.content, this.content);
           this.content.clear();
       }
       else{
        System.out.println("несовместимые типы");
    }

    }
}
