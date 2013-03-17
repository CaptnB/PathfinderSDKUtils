package com.pathfindersdkutils.main;

import com.pathfindersdk.creatures.Character;
import com.pathfindersdk.creatures.Description;
import com.pathfindersdkutils.books.CoreRulebookBuilder;


public class UtilsApp
{
  public static void main (String[] args)
  {
    // Build Core Rulebook (everything should be indexed)
    new CoreRulebookBuilder().createBook("Core Rulebook");
    testCharacter();
  }

  private static void testCharacter()
  {
    Character character = new Character();
    Description desc = new Description();
    desc.setName("Yodeeho");
    character.setDescription(desc);
    
    System.out.println(character);
  }
  
}
