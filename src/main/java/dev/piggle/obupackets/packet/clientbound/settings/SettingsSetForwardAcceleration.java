package dev.piggle.obupackets.packet.clientbound.settings;

import dev.piggle.obupackets.packet.ClientboundSettingsPacket;
import dev.piggle.obupackets.packet.ObuPacket;
import net.minestom.server.network.NetworkBuffer;
import net.minestom.server.network.NetworkBufferTemplate;

/// [Docs link](https://openboatutils.github.io/developers/settings.html#set-forward-acceleration)
public record SettingsSetForwardAcceleration(float forwardAcceleration) implements ObuPacket<ClientboundSettingsPacket> {

    public static final NetworkBuffer.Type<SettingsSetForwardAcceleration> TEMPLATE = NetworkBufferTemplate.template(
            NetworkBuffer.FLOAT, SettingsSetForwardAcceleration::forwardAcceleration,
            SettingsSetForwardAcceleration::new
    );

    @Override
    public ClientboundSettingsPacket getPacketType() {
        return ClientboundSettingsPacket.SET_FORWARD_ACCEL;
    }
}
