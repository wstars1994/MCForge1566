package com.we.block;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockMediumWireless extends BlockWirelessBase{

	
	/**
	 * @param p_i45386_1_
	 * @param creativeTabs
	 * @param wirelessLevel
	 */
	public BlockMediumWireless(Material p_i45386_1_, CreativeTabs creativeTabs, int wirelessLevel) {
		super(p_i45386_1_, creativeTabs, wirelessLevel);
		this.setBlockName("WEMediumBlock");
	}
}
