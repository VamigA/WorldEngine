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
import net.minecraft.world.biome.Biome.Category;
import net.minecraft.world.biome.Biome.RainType;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import ru.vamiga.worldengine.WE_Configuration.CommonConfig;

/**
 * ����� � ����������������� ����������� �����, ��������� ������ ��.
 * @author VamigA
 */
public class WE_BiomeProperties extends WE_AbstactProperties implements WE_IBiomeProperties {
	/** ��������� �����. */
	public Builder vanillaShit;
	
	/**
	 * ������ �� ���������� ������� � ���� ����� ��� ������� ���������� ���� � ������ WE_WorldProperties.
	 * layersTProps[i] ����� ����� �������� ��� reliefLayers[i] � ������ WE_WorldProperties. �� ����� ������� � ������ ������� �������, ��� ����� �����.
	 */
	public ArrayList<ReliefLayerTerrainPropertiesInBiome> layersTProps;
	
	/** �����������. �� �������� ����� �������� ������� ��������� ����� � genConditions ����� (���������� WE_AbstactProperties �������� ���). */
	public WE_BiomeProperties() {
		layersTProps = new ArrayList<ReliefLayerTerrainPropertiesInBiome>();
		
		RainType rt;
		switch(CommonConfig.cfgWEBiomePRType  .get()) {
			default:
			case "none": rt = RainType.NONE; break;
			case "rain": rt = RainType.RAIN; break;
			case "snow": rt = RainType.SNOW; break;
		}
		
		Category c ;
		switch(CommonConfig.cfgWEBiomePCategor.get()) {
			default:
			case "none"         : c = Category.NONE         ; break;
			case "taiga"        : c = Category.TAIGA        ; break;
			case "extreme_hills": c = Category.EXTREME_HILLS; break;
			case "jungle"       : c = Category.JUNGLE       ; break;
			case "mesa"         : c = Category.MESA         ; break;
			case "plains"       : c = Category.PLAINS       ; break;
			case "savanna"      : c = Category.SAVANNA      ; break;
			case "icy"          : c = Category.ICY          ; break;
			case "the_end"      : c = Category.THEEND       ; break;
			case "beach"        : c = Category.BEACH        ; break;
			case "forest"       : c = Category.FOREST       ; break;
			case "ocean"        : c = Category.OCEAN        ; break;
			case "desert"       : c = Category.DESERT       ; break;
			case "river"        : c = Category.RIVER        ; break;
			case "swamp"        : c = Category.SWAMP        ; break;
			case "mushroom"     : c = Category.MUSHROOM     ; break;
			case "nether"       : c = Category.NETHER       ; break;
		}
		
		vanillaShit = new Builder();
		vanillaShit.surfaceBuilder(SurfaceBuilder.NOPE, SurfaceBuilder.GRASS_DIRT_GRAVEL_CONFIG);
		vanillaShit.precipitation (rt                                                          );
		vanillaShit.category      (c                                                           );
		vanillaShit.depth         (CommonConfig.cfgWEBiomePBaseHei.get().floatValue()          );
		vanillaShit.scale         (CommonConfig.cfgWEBiomePHVariat.get().floatValue()          );
		vanillaShit.temperature   (CommonConfig.cfgWEBiomePTemp   .get().floatValue()          );
		vanillaShit.downfall      (CommonConfig.cfgWEBiomePRain   .get().floatValue()          );
		vanillaShit.waterColor    (CommonConfig.cfgWEBiomePWColor .get()                       );
		vanillaShit.waterFogColor (CommonConfig.cfgWEBiomePWFColor.get()                       );
		vanillaShit.parent        (CommonConfig.cfgWEBiomePBRgName.get()                       );
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