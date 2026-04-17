package dev.piggle.minestom.openboatutils.packet.clientbound;

import dev.piggle.minestom.openboatutils.packet.ObuPacket;
import dev.piggle.minestom.openboatutils.packet.clientbound.context.*;
import dev.piggle.minestom.openboatutils.packet.clientbound.settings.*;
import net.minestom.server.network.NetworkBuffer;

import java.util.HashMap;
import java.util.Map;

public final class ClientboundPacketRegistry {

    private static final Map<Class<?>, NetworkBuffer.Type<?>> packetTemplates = new HashMap<>();

    private static <T extends ObuPacket<?>> void register(Class<T> packetClass, NetworkBuffer.Type<T> serializer) {
        packetTemplates.put(packetClass, serializer);
    }

    @SuppressWarnings("unchecked")
    public static <T extends ObuPacket<?>> NetworkBuffer.Type<T> get(Class<T> packetClass) {
        var template = (NetworkBuffer.Type<T>) packetTemplates.get(packetClass);
        if (template == null) {
            throw new IllegalArgumentException(packetClass.getName() + " is not registered in ClientboundPacketRegistry!");
        }

        return template;
    }

    public static void init() {
        register(SettingsReset.class, SettingsReset.TEMPLATE);
        register(SettingsSetStepHeight.class, SettingsSetStepHeight.TEMPLATE);
        register(SettingsSetDefaultSlipperiness.class, SettingsSetDefaultSlipperiness.TEMPLATE);
        register(SettingsSetBlocksSlipperiness.class, SettingsSetBlocksSlipperiness.TEMPLATE);
        register(SettingsSetBoatFallDamage.class, SettingsSetBoatFallDamage.TEMPLATE);
        register(SettingsSetBoatWaterElevation.class, SettingsSetBoatWaterElevation.TEMPLATE);
        register(SettingsSetBoatAirControl.class, SettingsSetBoatAirControl.TEMPLATE);
        register(SettingsSetBoatJumpForce.class, SettingsSetBoatJumpForce.TEMPLATE);
        register(SettingsSetMode.class, SettingsSetMode.TEMPLATE);
        register(SettingsSetGravity.class, SettingsSetGravity.TEMPLATE);
        register(SettingsSetYawAcceleration.class, SettingsSetYawAcceleration.TEMPLATE);
        register(SettingsSetForwardAcceleration.class, SettingsSetForwardAcceleration.TEMPLATE);
        register(SettingsSetBackwardAcceleration.class, SettingsSetBackwardAcceleration.TEMPLATE);
        register(SettingsSetTurningForwardAcceleration.class, SettingsSetTurningForwardAcceleration.TEMPLATE);
        register(SettingsAllowAccelerationStacking.class, SettingsAllowAccelerationStacking.TEMPLATE);
        register(SettingsResendVersion.class, SettingsResendVersion.TEMPLATE);
        register(SettingsSetUnderwaterControl.class, SettingsSetUnderwaterControl.TEMPLATE);
        register(SettingsSetSurfaceWaterControl.class, SettingsSetSurfaceWaterControl.TEMPLATE);
        register(SettingsSetExclusiveMode.class, SettingsSetExclusiveMode.TEMPLATE);
        register(SettingsSetCoyoteTime.class, SettingsSetCoyoteTime.TEMPLATE);
        register(SettingsSetWaterJumping.class, SettingsSetWaterJumping.TEMPLATE);
        register(SettingsSetSwimForce.class, SettingsSetSwimForce.TEMPLATE);
        register(SettingsClearBlocksSlipperiness.class, SettingsClearBlocksSlipperiness.TEMPLATE);
        register(SettingsClearAllSlipperiness.class, SettingsClearAllSlipperiness.TEMPLATE);
        register(SettingsApplyModeSeries.class, SettingsApplyModeSeries.TEMPLATE);
        register(SettingsApplyExclusiveModeSeries.class, SettingsApplyExclusiveModeSeries.TEMPLATE);
        register(SettingsSetPerBlockSetting.class, SettingsSetPerBlockSetting.TEMPLATE);
        register(SettingsSetCollisionMode.class, SettingsSetCollisionMode.TEMPLATE);
        register(SettingsSetAirStepping.class, SettingsSetAirStepping.TEMPLATE);
        register(SettingsSetTenStepInterpolation.class, SettingsSetTenStepInterpolation.TEMPLATE);
        register(SettingsSetCollisionResolution.class, SettingsSetCollisionResolution.TEMPLATE);
        register(SettingsAddToCollisionFilter.class, SettingsAddToCollisionFilter.TEMPLATE);
        register(SettingsClearCollisionFilter.class, SettingsClearCollisionFilter.TEMPLATE);
        register(SettingsTransaction.class, SettingsTransaction.TEMPLATE);
        register(SettingsSetWalltapMultiplier.class, SettingsSetWalltapMultiplier.TEMPLATE);
        register(SettingsSetJumps.class, SettingsSetJumps.TEMPLATE);
        register(SettingsSetScale.class, SettingsSetScale.TEMPLATE);
        register(SettingsSetStepUpSlipperiness.class, SettingsSetStepUpSlipperiness.TEMPLATE);

        register(ContextReset.class, ContextReset.TEMPLATE);
        register(ContextSwitch.class, ContextSwitch.TEMPLATE);
        register(ContextDrop.class, ContextDrop.TEMPLATE);
        register(ContextStore.class, ContextStore.TEMPLATE);
        register(ContextEntity.class, ContextEntity.TEMPLATE);
    }
}
