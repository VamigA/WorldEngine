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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig.Type;

/**
 * ������� ����� WorldEngine: �������������� ����������� � �������� ������ ���������� � �����������.
 * @author VamigA
 */
@Mod(WorldEngine.modid)
public class WorldEngine {
	/** ����������: 1) modid - ������������� �����������. 2) name - ��� �����������. 3) version - ������ �����������. */
	public static final String modid = "worldengine", name = "WorldEngine", version = "2.0.0.1152";
	/** ������ ����������� (��� ������ ���������� � ����� ������ ����). */
	public static Logger log;
	
	/** �����������. ������������ WorldEngine � Minecraft. */
	public WorldEngine() {
		log = LogManager.getLogger();
		log("////////////////////////////////////-"                                       );
		log("//#===============================//=* Version: " + WorldEngine.version + ".");
		log("//#=-------| WorldEngine |-------=//=* By Vamig Aliev (vk.com/win_vista)."   );
		log("//#===============================//=* Part of VamigA_core (vk.com/vamiga)." );
		log("////////////////////////////////////-"                                       );
		log("-=| Copyright (C) 2020 Vamig Aliev, all rights reserved."                    );
		log("-=| Licensed under the GNU LGPL 3 or later."                                 );
		
		ModLoadingContext.get().registerConfig(Type.COMMON, WE_Configuration.common_spec);
		
		WE_WorldRegistry.register();
	}
	
	/**
	 * ���������� ��������� � ������ �����������. �� ������ ������� ����� � �������.
	 * @param message - ����� ���������.
	 */
	public static void log(String message) {
		log.info("|#WorldEngine#|>=- " + message);
	}
}