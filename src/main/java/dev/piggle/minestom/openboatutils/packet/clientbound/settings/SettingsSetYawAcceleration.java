package dev.piggle.minestom.openboatutils.packet.clientbound.settings;

import dev.piggle.minestom.openboatutils.packet.ClientboundSettingsPacket;
import dev.piggle.minestom.openboatutils.packet.ObuPacket;
import net.minestom.server.network.NetworkBuffer;
import net.minestom.server.network.NetworkBufferTemplate;

/// [Docs link](https://openboatutils.github.io/developers/settings.html#set-yaw-acceleration)
public record SettingsSetYawAcceleration(float yawAcceleration) implements ObuPacket<ClientboundSettingsPacket> {

    public static final NetworkBuffer.Type<SettingsSetYawAcceleration> TEMPLATE = NetworkBufferTemplate.template(
            NetworkBuffer.FLOAT, SettingsSetYawAcceleration::yawAcceleration,
            SettingsSetYawAcceleration::new
    );

    @Override
    public ClientboundSettingsPacket getPacketType() {
        return ClientboundSettingsPacket.SET_YAW_ACCEL;
    }
}
