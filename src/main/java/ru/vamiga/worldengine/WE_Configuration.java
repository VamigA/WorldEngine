/*
 * ////////////////////////////////////-
 * //#===============================//= Version: 2.0.0.1152 or later.
 * //#=-------| WorldEngine |-------=//= By Vamig Aliev (vk.com/win_vista).
 * //#===============================//= Part of VamigA_core (vk.com/vamiga).
 * ////////////////////////////////////-
 * 
 * Copyright (C) 2020 Vamig Aliev, all rights reserved.
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

import org.apache.commons.lang3.tuple.Pair;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;
import net.minecraftforge.common.ForgeConfigSpec.Builder;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;
import net.minecraftforge.common.ForgeConfigSpec.DoubleValue;
import net.minecraftforge.common.ForgeConfigSpec.IntValue;

/**
 * Конфигуратор WorldEngine. Содержит в себе настройки для пользователя.
 * Они помещаются в соответствующие файлы, где их можно вручную изменить.
 * @author VamigA
 */
public class WE_Configuration {
	/** Содержит в себе пару конфигураций: с нашей стороны (общие конфигурации) и со стороны Minecraft Forge. */
	public static Pair<CommonConfig, ForgeConfigSpec> common_pair = new Builder().configure(CommonConfig::new);
	/** Наш класс конфигураций. В данном случае - общие конфигурации для сервера и клиента. */
	public static CommonConfig common = common_pair.getLeft();
	/** Класс конфигураций от Minecraft Forge. К нему и необходимо обращаться. */
	public static ForgeConfigSpec common_spec = common_pair.getRight();
	
	/**
	 * Общие конфигурации WorldEngine для сервера и клиента.
	 * @author VamigA
	 */
	public static class CommonConfig {
		/**
		 * Конфигурации логические:
		 * 1) cfgAddWorldTypeWE - добавляет тип мира "WorldEngine" (true).
		 * 2) cfgRegisterBiomeWE - регистрирует основной биом WorldEngine (true).
		 */
		public static BooleanValue cfgAddWorldTypeWE, cfgRegisterBiomeWE;
		
		/**
		 * Конфигурации целые:
		 * 1) cfgWEBiomePWColor - цвет воды в биоме WorldEngine (16777215).
		 * 2) cfgWEBiomePWFColor - цвет водного тумана в биоме WorldEngine (16777215).
		 */
		public static IntValue cfgWEBiomePWColor, cfgWEBiomePWFColor;
		
		/**
		 * Конфигурации дробные:
		 * 1) cfgWEBiomePTemp - температура биома WorldEngine (0.5).
		 * 2) cfgWEBiomePRain - влажность биома WorldEngine (0.5).
		 * 3) cfgWEBiomePBaseHei - базовая высота биома WorldEngine (0.1). Не используется модификацией в игре.
		 * 4) cfgWEBiomePHVariat - разница высот биома WorldEngine (0.2). Не используется модификацией в игре.
		 */
		public static DoubleValue cfgWEBiomePTemp, cfgWEBiomePRain, cfgWEBiomePBaseHei, cfgWEBiomePHVariat;
		
		/**
		 * Конфигурации строковые:
		 * 1) cfgWorldTypeWEName - имя типа мира "WorldEngine" в пользовательском интерфейсе ("WorldEngine").
		 * 2) cfgWEBiomePName - имя биома WorldEngine, используемое в реестре и отображаемое в интерфейсе игры ("worldengine_standard").
		 * 3) cfgWEBiomePRType - тип дождя в биоме WorldEngine: none, rain, snow ("rain").
		 * 4) cfgWEBiomePCategor - категория биома WorldEngine: none, taiga, extreme_hills, jungle, mesa, plains, savanna, icy, the_end, beach, forest, ocean, desert, river, swamp, mushroom, nether ("none").
		 * 5) cfgWEBiomePBRgName - базовое имя биома WorldEngine для "мутаций" (""). Не используется модификацией в игре.
		 */
		public static ConfigValue<String> cfgWorldTypeWEName, cfgWEBiomePName, cfgWEBiomePRType, cfgWEBiomePCategor, cfgWEBiomePBRgName;
		
		/**
		 * Конструктор.
		 * @param builder Собственно, это класс от Minecraft Forge, который и "строит" файл конфигурации.
		 */
		public CommonConfig(Builder builder) {
			/*/ Конфигурации, влияющие на интерфейс у пользователя. /*/
			builder.push("GUI"     );
			cfgAddWorldTypeWE  = builder.comment("If it is true, world type \"WorldEngine\" will be added."  ).translation(WorldEngine.modid + ".config.addWorldTypeWE" ).define       ("addWorldTypeWE" , true                    );
			cfgWorldTypeWEName = builder.comment("WorldEngine's world type's name in the GUI."               ).translation(WorldEngine.modid + ".config.worldTypeWEName").define       ("worldTypeWEName", "WorldEngine"           );
			builder.pop();
			
			/*/ Конфигурации стандартного технического биома WorldEngine. /*/
			builder.push("WE_Biome");
			cfgRegisterBiomeWE = builder.comment("If it is true, standard WE_Biome will be registered."      ).translation(WorldEngine.modid + ".config.registerBiomeWE").define       ("registerBiomeWE", true                    );
			cfgWEBiomePName    = builder.comment("Standard biome in vanilla: biome name."                    ).translation(WorldEngine.modid + ".config.WEBiomePName"   ).define       ("WEBiomePName"   , "worldengine_standard"  );
			cfgWEBiomePRType   = builder.comment("Standard biome in vanilla: rain type."                     ).translation(WorldEngine.modid + ".config.WEBiomePRType"  ).define       ("WEBiomePRType"  , "rain"                  );
			cfgWEBiomePCategor = builder.comment("Standard biome in vanilla: category."                      ).translation(WorldEngine.modid + ".config.WEBiomePCategor").define       ("WEBiomePCategor", "none"                  );
			cfgWEBiomePTemp    = builder.comment("Standard biome in vanilla: temperature."                   ).translation(WorldEngine.modid + ".config.WEBiomePTemp"   ).defineInRange("WEBiomePTemp"   , 0.5     ,  0.0, 2.0     );
			cfgWEBiomePRain    = builder.comment("Standard biome in vanilla: rainfall."                      ).translation(WorldEngine.modid + ".config.WEBiomePRain"   ).defineInRange("WEBiomePRain"   , 0.5     ,  0.0, 1.0     );
			cfgWEBiomePBaseHei = builder.comment("Standard biome in vanilla: base height. Useless."          ).translation(WorldEngine.modid + ".config.WEBiomePBaseHei").defineInRange("WEBiomePBaseHei", 0.1     , -5.0, 5.0     );
			cfgWEBiomePHVariat = builder.comment("Standard biome in vanilla: height variation. Useless."     ).translation(WorldEngine.modid + ".config.WEBiomePHVariat").defineInRange("WEBiomePHVariat", 0.2     , -5.0, 5.0     );
			cfgWEBiomePWColor  = builder.comment("Standard biome in vanilla: water color."                   ).translation(WorldEngine.modid + ".config.WEBiomePWColor" ).defineInRange("WEBiomePWColor" , 16777215,    0, 16777215);
			cfgWEBiomePWFColor = builder.comment("Standard biome in vanilla: water fog color."               ).translation(WorldEngine.modid + ".config.WEBiomePWFColor").defineInRange("WEBiomePWFColor", 16777215,    0, 16777215);
			cfgWEBiomePBRgName = builder.comment("Standard biome in vanilla: base name (mutations). Useless.").translation(WorldEngine.modid + ".config.WEBiomePBRgName").define       ("WEBiomePBRgName", ""                      );
			builder.pop();
		}
	}
}