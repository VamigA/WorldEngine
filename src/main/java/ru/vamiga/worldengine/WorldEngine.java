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

import org.apache.logging.log4j.Logger;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Главный класс WorldEngine: 1) Инициализирует модификацию. 2) Содержит важную информацию о модификации.
 * @author VamigA
 */
@Mod(modid = WorldEngine.modid, name = WorldEngine.name, version = WorldEngine.version)
public class WorldEngine {
	/** Информация: 1) modid - идентификатор модификации. 2) name - имя модификации. 3) version - версия модификации. */
	public static final String modid = "worldengine", name = "WorldEngine", version = "2.0.0.1122";
	
	/** Proxy-классы модификации. Делят процессы между сервером и клиентом. */
	@SidedProxy(serverSide = "ru.vamiga.worldengine.WE_CommonProxy", clientSide = "ru.vamiga.worldengine.WE_ClientProxy")
	public static WE_CommonProxy proxy;
	
	/** Журнал модификации. */
	public static Logger log;
	
	/**
	 * Функция прединициализации (вызывает соответствующую функцию proxy-класса).
	 * @param event - событие прединициализации.
	 */
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		proxy.preInit(event);
	}
	
	/**
	 * Функция инициализации (вызывает соответствующую функцию proxy-класса).
	 * @param event - событие инициализации.
	 */
	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.init(event);
	}
	
	/**
	 * Функция постинициализации (вызывает соответствующую функцию proxy-класса).
	 * @param event - событие постинициализации.
	 */
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		proxy.postInit(event);
	}
	
	/**
	 * Записывает сообщение в журнал модификации. Вы можете увидеть текст в консоли.
	 * @param message - текст сообщения.
	 */
	public static void log(String message) {
		log.info("|#WorldEngine#|>=- " + message);
	}
}