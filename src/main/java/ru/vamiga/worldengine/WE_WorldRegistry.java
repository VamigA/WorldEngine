/*
 * ////////////////////////////////////-
 * //#===============================//= Version: 2.0.0.1122 or later.
 * //#=-------| WorldEngine |-------=//= By Vamig Aliev (vk.com/win_vista).
 * //#===============================//= Part of VamigA_core (vk.com/vamiga).
 * ////////////////////////////////////-
 * 
 * Copyright (C) 2019 Vamig Aliev, all rights reserved.
 * Licensed under the GNU LGPL 3 or later.
 * 
 * This file is part of WorldEngine.
 * 
 * WorldEngine  is  free  software:  you can  redistribute  it  and/or  modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the  Free  Software  Foundation,  either  version  3  of  the  License,  or
 * (at your option) any later version.
 * 
 * WorldEngine   is   distributed  in  the  hope  that  it  will   be   useful,
 * but   WITHOUT   ANY  WARRANTY;  without  even  the  implied   warranty   of
 * MERCHANTABILITY   or   FITNESS   FOR   A  PARTICULAR   PURPOSE.   See   the
 * GNU Lesser General Public License for more details.
 * 
 * You  should  have received a copy of the GNU Lesser General Public  License
 * along with WorldEngine. If not, see <https://www.gnu.org/licenses/>.
 */

package ru.vamiga.worldengine;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import ru.vamiga.worldengine.world.WE_WorldType;

/**
 * ������������� ���� WorldEngine. ��������� �������� ������ ��� ������� ����.
 * ������������, ����������� � ��������� �������� ��� �����������.
 * @author VamigA
 */
public class WE_WorldRegistry {
	/** ��� ���� "WorldEngine". ��������� ������ ��������� ���� ��� ����� � ����. */
	public static WE_WorldType WEWorldType;
	/** �������� (�����������) ������ ���� WorldEngine. */
	public static WE_Biome WEBiome;
	
	/**
	 * ������������ ����������:
	 * 1) cfgAddWorldTypeWE - ��������� ��� ���� "WorldEngine" (true).
	 * 2) cfgRegisterBiomeWE - ������������ �������� ���� WorldEngine (true).
	 * 3) cfgWEBiomePWRain - ���������� ����� � ����� WorldEngine (true).
	 * 4) cfgWEBiomePWSnow - ���������� �������� � ����� WorldEngine (false).
	 */
	public static boolean cfgAddWorldTypeWE, cfgRegisterBiomeWE, cfgWEBiomePWRain, cfgWEBiomePWSnow;
	
	/**
	 * ������������ �����:
	 * 1) cfgWEBiomePWColor - ���� ���� � ����� WorldEngine (16777215).
	 */
	public static int cfgWEBiomePWColor;
	
	/**
	 * ������������ �������:
	 * 1) cfgWEBiomePTemp - ����������� ����� WorldEngine (0.5).
	 * 2) cfgWEBiomePRain - ��������� ����� WorldEngine (0.5).
	 * 3) cfgWEBiomePBaseHei - ������� ������ ����� WorldEngine (0.1). �� ������������ ������������ � ����.
	 * 4) cfgWEBiomePHVariat - ������� ����� ����� WorldEngine (0.2). �� ������������ ������������ � ����.
	 */
	public static float cfgWEBiomePTemp, cfgWEBiomePRain, cfgWEBiomePBaseHei, cfgWEBiomePHVariat;
	
	/**
	 * ������������ ���������:
	 * 1) cfgWorldTypeWEName - ��� ���� ���� "WorldEngine" � ���������������� ���������� ("WorldEngine").
	 * 2) cfgWEBiomePName - ��� ����� WorldEngine, ������������ � ������� � ������������ � ���������� ���� ("-=|_/WorldEngine\_|=-").
	 * 3) cfgWEBiomePBRgName - ������� ��� ����� WorldEngine ��� "�������" (""). �� ������������ ������������ � ����.
	 */
	public static String cfgWorldTypeWEName, cfgWEBiomePName, cfgWEBiomePBRgName;
	
	/**
	 * ������� �����������������.
	 * @param event - ������� �����������������.
	 */
	public static void preInit(FMLPreInitializationEvent event) {
		/*/ ������������� ������� �����������... /*/
		WorldEngine.log = event.getModLog();
		WorldEngine.log("////////////////////////////////////-"                                       );
		WorldEngine.log("//#===============================//=* Version: " + WorldEngine.version + ".");
		WorldEngine.log("//#=-------| WorldEngine |-------=//=* By Vamig Aliev (vk.com/win_vista)."   );
		WorldEngine.log("//#===============================//=* Part of VamigA_core (vk.com/vamiga)." );
		WorldEngine.log("////////////////////////////////////-"                                       );
		WorldEngine.log("-=| Copyright (C) 2019 Vamig Aliev, all rights reserved."                    );
		WorldEngine.log("-=| Licensed under the GNU LGPL 3 or later."                                 );
		
		/*/ ������ ������ ������������... /*/
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		cfgAddWorldTypeWE  = config.getBoolean("addWorldTypeWE" , "GUI"     , true                    , "If it is true, world type \"WorldEngine\" will be added."  );
		cfgWorldTypeWEName = config.getString ("worldTypeWEName", "GUI"     , "WorldEngine"           , "WorldEngine's world type's name in the GUI."               );
		cfgRegisterBiomeWE = config.getBoolean("registerBiomeWE", "WE_Biome", true                    , "If it is true, standard WE_Biome will be registered."      );
		cfgWEBiomePName    = config.getString ("WEBiomePName"   , "WE_Biome", "-=|_/WorldEngine\\_|=-", "Standard biome in vanilla: biome name."                    );
		cfgWEBiomePTemp    = config.getFloat  ("WEBiomePTemp"   , "WE_Biome", 0.5F, 0.0F, 2.0F        , "Standard biome in vanilla: temperature."                   );
		cfgWEBiomePRain    = config.getFloat  ("WEBiomePRain"   , "WE_Biome", 0.5F, 0.0F, 1.0F        , "Standard biome in vanilla: rainfall."                      );
		cfgWEBiomePBaseHei = config.getFloat  ("WEBiomePBaseHei", "WE_Biome", 0.1F, -5.0F, 5.0F       , "Standard biome in vanilla: base height. Useless."          );
		cfgWEBiomePHVariat = config.getFloat  ("WEBiomePHVariat", "WE_Biome", 0.2F, -5.0F, 5.0F       , "Standard biome in vanilla: height variation. Useless."     );
		cfgWEBiomePWRain   = config.getBoolean("WEBiomePWRain"  , "WE_Biome", true                    , "Standard biome in vanilla: enable rain."                   );
		cfgWEBiomePWSnow   = config.getBoolean("WEBiomePWSnow"  , "WE_Biome", false                   , "Standard biome in vanilla: enable snow."                   );
		cfgWEBiomePWColor  = config.getInt    ("WEBiomePWColor" , "WE_Biome", 16777215, 0, 16777215   , "Standard biome in vanilla: water color."                   );
		cfgWEBiomePBRgName = config.getString ("WEBiomePBRgName", "WE_Biome", ""                      , "Standard biome in vanilla: base name (mutations). Useless.");
		config.save();
		
		/*/ �������� ��������� ����� �����������... /*/
		WEBiome = new WE_Biome();
	}
	
	/**
	 * ������� �������������.
	 * @param event - ������� �������������.
	 */
	public static void init(FMLInitializationEvent event) {
		/*/ ���������� ���� ���� "WorldEngine"... /*/
		if(cfgAddWorldTypeWE)
			WEWorldType = new WE_WorldType();
		
		/*/ ����������� ��������� ����� �����������... /*/
		if(cfgRegisterBiomeWE) {
			WEBiome.setRegistryName(cfgWEBiomePName);
			ForgeRegistries.BIOMES.register(WEBiome);
		}
	}
}