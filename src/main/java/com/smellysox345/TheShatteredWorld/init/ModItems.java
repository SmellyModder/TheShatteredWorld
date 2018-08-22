package com.smellysox345.TheShatteredWorld.init;

import java.util.ArrayList;
import java.util.List;

import com.smellysox345.TheShatteredWorld.items.ItemBase;
import com.smellysox345.TheShatteredWorld.items.ItemGlinting;
import com.smellysox345.TheShatteredWorld.items.ItemShroomCurrency;
import com.smellysox345.TheShatteredWorld.items.armor.ArmorBase;
import com.smellysox345.TheShatteredWorld.items.food.ItemCustomFood;
import com.smellysox345.TheShatteredWorld.items.food.ItemCustomFoodNausea;
import com.smellysox345.TheShatteredWorld.items.food.ItemRefractiSoup;
import com.smellysox345.TheShatteredWorld.items.food.ItemShroomSoup;
import com.smellysox345.TheShatteredWorld.items.shield.ItemNagrotShield;
import com.smellysox345.TheShatteredWorld.items.shield.ItemShieldCrystal;
import com.smellysox345.TheShatteredWorld.items.tools.ToolAxe;
import com.smellysox345.TheShatteredWorld.items.tools.ToolPickaxe;
import com.smellysox345.TheShatteredWorld.items.tools.ToolSpade;
import com.smellysox345.TheShatteredWorld.items.tools.ToolSword;
import com.smellysox345.TheShatteredWorld.util.Reference;

import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;

public class ModItems {
	
	public static final List<Item>  ITEMS = new ArrayList<Item>();
	
	
	//Armor Materials
	public static final ArmorMaterial ARMOR_MATERIAL_CRYSTAL = EnumHelper.addArmorMaterial("armor_material_crystal", Reference.MODID + ":crystal", 11, new int[] {1, 5, 6, 3}, 16, SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, 0.0F);
	public static final ArmorMaterial ARMOR_MATERIAL_REFRACTI = EnumHelper.addArmorMaterial("armor_material_refracti", Reference.MODID + ":refracti", 11, new int[] {1, 4, 5, 2}, 16, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
	public static final ArmorMaterial ARMOR_MATERIAL_DARKNUT = EnumHelper.addArmorMaterial("armor_material_watcher", Reference.MODID + ":watcher", 11, new int[] {2, 4, 6, 4}, 16, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
	
	//Materials
	public static final ToolMaterial MATERIAL_CRYSTAL = EnumHelper.addToolMaterial("material_crystal", 2, 530, 6.5F, 2.2F, 13);
	public static final ToolMaterial MATERIAL_CACTI = EnumHelper.addToolMaterial("material_cacti", 2, 260, 5.5F, 1.5F, 13);
	public static final ToolMaterial MATERIAL_DARKNUT = EnumHelper.addToolMaterial("material_darknut", 3, 595, 8.0F, 3.8F, 12);
	
	//Items
	public static final Item CRYSTAL = new ItemBase("crystal");
	public static final Item CRYSTALLIZATIONCORE = new ItemGlinting("crystallizationcore");
	public static final Item PRISM = new ItemBase("prism");
	public static final Item R_STRING = new ItemBase("r_string");
	public static final Item WATCHER_STICK = new ItemBase("watcher_stick");
	public static final Item SHROOM_EMERALD = new ItemShroomCurrency("shroom_currency");
	
	//Foods
	public static final Item REFRACTEDCACTUSBUD = new ItemCustomFoodNausea("refractedcactusbud", 3, false);
	public static final Item CORRUPTEDBEEF = new ItemCustomFood("corruptedbeef", 2, false);
	public static final Item CORRUPTEDPIGBEEF = new ItemCustomFood("corruptedpigbeef", 2, false);
	public static final Item CORRUPTEDCOOKEDBEEF = new ItemCustomFood("corruptedcookedbeef", 6, false);
	public static final Item CORRUPTEDCOOKEDPORKCHOP = new ItemCustomFood("corruptedcookedpork", 6, false);
	public static final Item REFRACTISOUP = new ItemRefractiSoup("refractisoup", 7, false);
	public static final Item SHROOMSOUP = new ItemShroomSoup("shroom_soup", 8, false);
	
	//Food returns
	public static final Item R_BOWL = new ItemBase("r_bowl");
	
	//Armors
	public static final Item CRYSTAL_HELMET = new ArmorBase("crystal_helmet", ARMOR_MATERIAL_CRYSTAL, 1, EntityEquipmentSlot.HEAD);
	public static final Item CRYSTAL_BODY = new ArmorBase("crystal_chestplate", ARMOR_MATERIAL_CRYSTAL, 1, EntityEquipmentSlot.CHEST);
	public static final Item CRYSTAL_LEGGINGS = new ArmorBase("crystal_leggings", ARMOR_MATERIAL_CRYSTAL, 2, EntityEquipmentSlot.LEGS);
	public static final Item CRYSTAL_BOOTS = new ArmorBase("crystal_boots", ARMOR_MATERIAL_CRYSTAL, 2, EntityEquipmentSlot.FEET);
	
	public static final Item REFRACTI_HELMET = new ArmorBase("refracti_helmet", ARMOR_MATERIAL_REFRACTI, 1, EntityEquipmentSlot.HEAD);
	public static final Item REFRACTI_BODY = new ArmorBase("refracti_chestplate", ARMOR_MATERIAL_REFRACTI, 1, EntityEquipmentSlot.CHEST);
	public static final Item REFRACTI_LEGGINGS = new ArmorBase("refracti_leggings", ARMOR_MATERIAL_REFRACTI, 2, EntityEquipmentSlot.LEGS);
	public static final Item REFRACTI_BOOTS = new ArmorBase("refracti_boots", ARMOR_MATERIAL_REFRACTI, 2, EntityEquipmentSlot.FEET);
	
	public static final Item CRYSTAL_SHIELD = new ItemShieldCrystal("crystal_shield");
	public static final Item NAGROT_SHIELD = new ItemNagrotShield("nagrot_shield");
	
	public static final Item DARKNUT_HELMET = new ArmorBase("templar_helmet", ARMOR_MATERIAL_DARKNUT, 1, EntityEquipmentSlot.HEAD);
	public static final Item DARKNUT_BODY = new ArmorBase("templar_chestplate", ARMOR_MATERIAL_DARKNUT, 1, EntityEquipmentSlot.CHEST);
	public static final Item DARKNUT_LEGGINGS = new ArmorBase("templar_leggings", ARMOR_MATERIAL_DARKNUT, 2, EntityEquipmentSlot.LEGS);
	public static final Item DARKNUT_BOOTS = new ArmorBase("templar_boots", ARMOR_MATERIAL_DARKNUT, 2, EntityEquipmentSlot.FEET);
	
	
	
	//FancyItemModels
	public static final Item CRYSTALGUN = new ItemGlinting("crystalgun");
	
	
	//Swords
	public static final ItemSword CRYSTAL_SWORD = new ToolSword("crystal_sword", MATERIAL_CRYSTAL);
	public static final ItemSword REFRACTI_SWORD = new ToolSword("refracti_sword", MATERIAL_CACTI);
	public static final ItemSword WATCHER_SWORD = new ToolSword("watcher_sword", MATERIAL_DARKNUT);
	
	//Spades
	public static final ItemSpade CRYSTAL_SHOVEL = new ToolSpade("crystal_shovel", MATERIAL_CRYSTAL);
	public static final ItemSpade REFRACTI_SHOVEL = new ToolSpade("refracti_shovel", MATERIAL_CACTI);
	public static final ItemSpade WATCHER_SPADE = new ToolSpade("watcher_shovel", MATERIAL_DARKNUT);
	
	
	//Pickaxes
	public static final ItemPickaxe CRYSTAL_PICKAXE = new ToolPickaxe("crystal_pickaxe", MATERIAL_CRYSTAL);
	public static final ItemPickaxe REFRACTI_PICKAXE = new ToolPickaxe("refracti_pickaxe", MATERIAL_CACTI);
	public static final ItemPickaxe WATCHER_PICKAXE = new ToolPickaxe("watcher_pickaxe", MATERIAL_DARKNUT);
	
	//Axes
	public static final ItemAxe CRYSTAL_AXE = new ToolAxe("crystal_axe", MATERIAL_CRYSTAL);
	public static final ItemAxe REFRACTI_AXE = new ToolAxe("refracti_axe", MATERIAL_CACTI);
	public static final ItemAxe WATCHER_AXE = new ToolAxe("watcher_axe", MATERIAL_DARKNUT);
	
	
}
