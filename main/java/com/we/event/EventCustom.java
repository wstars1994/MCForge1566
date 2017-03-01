
package com.we.event;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;

public class EventCustom {

	@SubscribeEvent
    public void pickupItem(EntityItemPickupEvent event) {
//        System.out.println("Item picked up!");
    }
}
