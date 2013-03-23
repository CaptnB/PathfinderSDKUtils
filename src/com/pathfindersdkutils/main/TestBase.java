package com.pathfindersdkutils.main;

public abstract class TestBase<T>
{
  protected String name;
  
  public TestBase(String name)
  {
    this.name = name;
  }
  
  public String getName()
  {
    return name;
  }
  
  public abstract void test(T t);
}
