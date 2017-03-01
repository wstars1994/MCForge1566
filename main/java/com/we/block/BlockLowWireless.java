package com.we.block;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockLowWireless extends BlockWirelessBase{

	
	/**
	 * @param p_i45386_1_
	 * @param creativeTabs
	 * @param wirelessLevel
	 */
	public BlockLowWireless(Material p_i45386_1_, CreativeTabs creativeTabs, int wirelessLevel) {
		super(p_i45386_1_, creativeTabs, wirelessLevel);
		this.setBlockName("WELowBlock");
		this.setBlockTextureName("wirelesselectricity:WELowBlock");
	}
}
