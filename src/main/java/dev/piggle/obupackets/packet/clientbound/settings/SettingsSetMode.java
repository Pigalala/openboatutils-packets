package dev.piggle.obupackets.packet.clientbound.settings;

import dev.piggle.obupackets.BoatMode;
import dev.piggle.obupackets.packet.ClientboundSettingsPacket;
import dev.piggle.obupackets.packet.ObuPacket;
import net.minestom.server.network.NetworkBuffer;
import net.minestom.server.network.NetworkBufferTemplate;

/// [Docs link](https://openboatutils.github.io/developers/settings.html#set-mode)
public record SettingsSetMode(BoatMode mode) implements ObuPacket<ClientboundSettingsPacket> {

    public static final NetworkBuffer.Type<SettingsSetMode> TEMPLATE = NetworkBufferTemplate.template(
            BoatMode.BUFFER_TEMPLATE, SettingsSetMode::mode,
            SettingsSetMode::new
    );

    @Override
    public ClientboundSettingsPacket getPacketType() {
        return ClientboundSettingsPacket.SET_MODE;
    }
}
