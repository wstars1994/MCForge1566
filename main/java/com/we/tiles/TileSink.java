package com.we.tiles;

import java.util.ArrayList;
import java.util.List;

import ic2.api.energy.tile.IEnergySink;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public class TileSink extends TileBase implements IEnergySink{

	public int devicesSize=0;
	
	public List<IEnergySink> observerList=null;
	
	public boolean isSwitch=true;
	
	private String sinkName=null;
	
	public TileSink() {
		observerList=new ArrayList<IEnergySink>();
	}
	
	@Override
	public boolean acceptsEnergyFrom(TileEntity emitter, ForgeDirection direction) {
		return true;
	}

	@Override
	public double getDemandedEnergy() {
		return 1;
	}

	@Override
	public int getSinkTier() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double injectEnergy(ForgeDirection directionFrom, double amount, double voltage) {
		
		try{
			if(amount!=0&&!this.getWorldObj().isRemote){
				if(devicesSize>0){
					List<IEnergySink> realList=new ArrayList<IEnergySink>();
					for(IEnergySink t : observerList){
						if(t.getDemandedEnergy()>0){
							realList.add(t);
						}
					}
					for(IEnergySink t : realList){
						if(t.getDemandedEnergy()>0){
							double perEu=amount/realList.size();
							t.injectEnergy(null, perEu, 1);
						}
					}
				}
			}
		}catch(Exception e){ }
		
		return 1;
	}
	
	public void startInject(List<IEnergySink> observerList) {
		this.devicesSize=observerList.size();
		this.observerList=observerList;
	}
	
	public String getSinkName() {
		return sinkName;
	}

	public void setSinkName(String sinkName) {
		this.sinkName = sinkName;
	}
}
