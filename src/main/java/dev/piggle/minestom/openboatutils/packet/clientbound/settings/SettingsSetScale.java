package dev.piggle.minestom.openboatutils.packet.clientbound.settings;

import dev.piggle.minestom.openboatutils.packet.ClientboundSettingsPacket;
import dev.piggle.minestom.openboatutils.packet.ObuPacket;
import net.minestom.server.network.NetworkBuffer;
import net.minestom.server.network.NetworkBufferTemplate;

/// [Docs link](https://openboatutils.github.io/developers/settings.html#set-scale)
public record SettingsSetScale(float scale) implements ObuPacket<ClientboundSettingsPacket> {

    public static final NetworkBuffer.Type<SettingsSetScale> TEMPLATE = NetworkBufferTemplate.template(
            NetworkBuffer.FLOAT, SettingsSetScale::scale,
            SettingsSetScale::new
    );

    @Override
    public ClientboundSettingsPacket getPacketType() {
        return ClientboundSettingsPacket.SET_SCALE;
    }
}
