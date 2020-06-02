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

package ru.vamiga.worldengine.world.properties;

import net.minecraft.world.biome.Biome.Builder;

/**
 * ИНТЕРФЕЙС. Класс с пользовательскими настройками биома, генератор читает их.
 * @author VamigA
 */
public interface WE_IBiomeProperties extends WE_IPropsWithGensAndCons {
	/**
	 * Возвращает ванильный объект класса Builder (если нужно изменить цвета, дать название...).
	 * @return Ванильный мусор.
	 */
	Builder getVanillaBiomeProperties();
	
	/**
	 * Возвращает IReliefLayerTerrainPropertiesInBiome по идентификатору [i].
	 * @param i Идентификатор.
	 * @return IReliefLayerTerrainPropertiesInBiome - настройки.
	 */
	IReliefLayerTerrainPropertiesInBiome getTerrainProps(int i);
	/**
	 * Возвращает количество элементов в списке настроек: IReliefLayerTerrainPropertiesInBiome.
	 * @return Размер списка.
	 */
	int sizeofTerrainProps();
	/**
	 * ИНТЕРФЕЙС. Настройки рельефного слоя (GenReliefLayer) в этом биоме.
	 * @author VamigA
	 */
	interface IReliefLayerTerrainPropertiesInBiome {
		//TODO!
	}
}