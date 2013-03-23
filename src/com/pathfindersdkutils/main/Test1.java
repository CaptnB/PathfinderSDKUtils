package com.pathfindersdkutils.main;

public class Test1 extends TestBase<Character>
{

  public Test1(String name)
  {
    super(name);
  }

  @Override
  public void test(Character t)
  {
    System.out.println("Test 1 : " + getName());
  }

}
