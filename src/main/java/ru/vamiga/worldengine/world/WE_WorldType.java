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

package ru.vamiga.worldengine.world;

import java.util.function.LongFunction;

import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.IExtendedNoiseRandom;
import net.minecraft.world.gen.OverworldGenSettings;
import net.minecraft.world.gen.area.IArea;
import net.minecraft.world.gen.area.IAreaFactory;
import net.minecraftforge.registries.ForgeRegistries;
import ru.vamiga.worldengine.WE_Configuration.CommonConfig;
import ru.vamiga.worldengine.WE_WorldRegistry;
import ru.vamiga.worldengine.WorldEngine;
import ru.vamiga.worldengine.util.WE_Interpolation;
import ru.vamiga.worldengine.world.biome.WE_Biome;
import ru.vamiga.worldengine.world.gen.WE_ChunkGenerator;
import ru.vamiga.worldengine.world.properties.WE_AbstactProperties.GenReliefConditions.PrimitiveCondition;
import ru.vamiga.worldengine.world.properties.WE_BiomeProperties;

/**
 * Тип мира WorldEngine. Добавляет новый тип мира в игру.
 * @author VamigA
 */
public class WE_WorldType extends WorldType {
	public WE_WorldType() {
		super(CommonConfig.cfgWorldTypeWEName.get());
		
		WE_WorldRegistry.WEWorldProps.addReliefLayer(true, 4, 400.0, 400.0, WE_Interpolation.I_VALUEFUNC_SMOOTHERSTEP);
		WE_WorldRegistry.WEWorldProps.addMapLayer(false, 0.5, 4, 100.0, 10, 100.0, 0, WE_Interpolation.I_VALUEFUNC_SMOOTHERSTEP);
		
		WE_BiomeProperties p1 = new WE_BiomeProperties();
		p1.genConditions.addCon(PrimitiveCondition.PC_ACTION_MOREEQUAL);
		p1.genConditions.getLast().getFirstMath().addNum(0, true);
		p1.genConditions.getLast().getSecondMath().addNum(0, false);
		WE_BiomeProperties p2 = new WE_BiomeProperties();
		p2.genConditions.addCon(PrimitiveCondition.PC_ACTION_LESS);
		p2.genConditions.getLast().getFirstMath().addNum(0, true);
		p2.genConditions.getLast().getSecondMath().addNum(0, false);
		
		WE_Biome b1 = new WE_Biome(p1), b2 = new WE_Biome(p2);
		
		WE_WorldRegistry.WEWorldProps.addBiome(b1);
		WE_WorldRegistry.WEWorldProps.addBiome(b2);
	}
	
	@Override
	public ChunkGenerator<?> createChunkGenerator(World world) {
		return new WE_ChunkGenerator<>(world, WE_WorldRegistry.WEWorldProps); //TODO Костыли!
	}
	
	@Override
	public <T extends IArea, C extends IExtendedNoiseRandom<T>> IAreaFactory<T> getBiomeLayer(IAreaFactory<T> parentLayer, OverworldGenSettings chunkSettings, LongFunction<C> contextFactory) {
		return null;
	}
}