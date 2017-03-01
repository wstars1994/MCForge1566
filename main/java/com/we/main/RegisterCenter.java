package com.we.main;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraftforge.common.MinecraftForge;

public class RegisterCenter {
	
	public static void register(Object object, int i,String name) {
		
		switch(i){
			case 1:
				registerBlock((Block)object,name);
				break;
			case 2:
	//			registerBlock((Block)object,"cBlock");
				break;
			case 3:
				registerTileEntity((Class)object,name);
				break;
			case 4:
				registerEvent(object);
				break;
		}
		
	}
	
	private static void registerEvent(Object object) {
		
		MinecraftForge.EVENT_BUS.register(object);
	
	}
	
	private static void registerBlock(Block block,String name) {
		
		GameRegistry.registerBlock(block,name);
	}
	
	private static void registerTileEntity(Class c,String name) {
		
		GameRegistry.registerTileEntity(c,name);
	}
}
