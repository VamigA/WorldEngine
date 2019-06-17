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

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Класс CommonProxy. Используется при инициализации и загрузке.
 * (!) Эти действия будут выполнены И на стороне СЕРВЕРА, И на стороне КЛИЕНТА.
 * @author VamigA
 */
public class WE_CommonProxy {
	/**
	 * Функция прединициализации.
	 * @param event - событие прединициализации.
	 */
	public void preInit(FMLPreInitializationEvent event) {
		WE_WorldRegistry.preInit(event);
	}
	
	/**
	 * Функция инициализации.
	 * @param event - событие инициализации.
	 */
	public void init(FMLInitializationEvent event) {
		WE_WorldRegistry.init(event);
	}
	
	/**
	 * Функция постинициализации.
	 * @param event - событие постинициализации.
	 */
	public void postInit(FMLPostInitializationEvent event) {
		/*/ Здесь в основном идет интеграция с другими модификациями. В WorldEngine она пока не предусмотрена. /*/
	}
}