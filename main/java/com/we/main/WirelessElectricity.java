package com.we.main;

import com.we.block.BlockLowWireless;
import com.we.tiles.TileLowWireless;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

@Mod(modid = WirelessElectricity.MODID, version = WirelessElectricity.VERSION)
public class WirelessElectricity
{
    public static final String MODID = "WirelessElectricity";
    public static final String VERSION = "1.0";
    @Mod.Instance("WirelessElectricity")
    public static WirelessElectricity instance = new WirelessElectricity();
  
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	
//    	BlockMediumWireless blockMediumWireless =new BlockMediumWireless(Material.rock,CreativeTabs.tabBlock,Constant.WE_W_MEDIUM);
//    	RegisterCenter.register(blockMediumWireless,Constant.WE_R_BLOCK,"WEMediumBlock");
//    	RegisterCenter.register(TileMediumWireless.class,Constant.WE_R_TILES,"WEMediumTiles");
//    	
//    	BlockHightWireless blockHightWireless =new BlockHightWireless(Material.rock,CreativeTabs.tabBlock,Constant.WE_W_HIGHT);
//    	RegisterCenter.register(blockHightWireless,Constant.WE_R_BLOCK,"WEHightBlock");
//    	RegisterCenter.register(TileHightWireless.class,Constant.WE_R_TILES,"WEHightTiles");
//    	
//    	RegisterCenter.register(new EventCustom(),Constant.WE_R_EVENT,null);
    	
    }
    
    @EventHandler
    public void preLoad(FMLPreInitializationEvent event)
    {
    	BlockLowWireless blockWireless =new BlockLowWireless(Material.rock,CreativeTabs.tabBlock,Constant.WE_W_LOW);
    	RegisterCenter.register(blockWireless,Constant.WE_R_BLOCK,"WELowBlock");
    	RegisterCenter.register(TileLowWireless.class,Constant.WE_R_TILES,"WELowTiles");
    	
    }
}
