package com.pathfindersdkutils.main;

import com.pathfindersdk.basics.CreatureType;
import com.pathfindersdk.bonus.InitiativeBonus;
import com.pathfindersdk.bonus.SaveBonus;
import com.pathfindersdk.bonus.SpeedBonus;
import com.pathfindersdk.books.builders.AdvancedPlayersGuideBuilder;
import com.pathfindersdk.books.builders.AdvancedRaceGuideBuilder;
import com.pathfindersdk.books.builders.Bestiary2Builder;
import com.pathfindersdk.books.builders.Bestiary3Builder;
import com.pathfindersdk.books.builders.BestiaryBuilder;
import com.pathfindersdk.books.builders.CoreRulebookBuilder;
import com.pathfindersdk.books.builders.UltimateCombatBuilder;
import com.pathfindersdk.books.builders.UltimateMagicBuilder;
import com.pathfindersdk.books.items.Race;
import com.pathfindersdk.creatures.Character;
import com.pathfindersdk.enums.BonusType;
import com.pathfindersdk.enums.CreatureMainType;
import com.pathfindersdk.enums.CreatureSubtype;
import com.pathfindersdk.enums.SaveType;
import com.pathfindersdk.enums.SizeType;
import com.pathfindersdk.enums.SpeedType;
import com.pathfindersdk.stats.Speed;
import com.pathfindersdkutils.json.BookJson;


public class UtilsApp
{
  public static void main (String[] args)
  {
    //createBooks();
    
    /*GsonBuilder builder = new GsonBuilder();
    builder.registerTypeAdapter(BookContent.class, new JsonAdapter<BookContent>());
    builder.registerTypeAdapter(BonusStrategy.class, new BonusStrategyAdapter());
    builder.registerTypeAdapter(Prerequisite.class, new PrerequisiteAdapter());
    builder.setPrettyPrinting();
    Gson gson = builder.create();*/

    testCharacter();
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
  
  private static void testCharacter()
  {
    // Name
    Character character = new Character();
    character.setName("Gimli of the Deep");
    
    // Ability Scores
    character.getStrenght().setBaseScore(7);
    character.getDexterity().setBaseScore(17);
    character.getConstitution().setBaseScore(12);
    character.getIntelligence().setBaseScore(15);
    character.getWisdom().setBaseScore(8);
    character.getCharisma().setBaseScore(18);
    
    // Race
    CreatureType creatureType = new CreatureType(CreatureMainType.HUMANOID);
    creatureType.addSubtype(CreatureSubtype.DWARF);
    creatureType.addSubtype(CreatureSubtype.EARTH);
    
    Race race = new Race("Earth Dwarf", creatureType, SizeType.MEDIUM);
    race.addBonus(new InitiativeBonus(2, BonusType.MORALE));
    race.addBonus(new SaveBonus(1, BonusType.RACIAL, SaveType.FORT, "against poison"));
    race.addBonus(new SaveBonus(2, BonusType.LUCK, SaveType.FORT, "when upside down"));
    race.addBonus(new SaveBonus(1, BonusType.RACIAL, SaveType.REF));
    race.addBonus(new SaveBonus(2, BonusType.RACIAL, SaveType.REF));
    race.addBonus(new SaveBonus(1, BonusType.MORALE, SaveType.REF));
    
    race.addSpeed(new Speed(20, SpeedType.BASE));
    race.addSpeed(new Speed(20, SpeedType.ARMOR));
    race.addSpeed(new Speed(5,  SpeedType.BURROW));
    character.setRace(race);
    character.getSpeed(SpeedType.ARMOR).addBonus(new SpeedBonus(-5, BonusType.RACIAL, SpeedType.ARMOR, "for being dumb"));
    character.getSpeed(SpeedType.BURROW).addBonus(new SpeedBonus(2, BonusType.ENHANCEMENT, SpeedType.BURROW));
    
    System.out.println("Name : " + character.getName());
    System.out.println("Race : " + character.getRace().toString());
    System.out.println("Type : " + character.getType().toString());
    System.out.println("Size : " + character.getSize().toString());
    System.out.println("Strenght : " + character.getStrenght().toString());
    System.out.println("Dexterity : " + character.getDexterity().toString());
    System.out.println("Constitution : " + character.getConstitution().toString());
    System.out.println("Intelligence : " + character.getIntelligence().toString());
    System.out.println("Wisdom : " + character.getWisdom().toString());
    System.out.println("Charisma : " + character.getCharisma().toString());
    System.out.println("Fortitude : " + character.getFortitude().toString());
    System.out.println("Reflex : " + character.getReflex().toString());
    System.out.println("Will : " + character.getWill().toString());
    System.out.println("Initiative : " + character.getInitiative().toString());
    System.out.println("Base speed : " + character.getSpeed(SpeedType.BASE).toString());
    System.out.println("Armor speed : " + character.getSpeed(SpeedType.ARMOR).toString());
    System.out.println("Burrow speed : " + character.getSpeed(SpeedType.BURROW).toString());
  }
}
