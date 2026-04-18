package dev.piggle.obupackets.packet.clientbound.settings;

import dev.piggle.obupackets.packet.ClientboundSettingsPacket;
import dev.piggle.obupackets.packet.ObuPacket;
import net.minestom.server.network.NetworkBuffer;
import net.minestom.server.network.NetworkBufferTemplate;

/// [Docs link](https://openboatutils.github.io/developers/settings.html#set-coyote-time)
public record SettingsSetCoyoteTime(int coyoteTime) implements ObuPacket<ClientboundSettingsPacket> {

    public static final NetworkBuffer.Type<SettingsSetCoyoteTime> TEMPLATE = NetworkBufferTemplate.template(
            NetworkBuffer.INT, SettingsSetCoyoteTime::coyoteTime,
            SettingsSetCoyoteTime::new
    );

    @Override
    public ClientboundSettingsPacket getPacketType() {
        return ClientboundSettingsPacket.SET_COYOTE_TIME;
    }
}
