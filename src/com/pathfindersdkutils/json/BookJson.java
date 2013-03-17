package com.pathfindersdkutils.json;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pathfindersdk.bonus.Bonus;
import com.pathfindersdk.books.Book;
import com.pathfindersdk.books.BookItem;
import com.pathfindersdk.creatures.Creature;
import com.pathfindersdk.prerequisites.Prerequisite;
import com.pathfindersdk.stats.Stat;

/**
 * This class reads/writes Book objetcs from/to a JSON file.
 */
public class BookJson
{
  private Gson gson;
  
  public BookJson()
  {
    GsonBuilder builder = new GsonBuilder();
    
    // Register adapters (for polymorphism)
    builder.registerTypeAdapter(Bonus.class, new JsonAdapter<Bonus>());
    builder.registerTypeAdapter(BookItem.class, new JsonAdapter<BookItem>());
    builder.registerTypeAdapter(Creature.class, new JsonAdapter<Creature>());
    builder.registerTypeAdapter(Prerequisite.class, new JsonAdapter<Prerequisite>());
    builder.registerTypeAdapter(Stat.class, new JsonAdapter<Stat>());
    
    // Set output as pretty print
    builder.setPrettyPrinting();
    
    // Instantiate Gson
    gson = builder.create();
  }
  
  public Book read(String fileName)
  {
    Book book = null;
    String booksPath = "books\\" + fileName;
    
    try
    {
      BufferedReader buffer = new BufferedReader(new FileReader(booksPath));
      book = gson.fromJson(buffer, Book.class);
      
      System.out.println(book.toString() + " has been read from [" + booksPath + "]");
    } 
    catch (IOException e)
    {
      e.printStackTrace();
    }
    
    return book;
  }
  
  public void write(Book book, String fileName)
  {
    String booksPath = "books\\" + fileName;

    try 
    {
      FileWriter writer = new FileWriter(booksPath);
      writer.write(gson.toJson(book));
      writer.close();
      
      System.out.println(book.toString() + " has been written into [" + booksPath + "]");
    } 
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

}
