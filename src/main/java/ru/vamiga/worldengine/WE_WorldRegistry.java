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

import ru.vamiga.worldengine.WE_Configuration.CommonConfig;
import ru.vamiga.worldengine.world.WE_WorldType;
import ru.vamiga.worldengine.world.biome.WE_Biome;

/**
 * Инициализатор мира WorldEngine. Выполняет основную работу при запуске игры.
 * Регистрирует, настраивает и запускает основной код модификации.
 * @author VamigA
 */
public class WE_WorldRegistry {
	/** Тип мира "WorldEngine". Позволяет игроку создавать свой мир прямо в меню. */
	public static WE_WorldType WEWorldType;
	/** Основной (технический) единый биом WorldEngine. */
	public static WE_Biome WEBiome;
	
	/**
	 * Функция прединициализации.
	 * @param event - событие прединициализации.
	 */
	public static void register() {
		/*/ Создание основного биома модификации... /*/
	//	WEBiome = new WE_Biome();
		
		/*/ Добавление типа мира "WorldEngine"... /*/
		if(CommonConfig.cfgAddWorldTypeWE.get())
			WEWorldType = new WE_WorldType();
		
	//	/*/ Регистрация основного биома модификации... /*/
	//	if(cfgRegisterBiomeWE) {
	//		WEBiome.setRegistryName(cfgWEBiomePName);
	//		ForgeRegistries.BIOMES.register(WEBiome);
	//	}
	}
}