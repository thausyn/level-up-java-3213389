package com.linkedin.javacodechallenges;

public class Person {
  private String firstName, lastName;
  private int age;

  public Person(String firstName, String lastNameIn, int ageIn){
    this.firstName = firstName;
    this.lastName = lastNameIn;
    this.age = ageIn;
  }

  public String getfirstName(){
    return firstName;
  }

  public String getlastName(){
    return lastName;
  }

  public int getAge(){
    return age;
  }

  public void setAge(int age){
    this.age = age;
  }

  public void introduceYourself(){
    System.out.println("Hi, my name is " + firstName + " " + lastName + " and I'm " + getAge());
  }
}
