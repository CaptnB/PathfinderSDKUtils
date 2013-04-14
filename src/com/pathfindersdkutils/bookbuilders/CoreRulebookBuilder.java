package com.pathfindersdkutils.bookbuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import com.pathfindersdk.bonus.AcBonus;
import com.pathfindersdk.bonus.AttackBonus;
import com.pathfindersdk.bonus.CmdBonus;
import com.pathfindersdk.bonus.SaveBonus;
import com.pathfindersdk.bonus.SkillBonus;
import com.pathfindersdk.books.BookBuilder;
import com.pathfindersdk.books.BookComponent;
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
  @SuppressWarnings({"unchecked"})
  protected BookSection createRacesSection(BookSectionType type, List<BookComponent> components)
  {
    CreatureType creatureType;
    List<AbilityIncrease> racialModifiers;
    SizeType size;
    SortedMap<SpeedType, Integer> speeds;
    VisionType vision;
    SortedSet<RacialTrait> racialTraits;
    // TODO: Weapon proficiencies/familiarities
    SortedSet<LanguageType> baseLanguages;
    SortedSet<LanguageType> optionalLanguages;

    // Dwarf
    creatureType = new CreatureType(CreatureMainType.HUMANOID);
    creatureType.addSubtype(CreatureSubtype.DWARF);
    
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
    racialTraits.add(new RacialTrait("Defensive Training", new AcBonus(4, BonusTypeRegister.getInstance().get("Dodge"), "against monsters of the giant subtype")));
    racialTraits.add(new RacialTrait("Greed", new SkillBonus(2, BonusTypeRegister.getInstance().get("Racial"), "Appraise", "to determine the price of nonmagical precious metal or gemstones")));
    racialTraits.add(new RacialTrait("Hatred", new AttackBonus(1, BonusTypeRegister.getInstance().get("Racial"), "against creatures of the orc subtype"),
                                               new AttackBonus(1, BonusTypeRegister.getInstance().get("Racial"), "against creatures of the goblinoid subtype")));
    racialTraits.add(new RacialTrait("Hardy", new SaveBonus(2, BonusTypeRegister.getInstance().get("Racial"), SaveType.ALL, "against poison, spells and spell-like abilities")));
    racialTraits.add(new RacialTrait("Stability", new CmdBonus(4, BonusTypeRegister.getInstance().get("Racial"), "to resist a bull rush or trip attempt")));
    racialTraits.add(new RacialTrait("Stone Cunning", new SkillBonus(2, BonusTypeRegister.getInstance().get("Untyped"), "Perception", "to notice unusual stonework")));

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

    components.add(new RaceItem("Dwarf", creatureType, racialModifiers, size, speeds, vision, racialTraits, baseLanguages, optionalLanguages));
    
    // Elf
    creatureType = new CreatureType(CreatureMainType.HUMANOID);
    creatureType.addSubtype(CreatureSubtype.ELF);

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

    components.add(new RaceItem("Elf", creatureType, racialModifiers, size, speeds, vision, racialTraits, baseLanguages, optionalLanguages));
   
    // Gnome
    creatureType = new CreatureType(CreatureMainType.HUMANOID);
    creatureType.addSubtype(CreatureSubtype.GNOME);
    
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

    components.add(new RaceItem("Gnome", creatureType, racialModifiers, size, speeds, vision, racialTraits, baseLanguages, optionalLanguages));

    // Half-elf
    creatureType = new CreatureType(CreatureMainType.HUMANOID);
    creatureType.addSubtype(CreatureSubtype.ELF);
    creatureType.addSubtype(CreatureSubtype.HUMAN);
    
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

    components.add(new RaceItem("Half-elf", creatureType, racialModifiers, size, speeds, vision, racialTraits, baseLanguages, optionalLanguages));

    // Half-orc
    creatureType = new CreatureType(CreatureMainType.HUMANOID);
    creatureType.addSubtype(CreatureSubtype.HUMAN);
    creatureType.addSubtype(CreatureSubtype.ORC);

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

    components.add(new RaceItem("Half-orc", creatureType, racialModifiers, size, speeds, vision, racialTraits, baseLanguages, optionalLanguages));

    // Halfling
    creatureType = new CreatureType(CreatureMainType.HUMANOID);
    creatureType.addSubtype(CreatureSubtype.HALFLING);

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

    components.add(new RaceItem("Halfling", creatureType, racialModifiers, size, speeds, vision, racialTraits, baseLanguages, optionalLanguages));

    // Human
    creatureType = new CreatureType(CreatureMainType.HUMANOID);
    creatureType.addSubtype(CreatureSubtype.HUMAN);

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

    components.add(new RaceItem("Human", creatureType, racialModifiers, size, speeds, vision, racialTraits, baseLanguages, optionalLanguages));
    
    return new BookSection(type, components);
  }

  @Override
  protected BookSection createSkillsSection(BookSectionType type, List<BookComponent> components)
  {
    components.add(new SkillItem("Acrobatics", AbilityType.DEX, true, true));
    components.add(new SkillItem("Appraise", AbilityType.INT, true, false));
    components.add(new SkillItem("Bluff", AbilityType.CHA, true, false));
    components.add(new SkillItem("Climb", AbilityType.STR, true, true));
    components.add(new SkillItem("Craft", AbilityType.INT, true, false));
    components.add(new SkillItem("Diplomacy", AbilityType.CHA, true, false));
    components.add(new SkillItem("Disable Device", AbilityType.DEX, false, true));
    components.add(new SkillItem("Disguise", AbilityType.CHA, true, false));
    components.add(new SkillItem("Escape Artist", AbilityType.DEX, true, true));
    components.add(new SkillItem("Fly", AbilityType.DEX, true, true));
    components.add(new SkillItem("Handle Animal", AbilityType.CHA, false, false));
    components.add(new SkillItem("Heal", AbilityType.WIS, true, false));
    components.add(new SkillItem("Intimidate", AbilityType.CHA, true, true));
    components.add(new SkillItem("Knowledge (arcana)", AbilityType.INT, false, false));
    components.add(new SkillItem("Knowledge (dungeonneering)", AbilityType.INT, false, false));
    components.add(new SkillItem("Knowledge (engineering)", AbilityType.INT, false, false));
    components.add(new SkillItem("Knowledge (geography)", AbilityType.INT, false, false));
    components.add(new SkillItem("Knowledge (history)", AbilityType.INT, false, false));
    components.add(new SkillItem("Knowledge (local)", AbilityType.INT, false, false));
    components.add(new SkillItem("Knowledge (nature)", AbilityType.INT, false, false));
    components.add(new SkillItem("Knowledge (nobility)", AbilityType.INT, false, false));
    components.add(new SkillItem("Knowledge (planes)", AbilityType.INT, false, false));
    components.add(new SkillItem("Knowledge (religion)", AbilityType.INT, false, false));
    components.add(new SkillItem("Linguistics", AbilityType.INT, false, false));
    components.add(new SkillItem("Perception", AbilityType.WIS, true, false));
    components.add(new SkillItem("Perform", AbilityType.CHA, true, false));
    components.add(new SkillItem("Profession", AbilityType.WIS, false, false));
    components.add(new SkillItem("Ride", AbilityType.DEX, true, true));
    components.add(new SkillItem("Sense Motive", AbilityType.WIS, true, false));
    components.add(new SkillItem("Sleight of Hand", AbilityType.DEX, false, true));
    components.add(new SkillItem("Spellcraft", AbilityType.INT, false, false));
    components.add(new SkillItem("Stealth", AbilityType.DEX, true, true));
    components.add(new SkillItem("Survival", AbilityType.WIS, true, false));
    components.add(new SkillItem("Swim", AbilityType.STR, true, true));
    components.add(new SkillItem("Use Magic Device", AbilityType.CHA, false, false));

    return new BookSection(type, components);
  }

}
