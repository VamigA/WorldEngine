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
import ru.vamiga.worldengine.world.gen.noise.WE_IReliefGenerator;
import ru.vamiga.worldengine.world.gen.noise.WE_PerlinNoise;
import ru.vamiga.worldengine.world.gen.noise.WE_ValueNoise;

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
	
	/** �����������. �� �������� ����� �������� ������� ��������� ������ ��������� � genConditions ����� (���������� WE_AbstactProperties �������� ���). */
	public WE_WorldProperties() {
		reliefLayers = new ArrayList<GenReliefLayer  >();
		bMapLayers   = new ArrayList<GenBiomeMapLayer>();
		
		biomes = new ArrayList<WE_Biome>();
		defaultBiomeId = -1;
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
	
	/**
	 * ��������� ��������� ���� � ������.
	 * @param isPerlin ���� true, �� ����� ����������� ��� �������, ���� false - ��� ��������.
	 * @param nOcts ���������� �����.
	 * @param sx ��������� �������� �� X ���� �����.
	 * @param sz ��������� �������� �� Z ���� �����.
	 * @param inter ������������ ������� ����������� �������� (0 - ���; 1 - smoothstep; 2 - smootherstep).
	 * @param iX ������ �������������� �� X, � ������� ���������� ������������ ������� ����� ������� (� ������).
	 * @param iZ ������ �������������� �� Z, � ������� ���������� ������������ ������� ����� ������� (� ������).
	 * @param iType �� �� �����, ��� � "inter", �� ������ ��� ������������ ������� ����� �������.
	 * @param iDoIfVoid ������ "interWithAnotherBiome". ������������, ������ ���� ��������� ����� � ����, � �������� ��� ����� ���������� ����.
	 */
	public void addReliefLayer(boolean isPerlin, int nOcts, double sx, double sz, byte inter, int iX, int iZ, byte iType, boolean iDoIfVoid) {
		reliefLayers.add(new GenReliefLayer(isPerlin, nOcts, sx, sz, inter, iX, iZ, iType, iDoIfVoid));
	}
	/** ������� ������ ��������� �����. */
	public void clearReliefLayers() {
		reliefLayers.clear();
	}
	
	/**
	 * ��������� ���� ����� � ������.
	 * @param isPerlin ���� true, �� ����� ����������� ��� �������, ���� false - ��� ��������.
	 * @param gPers ��������� (����������� ��������� ��� ������ ������ ������������ ����������).
	 * @param nOcts ���������� �����.
	 * @param sx ��������� �������� �� X ���� �����.
	 * @param sy ��������� �������� �� Y ���� �����.
	 * @param sz ��������� �������� �� Z ���� �����.
	 * @param sum ������ (����� ������ ����������� � ��������� ����������).
	 * @param inter ������������ ������� ����������� �������� (0 - ���; 1 - smoothstep; 2 - smootherstep).
	 */
	public void addMapLayer(boolean isPerlin, double gPers, int nOcts, double sx, double sy, double sz, int sum, byte inter) {
		bMapLayers.add(new GenBiomeMapLayer(isPerlin, gPers, nOcts, sx, sy, sz, sum, inter));
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
		/** ������� ����� ���������� ����. */
		public WE_IReliefGenerator reliefLayerNoise;
		/** ������ ��������������, � ������� ���������� ������������ ������� ����� ������� (� ������). */
		public int[] interQuadSize;
		/** ������������ ������� ����������� �������� (0 - ���; 1 - smoothstep; 2 - smootherstep). */
		public byte interType;
		/** ������ "interWithAnotherBiome". ������������, ������ ���� ��������� ����� � ����, � �������� ��� ����� ���������� ����. */
		public boolean interDoIfVoid;
		
		/**
		 * �����������.
		 * @param isPerlin ���� true, �� ����� ����������� ��� �������, ���� false - ��� ��������.
		 * @param nOcts ���������� �����.
		 * @param sx ��������� �������� �� X ���� �����.
		 * @param sz ��������� �������� �� Z ���� �����.
		 * @param inter ������������ ������� ����������� �������� (0 - ���; 1 - smoothstep; 2 - smootherstep).
		 * @param iX ������ �������������� �� X, � ������� ���������� ������������ ������� ����� ������� (� ������).
		 * @param iZ ������ �������������� �� Z, � ������� ���������� ������������ ������� ����� ������� (� ������).
		 * @param iType �� �� �����, ��� � "inter", �� ������ ��� ������������ ������� ����� �������.
		 * @param iDoIfVoid ������ "interWithAnotherBiome". ������������, ������ ���� ��������� ����� � ����, � �������� ��� ����� ���������� ����.
		 */
		public GenReliefLayer(boolean isPerlin, int nOcts, double sx, double sz, byte inter, int iX, int iZ, byte iType, boolean iDoIfVoid) {
			reliefLayerNoise = isPerlin ?
				new WE_PerlinNoise(0L, 0.0, nOcts, sx, 0.0, sz, 0, inter) :
				new  WE_ValueNoise(0L, 0.0, nOcts, sx, 0.0, sz, 0, inter);
			interQuadSize = new int[2]; interQuadSize[0] = iX; interQuadSize[1] = iZ; interType = iType; interDoIfVoid = iDoIfVoid;
		}
		
		/**
		 * ������� ����� ���������� ���� (���������� ���).
		 * @return WE_IReliefGenerator - ���������.
		 */
		@Override
		public WE_IReliefGenerator getReliefGenerator() {
			return reliefLayerNoise;
		}
		
		/**
		 * ������ ��������������, � ������� ���������� ������������ ������� ����� ������� (� ������).
		 * @return Integer[0] - ������ �� X; Integer[1] - ������ �� Z.
		 */
		@Override
		public int[] getInterQuadSize() {
			return interQuadSize;
		}
		/**
		 * ������������ ������� ����������� �������� (0 - ���; 1 - smoothstep; 2 - smootherstep).
		 * @return ��� Byte.
		 */
		@Override
		public byte getInterType() {
			return interType;
		}
		/**
		 * ���������� �� ������ �� ���������� ����� ����� �� ������ ����� ������� �������? ������ ���������� "interWithAnotherBiome".
		 * (!) ������������ �����������, ������ ���� ��������� ����� � ����, � �������� ��� ����� ���������� ����.
		 * @return ��� Boolean.
		 */
		@Override
		public boolean getInterDoIfVoid() {
			return interDoIfVoid;
		}
	}
	
	/**
	 * ����� ������ �� ����� ������� ����� ����. ��������� Minecraft ���������� ��� ������������� ������ ����������� ����� - GenLayer.
	 * ���, ��������, ����� ������������ ������ GenBiomeMapLayer ��� ������/�����������, ������ - ��� �����������, ������ - ��� ID �����, ��������� - ��� ���.
	 * @author VamigA
	 */
	public class GenBiomeMapLayer implements IGenBiomeMapLayer {
		/** ������� ����� ���� ������� �����. */
		public WE_IReliefGenerator biomeMapLayerNoise;
		
		/**
		 * �����������.
		 * @param isPerlin ���� true, �� ����� ����������� ��� �������, ���� false - ��� ��������.
		 * @param gPers ��������� (����������� ��������� ��� ������ ������ ������������ ����������).
		 * @param nOcts ���������� �����.
		 * @param sx ��������� �������� �� X ���� �����.
		 * @param sy ��������� �������� �� Y ���� �����.
		 * @param sz ��������� �������� �� Z ���� �����.
		 * @param sum ������ (����� ������ ����������� � ��������� ����������).
		 * @param inter ������������ ������� ����������� �������� (0 - ���; 1 - smoothstep; 2 - smootherstep).
		 */
		public GenBiomeMapLayer(boolean isPerlin, double gPers, int nOcts, double sx, double sy, double sz, int sum, byte inter) {
			biomeMapLayerNoise = isPerlin ?
				new WE_PerlinNoise(0L, gPers, nOcts, sx, sy, sz, sum, inter) :
				new  WE_ValueNoise(0L, gPers, nOcts, sx, sy, sz, sum, inter);
		}
		
		/**
		 * ������� ����� ���� ������� ����� (���������� ���).
		 * @return WE_IReliefGenerator - ���������.
		 */
		@Override
		public WE_IReliefGenerator getReliefGenerator() {
			return biomeMapLayerNoise;
		}
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
		return defaultBiomeId >= 0 && defaultBiomeId < sizeofBiomes() ? getBiome(defaultBiomeId) : WE_WorldRegistry.WEBiome;
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