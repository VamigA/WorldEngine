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

import ru.vamiga.worldengine.WE_WorldRegistry;
import ru.vamiga.worldengine.world.biome.WE_Biome;

/**
 * ����� � ����������������� ����������� ����, ��������� ������ ��.
 * @author VamigA
 */
public class WE_WorldProperties extends WE_AbstactProperties implements WE_IWorldProperties {
	/** ������ � ������� WorldEngine. */
	public ArrayList<WE_Biome        > biomes      ;
	/** ������ � ���������� ������. ����������� ���������� genConditions �����, ����� ��������� ���������� ������� �� ���� �����. */
	public ArrayList<GenReliefLayer  > reliefLayers;
	/** ������ �� ������ ������� �����. ����������� ���������� genConditions � WE_BiomeProperties, ����� ��������� ������������� ������ �� ���� �����. */
	public ArrayList<GenBiomeMapLayer> bMapLayers  ;
	
	/** ������������� �����: 1) ���� �� ��������� (���������� ���). 2) ��������� ����������� ���� (�� ������������ ���). */
	public int defaultBiomeId, lastBiome;
	
	/**
	 * �����������. �� �������� ����� �������� ������� ��������� ������ ��������� � genConditions ����� (���������� WE_AbstactProperties �������� ���).
	 * @param defaultBiomeId_p ������������� ����� �� ��������� (����� ������ ��� � �����, ������� ������ � ������ ���� ������ ����� ��������).
	 */
	public WE_WorldProperties(int defaultBiomeId_p) {
		super(); biomes = new ArrayList<WE_Biome>(); reliefLayers = new ArrayList<GenReliefLayer>(); bMapLayers = new ArrayList<GenBiomeMapLayer>();
		defaultBiomeId = defaultBiomeId_p;
	}
	
	/**
	 * ��������� ���� � ������.
	 * @param biome ����.
	 * @return ������������� ����� � ������.
	 */
	public int addBiome(WE_Biome biome) {
		biomes.add(biome);
		return lastBiome = biomes.size() - 1;
	}
	/** ������������� ��������� ����������� ���� ��� ���� �� ���������. */
	public void setLastBiomeDefault() {
		defaultBiomeId = lastBiome;
	}
	/**
	 * ���������� ��������� ����������� � ������ ����.
	 * @return ����.
	 */
	public WE_Biome getLastBiome() {
		return biomes.get(lastBiome);
	}
	/** ������� ������ ������. */
	public void clearBiomes() {
		biomes.clear();
	}
	
	/** ��������� ��������� ���� � ������. */
	public void addReliefLayer() {
		reliefLayers.add(new GenReliefLayer()); //TODO!
	}
	/** ������� ������ ��������� �����. */
	public void clearReliefLayers() {
		reliefLayers.clear();
	}
	
	/** ��������� ���� ����� � ������. */
	public void addMapLayer() {
		bMapLayers.add(new GenBiomeMapLayer()); //TODO!
	}
	/** ������� ������ ����� �����. */
	public void clearMapLayers() {
		bMapLayers.clear();
	}
	
	/**
	 * ����� ������ �� ��������� ����� ����.
	 * ��� ������� ����� ���������� ������ ����. ��, ��������, �� ������� ������� 2 ���� (������� � ������ ������).
	 * @author VamigA
	 */
	public class GenReliefLayer implements IGenReliefLayer {
		//TODO!
	}
	
	/**
	 * ����� ������ �� ����� ������� ����� ����. ��������� Minecraft ���������� ��� ������������� ������ ����������� ����� - GenLayer.
	 * ���, ��������, ����� ������������ ������ GenBiomeMapLayer ��� ������/�����������, ������ - ��� �����������, ������ - ��� ID �����, ��������� - ��� ���.
	 * @author VamigA
	 */
	public class GenBiomeMapLayer implements IGenBiomeMapLayer {
		//TODO!
	}
	
	/**
	 * ���������� WE_Biome �� �������������� [i].
	 * @param i �������������.
	 * @return WE_Biome - ����.
	 */
	@Override
	public WE_Biome getBiome(int i) {
		return biomes.get(i);
	}
	/**
	 * ���������� WE_Biome �� ��������� (���� ������� � ���� ����� �� �������� ��� ������-���� �����, �� ����� ��������������� ���� �� ���������).
	 * @return WE_Biome - ����.
	 */
	@Override
	public WE_Biome getDefaultBiome() {
		return defaultBiomeId < sizeofBiomes() ? getBiome(defaultBiomeId) : WE_WorldRegistry.WEBiome;
	}
	/**
	 * ���������� ���������� ��������� � ������ ������: WE_Biome.
	 * @return ������ ������.
	 */
	@Override
	public int sizeofBiomes() {
		return biomes.size();
	}
	
	/**
	 * ���������� IGenReliefLayer �� �������������� [i].
	 * @param i �������������.
	 * @return IGenReliefLayer - ����.
	 */
	@Override
	public IGenReliefLayer getReliefLayer(int i) {
		return reliefLayers.get(i);
	}
	/**
	 * ���������� ���������� ��������� � ������ �����: IGenReliefLayer.
	 * @return ������ ������.
	 */
	@Override
	public int sizeofReliefLayers() {
		return reliefLayers.size();
	}
	
	/**
	 * ���������� IGenBiomeMapLayer �� �������������� [i].
	 * @param i �������������.
	 * @return IGenBiomeMapLayer - ����.
	 */
	@Override
	public IGenBiomeMapLayer getBiomeMapLayer(int i) {
		return bMapLayers.get(i);
	}
	/**
	 * ���������� ���������� ��������� � ������ �����: IGenBiomeMapLayer.
	 * @return ������ ������.
	 */
	@Override
	public int sizeofBiomeMapLayers() {
		return bMapLayers.size();
	}
}