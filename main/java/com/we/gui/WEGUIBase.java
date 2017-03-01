package com.we.gui;

import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;

public class WEGUIBase extends GuiScreen{
	
	private ResourceLocation texture = new ResourceLocation("wirelesselectricity", "textures/gui/guiWELowBlock.png");
//	private GuiScreen screen=new GuiScreen();
	public WEGUIBase(GuiScreen screen){
		
	}
	
	@Override
	public void drawScreen(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
		mc.renderEngine.bindTexture(texture); //绑定纹理
		drawTexturedModalRect((int)(width*0.5)-128, 0,0,0,256,256);
		super.drawScreen(p_73863_1_, p_73863_2_, p_73863_3_);
	}
	@Override
	public void initGui() {
		FMLCommonHandler.instance().bus().register(this);
		super.initGui();
	}
	
	@Override
	public boolean doesGuiPauseGame() {
	    return false;
	}
	
}
