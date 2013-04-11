package com.pathfindersdkutils.bookbuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import com.pathfindersdk.bonus.AcBonus;
import com.pathfindersdk.bonus.AttackBonus;
import com.pathfindersdk.bonus.Bonus;
import com.pathfindersdk.bonus.CmdBonus;
import com.pathfindersdk.bonus.SaveBonus;
import com.pathfindersdk.bonus.SkillBonus;
import com.pathfindersdk.books.BookBuilder;
import com.pathfindersdk.books.BookSection;
import com.pathfindersdk.books.items.RaceItem;
import com.pathfindersdk.books.items.SkillItem;
import com.pathfindersdk.creatures.CreatureType;
import com.pathfindersdk.enums.AbilityType;
import com.pathfindersdk.enums.BonusTypeRegister;
import com.pathfindersdk.enums.BookSectionType;
import com.pathfindersdk.enums.CreatureMainType;
import com.pathfindersdk.enums.CreatureSubtype;
import com.pathfindersdk.enums.LanguageType;
import com.pathfindersdk.enums.SaveType;
import com.pathfindersdk.enums.SizeType;
import com.pathfindersdk.enums.SpeedType;
import com.pathfindersdk.enums.VisionType;
import com.pathfindersdk.features.AbilityIncrease;
import com.pathfindersdk.features.RacialTrait;

/**
* This class builds the Core Rulebook content and returns the book.
*/
public class CoreRulebookBuilder extends BookBuilder
{

  @Override
  protected void registerBonusTypes()
  {
    // TODO Auto-generated method stub
    
  }

  @Override
  protected void addRaces(SortedMap<BookSectionType, BookSection> sections)
  {
    BookSection section = new BookSection(BookSectionType.RACES);

    CreatureType type;
    List<AbilityIncrease> racialModifiers;
    SizeType size;
    SortedMap<SpeedType, Integer> speeds;
    VisionType vision;
    SortedSet<RacialTrait> racialTraits;
    SortedSet<Bonus> bonuses;
    // TODO: Weapon proficiencies/familiarities
    SortedSet<LanguageType> baseLanguages;
    SortedSet<LanguageType> optionalLanguages;

    // Dwarf
    type = new CreatureType(CreatureMainType.HUMANOID);
    type.addSubtype(CreatureSubtype.DWARF);
    
    racialModifiers = new ArrayList<AbilityIncrease>();
    racialModifiers.add(new AbilityIncrease(2, AbilityType.CON));
    racialModifiers.add(new AbilityIncrease(2, AbilityType.WIS));
    racialModifiers.add(new AbilityIncrease(-2, AbilityType.CHA));

    size = SizeType.MEDIUM;
    
    speeds = new TreeMap<SpeedType, Integer>();
    speeds.put(SpeedType.BASE, 20);
    speeds.put(SpeedType.ARMOR, 20);

    vision = VisionType.DARKVISION_60;
    
    racialTraits = new TreeSet<RacialTrait>();
    bonuses = new TreeSet<Bonus>();
    bonuses.add(new AcBonus(4, BonusTypeRegister.getInstance().get("Dodge"), "against monsters of the giant subtype"));
    racialTraits.add(new RacialTrait("Defensive Training", bonuses));
    
    bonuses = new TreeSet<Bonus>();
    bonuses.add(new SkillBonus(2, BonusTypeRegister.getInstance().get("Racial"), "Appraise", "to determine the price of nonmagical precious metal or gemstones"));
    racialTraits.add(new RacialTrait("Greed", bonuses));
    
    bonuses = new TreeSet<Bonus>();
    bonuses.add(new AttackBonus(1, BonusTypeRegister.getInstance().get("Racial"), "against creatures of the orc subtype"));
    bonuses.add(new AttackBonus(1, BonusTypeRegister.getInstance().get("Racial"), "against creatures of the goblinoid subtype"));
    racialTraits.add(new RacialTrait("Hatred", bonuses));
    
    bonuses = new TreeSet<Bonus>();
    bonuses.add(new SaveBonus(2, BonusTypeRegister.getInstance().get("Racial"), SaveType.ALL, "against poison, spells and spell-like abilities"));
    racialTraits.add(new RacialTrait("Hardy", bonuses));
    
    bonuses = new TreeSet<Bonus>();
    bonuses.add(new CmdBonus(4, BonusTypeRegister.getInstance().get("Racial"), "to resist a bull rush or trip attempt"));
    racialTraits.add(new RacialTrait("Stability", bonuses));
    
    bonuses = new TreeSet<Bonus>();
    bonuses.add(new SkillBonus(2, BonusTypeRegister.getInstance().get("Racial"), "Perception", "to notice unusual stonework"));
    racialTraits.add(new RacialTrait("Stone Cunning", bonuses));

    // Weapon Familiarity

    baseLanguages = new TreeSet<LanguageType>();
    baseLanguages.add(LanguageType.COMMON);
    baseLanguages.add(LanguageType.DWARVEN);
    
    optionalLanguages = new TreeSet<LanguageType>();
    optionalLanguages.add(LanguageType.GIANT);
    optionalLanguages.add(LanguageType.GNOME);
    optionalLanguages.add(LanguageType.GOBLIN);
    optionalLanguages.add(LanguageType.ORC);
    optionalLanguages.add(LanguageType.TERRAN);
    optionalLanguages.add(LanguageType.UNDERCOMMON);

    section.addItem(new RaceItem("Dwarf", type, racialModifiers, size, speeds, vision, racialTraits, baseLanguages, optionalLanguages));
    
    // Elf
    type = new CreatureType(CreatureMainType.HUMANOID);
    type.addSubtype(CreatureSubtype.ELF);

    racialModifiers = new ArrayList<AbilityIncrease>();
    racialModifiers.add(new AbilityIncrease(2, AbilityType.DEX));
    racialModifiers.add(new AbilityIncrease(2, AbilityType.INT));
    racialModifiers.add(new AbilityIncrease(-2, AbilityType.CON));

    size = SizeType.MEDIUM;
    
    vision = VisionType.LOW_LIGHT;
    
    speeds = new TreeMap<SpeedType, Integer>();
    speeds.put(SpeedType.BASE, 30);
    speeds.put(SpeedType.ARMOR, 20);
    
    racialTraits = new TreeSet<RacialTrait>();
    
    // Weapon familiarity
    
    baseLanguages = new TreeSet<LanguageType>();
    baseLanguages.add(LanguageType.COMMON);
    baseLanguages.add(LanguageType.ELVEN);
    
    optionalLanguages = new TreeSet<LanguageType>();
    optionalLanguages.add(LanguageType.CELESTIAL);
    optionalLanguages.add(LanguageType.DRACONIC);
    optionalLanguages.add(LanguageType.GNOLL);
    optionalLanguages.add(LanguageType.GNOME);
    optionalLanguages.add(LanguageType.GOBLIN);
    optionalLanguages.add(LanguageType.ORC);
    optionalLanguages.add(LanguageType.SYLVAN);

    section.addItem(new RaceItem("Elf", type, racialModifiers, size, speeds, vision, racialTraits, baseLanguages, optionalLanguages));
   
    // Gnome
    type = new CreatureType(CreatureMainType.HUMANOID);
    type.addSubtype(CreatureSubtype.GNOME);
    
    racialModifiers = new ArrayList<AbilityIncrease>();
    racialModifiers.add(new AbilityIncrease(2, AbilityType.CON));
    racialModifiers.add(new AbilityIncrease(2, AbilityType.CHA));
    racialModifiers.add(new AbilityIncrease(-2, AbilityType.STR));
    
    size = SizeType.SMALL;
    
    vision = VisionType.LOW_LIGHT;
    
    speeds = new TreeMap<SpeedType, Integer>();
    speeds.put(SpeedType.BASE, 20);
    speeds.put(SpeedType.ARMOR, 15);
    
    racialTraits = new TreeSet<RacialTrait>();
    
    // Weapon Familiarity
    
    baseLanguages = new TreeSet<LanguageType>();
    baseLanguages.add(LanguageType.COMMON);
    baseLanguages.add(LanguageType.GNOME);
    baseLanguages.add(LanguageType.SYLVAN);
    
    optionalLanguages = new TreeSet<LanguageType>();
    optionalLanguages.add(LanguageType.DRACONIC);
    optionalLanguages.add(LanguageType.DWARVEN);
    optionalLanguages.add(LanguageType.ELVEN);
    optionalLanguages.add(LanguageType.GIANT);
    optionalLanguages.add(LanguageType.GOBLIN);
    optionalLanguages.add(LanguageType.ORC);

    section.addItem(new RaceItem("Gnome", type, racialModifiers, size, speeds, vision, racialTraits, baseLanguages, optionalLanguages));

    // Half-elf
    type = new CreatureType(CreatureMainType.HUMANOID);
    type.addSubtype(CreatureSubtype.ELF);
    type.addSubtype(CreatureSubtype.HUMAN);
    
    racialModifiers = new ArrayList<AbilityIncrease>();
    racialModifiers.add(new AbilityIncrease(2, AbilityType.ANY));
    
    size = SizeType.MEDIUM;
    
    vision = VisionType.LOW_LIGHT;
    
    speeds = new TreeMap<SpeedType, Integer>();
    speeds.put(SpeedType.BASE, 30);
    speeds.put(SpeedType.ARMOR, 20);
    
    racialTraits = new TreeSet<RacialTrait>();
    
    baseLanguages = new TreeSet<LanguageType>();
    baseLanguages.add(LanguageType.COMMON);
    baseLanguages.add(LanguageType.ELVEN);
    
    optionalLanguages = new TreeSet<LanguageType>();
    optionalLanguages.add(LanguageType.ABYSSAL);
    optionalLanguages.add(LanguageType.AKLO);
    optionalLanguages.add(LanguageType.AQUAN);
    optionalLanguages.add(LanguageType.AURAN);
    optionalLanguages.add(LanguageType.CELESTIAL);
    optionalLanguages.add(LanguageType.DRACONIC);
    optionalLanguages.add(LanguageType.DWARVEN);
    optionalLanguages.add(LanguageType.GIANT);
    optionalLanguages.add(LanguageType.GNOLL);
    optionalLanguages.add(LanguageType.GNOME);
    optionalLanguages.add(LanguageType.GOBLIN);
    optionalLanguages.add(LanguageType.HALFLING);
    optionalLanguages.add(LanguageType.IGNAN);
    optionalLanguages.add(LanguageType.INFERNAL);
    optionalLanguages.add(LanguageType.ORC);
    optionalLanguages.add(LanguageType.SYLVAN);
    optionalLanguages.add(LanguageType.TERRAN);
    optionalLanguages.add(LanguageType.UNDERCOMMON);

    section.addItem(new RaceItem("Half-elf", type, racialModifiers, size, speeds, vision, racialTraits, baseLanguages, optionalLanguages));

    // Half-orc
    type = new CreatureType(CreatureMainType.HUMANOID);
    type.addSubtype(CreatureSubtype.HUMAN);
    type.addSubtype(CreatureSubtype.ORC);

    racialModifiers = new ArrayList<AbilityIncrease>();
    racialModifiers.add(new AbilityIncrease(2, AbilityType.ANY));
    
    size = SizeType.MEDIUM;
    
    vision = VisionType.DARKVISION_60;
    
    speeds = new TreeMap<SpeedType, Integer>();
    speeds.put(SpeedType.BASE, 30);
    speeds.put(SpeedType.ARMOR, 20);
    
    racialTraits = new TreeSet<RacialTrait>();
    
    // Weapon Familiarity
    
    baseLanguages = new TreeSet<LanguageType>();
    baseLanguages.add(LanguageType.COMMON);
    baseLanguages.add(LanguageType.ORC);
    
    optionalLanguages = new TreeSet<LanguageType>();
    optionalLanguages.add(LanguageType.ABYSSAL);
    optionalLanguages.add(LanguageType.DRACONIC);
    optionalLanguages.add(LanguageType.GIANT);
    optionalLanguages.add(LanguageType.GNOLL);
    optionalLanguages.add(LanguageType.GOBLIN);

    section.addItem(new RaceItem("Half-orc", type, racialModifiers, size, speeds, vision, racialTraits, baseLanguages, optionalLanguages));

    // Halfling
    type = new CreatureType(CreatureMainType.HUMANOID);
    type.addSubtype(CreatureSubtype.HALFLING);

    racialModifiers = new ArrayList<AbilityIncrease>();
    racialModifiers.add(new AbilityIncrease(2, AbilityType.DEX));
    racialModifiers.add(new AbilityIncrease(2, AbilityType.CHA));
    racialModifiers.add(new AbilityIncrease(-2, AbilityType.STR));
    
    size = SizeType.SMALL;
    
    vision = VisionType.NORMAL;
    
    speeds = new TreeMap<SpeedType, Integer>();
    speeds.put(SpeedType.BASE, 20);
    speeds.put(SpeedType.ARMOR, 15);
    
    racialTraits = new TreeSet<RacialTrait>();
    
    // Weapon Familiarity
    
    baseLanguages = new TreeSet<LanguageType>();
    baseLanguages.add(LanguageType.COMMON);
    baseLanguages.add(LanguageType.HALFLING);
    
    optionalLanguages = new TreeSet<LanguageType>();
    optionalLanguages.add(LanguageType.DWARVEN);
    optionalLanguages.add(LanguageType.ELVEN);
    optionalLanguages.add(LanguageType.GNOME);
    optionalLanguages.add(LanguageType.GOBLIN);

    section.addItem(new RaceItem("Halfling", type, racialModifiers, size, speeds, vision, racialTraits, baseLanguages, optionalLanguages));

    // Human
    type = new CreatureType(CreatureMainType.HUMANOID);
    type.addSubtype(CreatureSubtype.HUMAN);

    racialModifiers = new ArrayList<AbilityIncrease>();
    racialModifiers.add(new AbilityIncrease(2, AbilityType.ANY));
    
    size = SizeType.MEDIUM;
    
    vision = VisionType.NORMAL;
    
    speeds = new TreeMap<SpeedType, Integer>();
    speeds.put(SpeedType.BASE, 30);
    speeds.put(SpeedType.ARMOR, 20);
    
    racialTraits = new TreeSet<RacialTrait>();
    
    baseLanguages = new TreeSet<LanguageType>();
    baseLanguages.add(LanguageType.COMMON);
    
    optionalLanguages = new TreeSet<LanguageType>();
    optionalLanguages.add(LanguageType.ABYSSAL);
    optionalLanguages.add(LanguageType.AKLO);
    optionalLanguages.add(LanguageType.AQUAN);
    optionalLanguages.add(LanguageType.AURAN);
    optionalLanguages.add(LanguageType.CELESTIAL);
    optionalLanguages.add(LanguageType.DRACONIC);
    optionalLanguages.add(LanguageType.DWARVEN);
    optionalLanguages.add(LanguageType.ELVEN);
    optionalLanguages.add(LanguageType.GIANT);
    optionalLanguages.add(LanguageType.GNOLL);
    optionalLanguages.add(LanguageType.GNOME);
    optionalLanguages.add(LanguageType.GOBLIN);
    optionalLanguages.add(LanguageType.HALFLING);
    optionalLanguages.add(LanguageType.IGNAN);
    optionalLanguages.add(LanguageType.INFERNAL);
    optionalLanguages.add(LanguageType.ORC);
    optionalLanguages.add(LanguageType.SYLVAN);
    optionalLanguages.add(LanguageType.TERRAN);
    optionalLanguages.add(LanguageType.UNDERCOMMON);

    section.addItem(new RaceItem("Human", type, racialModifiers, size, speeds, vision, racialTraits, baseLanguages, optionalLanguages));
    
    sections.put(section.getType(), section);
  }

  @Override
  protected void addAlternateRacialTraits(SortedMap<BookSectionType, BookSection> sections)
  {
    // Core Rulebook doesn't contain any alternate racial traits
  }

  @Override
  protected void addClasses(SortedMap<BookSectionType, BookSection> sections)
  {
    // TODO Auto-generated method stub
  }

  @Override
  protected void addClassExtensions(SortedMap<BookSectionType, BookSection> sections)
  {
    // TODO Auto-generated method stub
    
  }

  @Override
  protected void addArchetypes(SortedMap<BookSectionType, BookSection> sections)
  {
    // TODO Auto-generated method stub

  }

  @Override
  protected void addPrestigeClasses(SortedMap<BookSectionType, BookSection> sections)
  {
    // TODO Auto-generated method stub

  }

  @Override
  protected void addFeats(SortedMap<BookSectionType, BookSection> sections)
  {
    // TODO Auto-generated method stub

  }

  @Override
  protected void addEquipment(SortedMap<BookSectionType, BookSection> sections)
  {
    // TODO Auto-generated method stub

  }

  @Override
  protected void addSpells(SortedMap<BookSectionType, BookSection> sections)
  {
    // TODO Auto-generated method stub

  }

  @Override
  protected void addMonsters(SortedMap<BookSectionType, BookSection> sections)
  {
    // TODO Auto-generated method stub

  }

  @Override
  protected void addSkills(SortedMap<BookSectionType, BookSection> sections)
  {
    BookSection section = new BookSection(BookSectionType.SKILLS);
    
    section.addItem(new SkillItem("Acrobatics", AbilityType.DEX, true, true));
    section.addItem(new SkillItem("Appraise", AbilityType.INT, true, false));
    section.addItem(new SkillItem("Bluff", AbilityType.CHA, true, false));
    section.addItem(new SkillItem("Climb", AbilityType.STR, true, true));
    section.addItem(new SkillItem("Craft", AbilityType.INT, true, false));
    section.addItem(new SkillItem("Diplomacy", AbilityType.CHA, true, false));
    section.addItem(new SkillItem("Disable Device", AbilityType.DEX, false, true));
    section.addItem(new SkillItem("Disguise", AbilityType.CHA, true, false));
    section.addItem(new SkillItem("Escape Artist", AbilityType.DEX, true, true));
    section.addItem(new SkillItem("Fly", AbilityType.DEX, true, true));
    section.addItem(new SkillItem("Handle Animal", AbilityType.CHA, false, false));
    section.addItem(new SkillItem("Heal", AbilityType.WIS, true, false));
    section.addItem(new SkillItem("Intimidate", AbilityType.CHA, true, true));
    section.addItem(new SkillItem("Knowledge (arcana)", AbilityType.INT, false, false));
    section.addItem(new SkillItem("Knowledge (dungeonneering)", AbilityType.INT, false, false));
    section.addItem(new SkillItem("Knowledge (engineering)", AbilityType.INT, false, false));
    section.addItem(new SkillItem("Knowledge (geography)", AbilityType.INT, false, false));
    section.addItem(new SkillItem("Knowledge (history)", AbilityType.INT, false, false));
    section.addItem(new SkillItem("Knowledge (local)", AbilityType.INT, false, false));
    section.addItem(new SkillItem("Knowledge (nature)", AbilityType.INT, false, false));
    section.addItem(new SkillItem("Knowledge (nobility)", AbilityType.INT, false, false));
    section.addItem(new SkillItem("Knowledge (planes)", AbilityType.INT, false, false));
    section.addItem(new SkillItem("Knowledge (religion)", AbilityType.INT, false, false));
    section.addItem(new SkillItem("Linguistics", AbilityType.INT, false, false));
    section.addItem(new SkillItem("Perception", AbilityType.WIS, true, false));
    section.addItem(new SkillItem("Perform", AbilityType.CHA, true, false));
    section.addItem(new SkillItem("Profession", AbilityType.WIS, false, false));
    section.addItem(new SkillItem("Ride", AbilityType.DEX, true, true));
    section.addItem(new SkillItem("Sense Motive", AbilityType.WIS, true, false));
    section.addItem(new SkillItem("Sleight of Hand", AbilityType.DEX, false, true));
    section.addItem(new SkillItem("Spellcraft", AbilityType.INT, false, false));
    section.addItem(new SkillItem("Stealth", AbilityType.DEX, true, true));
    section.addItem(new SkillItem("Survival", AbilityType.WIS, true, false));
    section.addItem(new SkillItem("Swim", AbilityType.STR, true, true));
    section.addItem(new SkillItem("Use Magic Device", AbilityType.CHA, false, false));

    sections.put(section.getType(), section);
  }

}
