package com.pathfindersdkutils.main;

import com.pathfindersdk.books.AdvancedPlayersGuideBuilder;
import com.pathfindersdk.books.AdvancedRaceGuideBuilder;
import com.pathfindersdk.books.Bestiary2Builder;
import com.pathfindersdk.books.Bestiary3Builder;
import com.pathfindersdk.books.BestiaryBuilder;
import com.pathfindersdk.books.CoreRulebookBuilder;
import com.pathfindersdk.books.UltimateCombatBuilder;
import com.pathfindersdk.books.UltimateMagicBuilder;
import com.pathfindersdkutils.json.BookJson;


public class UtilsApp
{
  public static void main (String[] args)
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
