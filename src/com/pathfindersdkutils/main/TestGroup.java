package com.pathfindersdkutils.main;

import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

public abstract class TestGroup<T> extends TestBase<T>
{
  protected SortedSet<TestBase<T>> testSet = new TreeSet<TestBase<T>>();
  
  public TestGroup(String name)
  {
    super(name);
  }

  public SortedSet<TestBase<T>> getTestSet()
  {
    return Collections.unmodifiableSortedSet(testSet);
  }
  
  public void addTest(TestBase<T> test)
  {
    if(test != null)
    {
      testSet.add(test);
    }
  }

}
