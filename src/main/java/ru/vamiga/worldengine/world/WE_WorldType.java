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

package ru.vamiga.worldengine.world;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiCreateWorld;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.gen.ChunkGeneratorSettings;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import ru.vamiga.worldengine.WE_WorldRegistry;

/**
 * Тип мира WorldEngine. Добавляет новый тип мира в игру.
 * @author VamigA
 */
public class WE_WorldType extends WorldType {
	/** Конструктор. */
	public WE_WorldType() {
		super(WE_WorldRegistry.cfgWorldTypeWEName);
	}
	
	/**
	 * Создает и выдает игре главный контроллер биомов WorldEngine.
	 * @param world - класс мира.
	 */
	@Override
	public BiomeProvider getBiomeProvider(World world) {
		return new WE_BiomeProvider(world, WE_WorldRegistry.WEGenWorldProperties);
	}
	
	/**
	 * Создает и выдает игре главный генератор мира WorldEngine.
	 * @param world - класс мира.
	 * @param generatorOptions - настройки стандартного генератора Minecraft (не нужны для WorldEngine).
	 */
	@Override
	public IChunkGenerator getChunkGenerator(World world, String generatorOptions) {
		return new WE_ChunkGenerator(world);
	}
	
	/** WorldEngine не использует это. Данная функция не нужна для генераторов WorldEngine. */
	@Override
	public GenLayer getBiomeLayer(long worldSeed, GenLayer parentLayer, ChunkGeneratorSettings chunkSettings) {
		return null;
	}
	
	/** Выдает правильное имя типа мира WorldEngine для отображения в интерфейсе. */
	@Override
	@SideOnly(Side.CLIENT)
	public String getTranslationKey() {
		return WE_WorldRegistry.cfgWorldTypeWEName;
	}
	
	/** Выдает правильное имя типа мира WorldEngine для отображения в интерфейсе. */
	@Override
	@SideOnly(Side.CLIENT)
	public String getInfoTranslationKey() {
		return WE_WorldRegistry.cfgWorldTypeWEName;
	}
	
	/** Можно ли настроить генерацию этого мира? При true в интерфейсе будет кнопка настройки. */
	@Override
	public boolean isCustomizable() {
		return true;
	}
	
	/**
	 * Действие при нажатии на кнопку настройки. Вызывает соответствующий интерфейс.
	 * @param instance - главный класс самой игры Minecraft.
	 * @param guiCreateWorld - нынешний отображаемый интерфейс.
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public void onCustomizeButton(Minecraft instance, GuiCreateWorld guiCreateWorld) {
		//instance.displayGuiScreen(new WE_CreateGUI(guiCreateWorld));
	}
}