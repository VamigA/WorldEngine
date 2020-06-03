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

import java.util.ArrayList;

import net.minecraft.world.biome.Biome.Builder;

/**
 * Класс с пользовательскими настройками биома, генератор читает их.
 * @author VamigA
 */
public class WE_BiomeProperties extends WE_AbstactProperties implements WE_IBiomeProperties {
	/** Ванильный мусор. */
	public Builder vanillaShit; //TODO!
	
	/**
	 * Список со свойствами рельефа в этом биоме для каждого рельефного слоя в классе WE_WorldProperties.
	 * layersTProps[i] здесь будет применен для reliefLayers[i] в классе WE_WorldProperties. Но можно создать и меньше свойств рельефа, чем самих слоев.
	 */
	public ArrayList<ReliefLayerTerrainPropertiesInBiome> layersTProps;
	
	/** Конструктор. Не забудьте позже отметить условия генерации биома в genConditions здесь (суперкласс WE_AbstactProperties содержит его). */
	public WE_BiomeProperties() {
		super(); vanillaShit = new Builder(); layersTProps = new ArrayList<ReliefLayerTerrainPropertiesInBiome>();
	}
	
	/** Добавляет свойства рельефа в этом биоме в список. */
	public void add() {
		layersTProps.add(new ReliefLayerTerrainPropertiesInBiome()); //TODO!
	}
	/** Очищает список свойств рельефа в этом биоме. */
	public void clear() {
		layersTProps.clear();
	}
	
	/**
	 * Настройки рельефного слоя (GenReliefLayer) в этом биоме.
	 * @author VamigA
	 */
	public class ReliefLayerTerrainPropertiesInBiome implements IReliefLayerTerrainPropertiesInBiome {
		//TODO!
	}
	
	/**
	 * Возвращает ванильный объект класса Builder (если нужно изменить цвета, дать название...).
	 * @return Ванильный мусор.
	 */
	@Override
	public Builder getVanillaBiomeProperties() {
		return vanillaShit;
	}
	
	/**
	 * Возвращает IReliefLayerTerrainPropertiesInBiome по идентификатору [i].
	 * @param i Идентификатор.
	 * @return IReliefLayerTerrainPropertiesInBiome - настройки.
	 */
	@Override
	public IReliefLayerTerrainPropertiesInBiome getTerrainProps(int i) {
		return layersTProps.get(i);
	}
	/**
	 * Возвращает количество элементов в списке настроек: IReliefLayerTerrainPropertiesInBiome.
	 * @return Размер списка.
	 */
	@Override
	public int sizeofTerrainProps() {
		return layersTProps.size();
	}
}