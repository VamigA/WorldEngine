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
 * ����� � ����������������� ����������� �����, ��������� ������ ��.
 * @author VamigA
 */
public class WE_BiomeProperties extends WE_AbstactProperties implements WE_IBiomeProperties {
	/** ��������� �����. */
	public Builder vanillaShit; //TODO!
	
	/**
	 * ������ �� ���������� ������� � ���� ����� ��� ������� ���������� ���� � ������ WE_WorldProperties.
	 * layersTProps[i] ����� ����� �������� ��� reliefLayers[i] � ������ WE_WorldProperties. �� ����� ������� � ������ ������� �������, ��� ����� �����.
	 */
	public ArrayList<ReliefLayerTerrainPropertiesInBiome> layersTProps;
	
	/** �����������. �� �������� ����� �������� ������� ��������� ����� � genConditions ����� (���������� WE_AbstactProperties �������� ���). */
	public WE_BiomeProperties() {
		super(); vanillaShit = new Builder(); layersTProps = new ArrayList<ReliefLayerTerrainPropertiesInBiome>();
	}
	
	/** ��������� �������� ������� � ���� ����� � ������. */
	public void add() {
		layersTProps.add(new ReliefLayerTerrainPropertiesInBiome()); //TODO!
	}
	/** ������� ������ ������� ������� � ���� �����. */
	public void clear() {
		layersTProps.clear();
	}
	
	/**
	 * ��������� ���������� ���� (GenReliefLayer) � ���� �����.
	 * @author VamigA
	 */
	public class ReliefLayerTerrainPropertiesInBiome implements IReliefLayerTerrainPropertiesInBiome {
		//TODO!
	}
	
	/**
	 * ���������� ��������� ������ ������ Builder (���� ����� �������� �����, ���� ��������...).
	 * @return ��������� �����.
	 */
	@Override
	public Builder getVanillaBiomeProperties() {
		return vanillaShit;
	}
	
	/**
	 * ���������� IReliefLayerTerrainPropertiesInBiome �� �������������� [i].
	 * @param i �������������.
	 * @return IReliefLayerTerrainPropertiesInBiome - ���������.
	 */
	@Override
	public IReliefLayerTerrainPropertiesInBiome getTerrainProps(int i) {
		return layersTProps.get(i);
	}
	/**
	 * ���������� ���������� ��������� � ������ ��������: IReliefLayerTerrainPropertiesInBiome.
	 * @return ������ ������.
	 */
	@Override
	public int sizeofTerrainProps() {
		return layersTProps.size();
	}
}