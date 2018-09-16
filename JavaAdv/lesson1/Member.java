package ru.bukova.se;

public class Member {
    String Name;
    Boolean isPassed;

    public Member(String Name){
        this.Name = Name;
        this.isPassed = false;
    }

    public void Pass(){
        this.isPassed = true;
    }
}
