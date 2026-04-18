package dev.piggle.obupackets.packet.clientbound.settings;

import dev.piggle.obupackets.packet.ClientboundSettingsPacket;
import dev.piggle.obupackets.packet.ObuPacket;
import net.minestom.server.network.NetworkBuffer;
import net.minestom.server.network.NetworkBufferTemplate;

/// [Docs link](https://openboatutils.github.io/developers/settings.html#set-underwater-control)
public record SettingsSetUnderwaterControl(boolean underwaterControl) implements ObuPacket<ClientboundSettingsPacket> {

    public static final NetworkBuffer.Type<SettingsSetUnderwaterControl> TEMPLATE = NetworkBufferTemplate.template(
            NetworkBuffer.BOOLEAN, SettingsSetUnderwaterControl::underwaterControl,
            SettingsSetUnderwaterControl::new
    );

    @Override
    public ClientboundSettingsPacket getPacketType() {
        return ClientboundSettingsPacket.SET_UNDERWATER_CONTROL;
    }
}
