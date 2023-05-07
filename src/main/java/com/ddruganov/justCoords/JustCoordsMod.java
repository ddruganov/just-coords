package com.ddruganov.justCoords;

import com.ddruganov.justCoords.client.JustCoordsHudOverlay;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;

public final class JustCoordsMod implements ModInitializer {
    @Override
    public void onInitialize() {
        HudRenderCallback.EVENT.register(new JustCoordsHudOverlay());
    }
}