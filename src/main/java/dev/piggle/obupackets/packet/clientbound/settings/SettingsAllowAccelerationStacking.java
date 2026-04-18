package dev.piggle.obupackets.packet.clientbound.settings;

import dev.piggle.obupackets.packet.ClientboundSettingsPacket;
import dev.piggle.obupackets.packet.ObuPacket;
import net.minestom.server.network.NetworkBuffer;
import net.minestom.server.network.NetworkBufferTemplate;

/// [Docs link](https://openboatutils.github.io/developers/settings.html#allow-acceleration-stacking)
public record SettingsAllowAccelerationStacking(boolean allowAccelerationStacking) implements ObuPacket<ClientboundSettingsPacket> {

    public static final NetworkBuffer.Type<SettingsAllowAccelerationStacking> TEMPLATE = NetworkBufferTemplate.template(
            NetworkBuffer.BOOLEAN, SettingsAllowAccelerationStacking::allowAccelerationStacking,
            SettingsAllowAccelerationStacking::new
    );

    @Override
    public ClientboundSettingsPacket getPacketType() {
        return ClientboundSettingsPacket.ALLOW_ACCEL_STACKING;
    }
}
