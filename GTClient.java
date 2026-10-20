package com.gtclient;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientLifecycleEvents;
import net.minecraft.client.MinecraftClient;

/**
 * GT Client for Fabric 1.20.1.
 * Applies conservative settings that may improve performance on low-end devices.
 * This does not replace renderer optimization mods such as Sodium.
 */
public final class GTClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ClientLifecycleEvents.CLIENT_STARTED.register(client -> applySettings(client));
    }

    private static void applySettings(MinecraftClient client) {
        try {
            client.options.viewDistance.setValue(Math.min(client.options.viewDistance.getValue(), 8));
            client.options.simulationDistance.setValue(Math.min(client.options.simulationDistance.getValue(), 5));
            client.options.particles.setValue(net.minecraft.client.option.ParticlesMode.MINIMAL);
            client.options.entityDistanceScaling.setValue(Math.min(client.options.entityDistanceScaling.getValue(), 0.75));
        } catch (Throwable ignored) {
            // Avoid crashing the game if a setting is unavailable in a customized client.
        }
    }
}
