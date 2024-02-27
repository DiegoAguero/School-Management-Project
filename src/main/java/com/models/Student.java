package com.models;
public class Student{
    private String name, lastName, DNI;
    public Student(){}
    public Student(String name, String lastName, String DNI){
        this.setName(name);
        this.setLastName(lastName);
        this.setDNI(DNI);
    }
    public void setName(String name){
        this.name = name;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public void setDNI(String DNI){
        this.DNI = DNI;
    }
    public String getName(){
        return this.name;
    }
    public String getLastName(){
        return this.lastName;
    }
    public String getDNI(){
        return this.DNI;
    }
    @Override
    public String toString(){
        return String.format("Student name: %s, Student last name: %s, Student DNI: %s", this.getName(), this.getLastName(), this.getDNI());
    }


}