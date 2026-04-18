package dev.piggle.obupackets.packet.clientbound.settings;

import dev.piggle.obupackets.packet.ClientboundSettingsPacket;
import dev.piggle.obupackets.packet.ObuPacket;
import net.minestom.server.network.NetworkBuffer;
import net.minestom.server.network.NetworkBufferTemplate;

/// [Docs link](https://openboatutils.github.io/developers/settings.html#reset)
public record SettingsReset() implements ObuPacket<ClientboundSettingsPacket> {

    public static final NetworkBuffer.Type<SettingsReset> TEMPLATE = NetworkBufferTemplate.template(new SettingsReset());

    @Override
    public ClientboundSettingsPacket getPacketType() {
        return ClientboundSettingsPacket.RESET;
    }
}
