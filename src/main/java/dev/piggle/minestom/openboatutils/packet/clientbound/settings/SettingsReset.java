package dev.piggle.minestom.openboatutils.packet.clientbound.settings;

import dev.piggle.minestom.openboatutils.packet.ClientboundSettingsPacket;
import dev.piggle.minestom.openboatutils.packet.ObuPacket;
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
