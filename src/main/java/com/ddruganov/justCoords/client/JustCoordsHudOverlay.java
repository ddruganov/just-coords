package com.ddruganov.justCoords.client;

import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.util.math.MatrixStack;

public class JustCoordsHudOverlay implements HudRenderCallback {

    private final static int BACKDROP_COLOR = 0x80000000;
    private final static int TEXT_COLOR = 0xffffffff;
    private final static int PADDING = 2;
    private final static int HALF_PADDING = PADDING / 2;

    private static String getCoordsString(ClientPlayerEntity player) {
        var playerX = (int) player.getX();
        var playerY = (int) player.getY();
        var playerZ = (int) player.getZ();
        return playerX + " " + playerY + " " + playerZ;
    }

    @Override
    public void onHudRender(MatrixStack matrixStack, float tickDelta) {

        var client = MinecraftClient.getInstance();

        var player = client.player;
        if (player == null) {
            return;
        }

        var coordsString = getCoordsString(player);

        var renderer = client.textRenderer;
        int rectWidth = renderer.getWidth(coordsString) + PADDING;
        int rectHeight = renderer.fontHeight - 2 + PADDING; // subtract 2 to fit the font perfectly into the rect

        DrawableHelper.fill(matrixStack, 0, 0, rectWidth, rectHeight, BACKDROP_COLOR);
        renderer.draw(matrixStack, coordsString, HALF_PADDING, HALF_PADDING, TEXT_COLOR);
    }
}
