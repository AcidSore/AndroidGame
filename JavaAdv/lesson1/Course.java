package ru.bukova.se;

public class Course {
    String CourseName;
    String [] Tasks =  {"task1", "task2", "task3","task4"} ;

    public Course(String Name){
        this.CourseName = Name;
    }

    public void DoCourse(String teamName){
        System.out.print(teamName + " ,please get ready!");
    }
}
