package dev.piggle.obupackets.packet.clientbound.settings;

import dev.piggle.obupackets.BoatMode;
import dev.piggle.obupackets.packet.ClientboundSettingsPacket;
import dev.piggle.obupackets.packet.ObuPacket;
import net.minestom.server.network.NetworkBuffer;
import net.minestom.server.network.NetworkBufferTemplate;

/// [Docs link](https://openboatutils.github.io/developers/settings.html#set-exclusive-mode)
public record SettingsSetExclusiveMode(BoatMode mode) implements ObuPacket<ClientboundSettingsPacket> {

    public static final NetworkBuffer.Type<SettingsSetExclusiveMode> TEMPLATE = NetworkBufferTemplate.template(
            BoatMode.BUFFER_TEMPLATE, SettingsSetExclusiveMode::mode,
            SettingsSetExclusiveMode::new
    );

    @Override
    public ClientboundSettingsPacket getPacketType() {
        return ClientboundSettingsPacket.SET_EXCLUSIVE_MODE;
    }
}
