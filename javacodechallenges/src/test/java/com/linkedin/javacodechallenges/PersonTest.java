package com.linkedin.javacodechallenges;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PersonTest {
  private final ByteArrayOutputStream PrintOut = new ByteArrayOutputStream();

  @Before
  public void setUpStreams(){
    System.setOut(new PrintStream(PrintOut));
  }

  @After
  public void restoreStreams(){
    System.setOut(System.out);
  }

  @Test
  public void personAttributes_firstName(){
    Person person = new Person("Clark", "Ken", 34);
    assertEquals("Clark", person.getfirstName());
    assertEquals(34, person.getAge());
    person.setAge(33);
    assertEquals(33, person.getAge());
    person.introduceYourself();
    assertEquals("Hi, my name is Clark Ken and I'm 33\n", PrintOut.toString());
  }
}
