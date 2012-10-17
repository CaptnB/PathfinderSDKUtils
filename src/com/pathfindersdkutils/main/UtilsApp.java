package com.pathfindersdkutils.main;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pathfindersdk.bonus.BonusStrategy;
import com.pathfindersdk.books.BookContent;
import com.pathfindersdk.books.builders.AdvancedPlayersGuideBuilder;
import com.pathfindersdk.books.builders.AdvancedRaceGuideBuilder;
import com.pathfindersdk.books.builders.Bestiary2Builder;
import com.pathfindersdk.books.builders.Bestiary3Builder;
import com.pathfindersdk.books.builders.BestiaryBuilder;
import com.pathfindersdk.books.builders.CoreRulebookBuilder;
import com.pathfindersdk.books.builders.UltimateCombatBuilder;
import com.pathfindersdk.books.builders.UltimateMagicBuilder;
import com.pathfindersdk.creatures.Character;
import com.pathfindersdk.prerequisites.Prerequisite;
import com.pathfindersdkutils.json.BonusStrategyAdapter;
import com.pathfindersdkutils.json.BookContentAdapter;
import com.pathfindersdkutils.json.BookJson;
import com.pathfindersdkutils.json.PrerequisiteAdapter;


public class UtilsApp
{
  public static void main (String[] args)
  {
    //createBooks();
    
    GsonBuilder builder = new GsonBuilder();
    builder.registerTypeAdapter(BookContent.class, new BookContentAdapter());
    builder.registerTypeAdapter(BonusStrategy.class, new BonusStrategyAdapter());
    builder.registerTypeAdapter(Prerequisite.class, new PrerequisiteAdapter());
    builder.setPrettyPrinting();
    Gson gson = builder.create();
    
    Character character = new Character("Crash test dummy");
    String test = gson.toJson(character);
    System.out.println(test);
  }

  private static void createBooks()
  {
    BookJson json = new BookJson();
    json.write(new CoreRulebookBuilder().createBook("Core Rulebook"), "core_rulebook.json");
    json.write(new AdvancedPlayersGuideBuilder().createBook("Advanced Player's Guide"), "advanced_players_guide.json");
    json.write(new BestiaryBuilder().createBook("Bestiary"), "bestiary.json");
    json.write(new Bestiary2Builder().createBook("Bestiary 2"), "bestiary_2.json");
    json.write(new Bestiary3Builder().createBook("Bestiary 3"), "bestiary_3.json");
    json.write(new AdvancedRaceGuideBuilder().createBook("Advanced Race Guide"), "advanced_race_guide.json");
    json.write(new UltimateCombatBuilder().createBook("Ultimate Combat"), "ultimate_combat.json");
    json.write(new UltimateMagicBuilder().createBook("Ultimate Magic"), "ultimate_magic.json");
  }
}
