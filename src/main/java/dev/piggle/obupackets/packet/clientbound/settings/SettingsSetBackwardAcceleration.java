package dev.piggle.obupackets.packet.clientbound.settings;

import dev.piggle.obupackets.packet.ClientboundSettingsPacket;
import dev.piggle.obupackets.packet.ObuPacket;
import net.minestom.server.network.NetworkBuffer;
import net.minestom.server.network.NetworkBufferTemplate;

/// [Docs link](https://openboatutils.github.io/developers/settings.html#set-backward-acceleration)
public record SettingsSetBackwardAcceleration(float backwardAcceleration) implements ObuPacket<ClientboundSettingsPacket> {

    public static final NetworkBuffer.Type<SettingsSetBackwardAcceleration> TEMPLATE = NetworkBufferTemplate.template(
            NetworkBuffer.FLOAT, SettingsSetBackwardAcceleration::backwardAcceleration,
            SettingsSetBackwardAcceleration::new
    );

    @Override
    public ClientboundSettingsPacket getPacketType() {
        return ClientboundSettingsPacket.SET_BACKWARD_ACCEL;
    }
}
