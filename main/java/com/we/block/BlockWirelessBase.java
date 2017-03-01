
package com.we.block;

import java.util.ArrayList;
import java.util.List;

import com.boomzz.core.Constant;
import com.boomzz.core.FunnyQQ;
import com.boomzz.core.IQRCodeLogin;
import com.we.gui.WEGUIBase;
import com.we.main.WirelessElectricity;
import com.we.tiles.TileHightWireless;
import com.we.tiles.TileLowWireless;
import com.we.tiles.TileMediumWireless;
import com.we.tiles.TileSink;

import ic2.api.energy.tile.IEnergySink;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class BlockWirelessBase extends BlockContainer{

	private int wirelessLevel=0;
	
	private List<TileSink> tileSinkList;
	
	protected BlockWirelessBase(Material p_i45386_1_,CreativeTabs creativeTabs,int wirelessLevel) {
		super(p_i45386_1_);
		this.setCreativeTab(creativeTabs);
		this.wirelessLevel=wirelessLevel;
		tileSinkList=new ArrayList<TileSink>();
	}

	@Override
	public TileEntity createNewTileEntity(World world, int p_149915_2_) {
		if(!world.isRemote){
			
			switch(wirelessLevel){
			case 16:
				return new TileLowWireless();
			case 32:
				return new TileMediumWireless();
			case 64:
				return new TileHightWireless();
			}
			
		}
		return null;
	}
	
	@Override
	public void breakBlock(World world, int x, int y, int z, Block p_149749_5_, int p_149749_6_) {
		TileSink sink=(TileSink) world.getTileEntity(x, y, z);
		if(sink!=null)
			sink.unloadTile();
		super.breakBlock(world, x, y, z, p_149749_5_, p_149749_6_);
	}
	
	@Override
	public boolean onBlockActivated(World world, int i, int j, int k, EntityPlayer player, int s, float f1, float f2, float f3) {
		if(!world.isRemote){
			
			IQRCodeLogin funnyQQ=new FunnyQQ();
			boolean status=funnyQQ.getQRCodeForMobile();
			if(status){
				String url=Constant.URL_GET_LOGIN_POLLING.replace("#ptqrtoken#", funnyQQ.getPtqrToken());
				funnyQQ.loginPolling(url);
			}
			
//			 Minecraft mc = Minecraft.getMinecraft();
//		    mc.displayGuiScreen(new WEGUIBase(mc.currentScreen));
//			player.openGui(WirelessElectricity.instance, 1, world, i, j, k);
			
//			TileSink sink=(TileSink) world.getTileEntity(i, j, k);
//			if(sink!=null&&!tileSinkList.contains(sink)){
//				sink.setSinkName("WENO:"+tileSinkList.size());
//				tileSinkList.add(sink);
//			}
//			if(sink.isSwitch){
//				for(int x=i-wirelessLevel;x<i+wirelessLevel+1;x++){
//					for(int z=j+wirelessLevel;z>j-wirelessLevel+1;z--){
//						for(int y=k-wirelessLevel;y<k+wirelessLevel+1;y++){
//							Block b=world.getBlock(x, z, y);
//							if(b.hasTileEntity()&&b!=this){
//								try {
//									IEnergySink t=(IEnergySink) world.getTileEntity(x, z, y);
//									if(t!=null)
//										sink.observerList.add(t);
//								} catch (Exception e) {
////									System.out.println("x:"+x+" y:"+y+" z:"+z+" "+b.getUnlocalizedName());
//								}
//							}
//						}
//					}
//				}
//				
//				if(sink.observerList.size()>0){
//					player.addChatMessage(new ChatComponentText("Search "+sink.observerList.size()+" devices,start inject !" ));
//					//start inject
//					sink.startInject(sink.observerList);
//				}
//				sink.isSwitch=false;
//			}else{
//				if(sink.observerList.size()>0){
//					player.addChatMessage(new ChatComponentText("Close devices !"));
//					sink.observerList.clear();
//				}
//				sink.startInject(sink.observerList);
//				sink.isSwitch=true;
//			}
		}
		return true;
	}
}
