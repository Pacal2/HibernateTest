package org.example;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {
    @Id
    private int number;
    private String name;
    private int marks;
    //@ManyToMany(mappedBy="listOfStudents")
    private List<Laptop> listOfLaptops = new ArrayList<>();

    public Student() {

    }

    public Student(int number, String name, int marks) {
        this.number = number;
        this.name = name;
        this.marks = marks;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public List<Laptop> getListOfLaptops() {
        return listOfLaptops;
    }

    public void setListOfLaptops(ArrayList<Laptop> listOfLaptops) {
        this.listOfLaptops = listOfLaptops;
    }

    @Override
    public String toString() {
        return "Student{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", marks=" + marks +
                ", listOfLaptops=" + listOfLaptops +
                '}';
    }
}
