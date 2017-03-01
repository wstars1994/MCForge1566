package com.we.tiles;

import ic2.api.energy.event.EnergyTileLoadEvent;
import ic2.api.energy.event.EnergyTileUnloadEvent;
import ic2.api.energy.tile.IEnergyTile;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.MinecraftForge;

public class TileBase extends TileEntity implements IEnergyTile{

	private boolean loaded = false;
	

	public void loadTile(){
		if(this.loaded==false)
		{
			MinecraftForge.EVENT_BUS.post(new EnergyTileLoadEvent(this));
		}
		this.loaded=true;
	}
	
	public void unloadTile(){
		if(this.loaded&&this!=null){
			MinecraftForge.EVENT_BUS.post(new EnergyTileUnloadEvent(this));
		}
	}
	
	/* 
	 */
	@Override
	public void onChunkUnload() {
		if(this.loaded)
			unloadTile();
		super.onChunkUnload();
	}
	@Override
	public void validate() {
		if(!this.getWorldObj().isRemote){
			loadTile();
		}
		super.validate();
	}
}
