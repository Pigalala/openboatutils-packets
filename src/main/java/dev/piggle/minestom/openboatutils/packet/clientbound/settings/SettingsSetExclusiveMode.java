package dev.piggle.minestom.openboatutils.packet.clientbound.settings;

import dev.piggle.minestom.openboatutils.BoatMode;
import dev.piggle.minestom.openboatutils.packet.ClientboundSettingsPacket;
import dev.piggle.minestom.openboatutils.packet.ObuPacket;
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
