package dev.piggle.obupackets.packet.clientbound.settings;

import dev.piggle.obupackets.packet.ClientboundSettingsPacket;
import dev.piggle.obupackets.packet.ObuPacket;
import net.minestom.server.network.NetworkBuffer;
import net.minestom.server.network.NetworkBufferTemplate;

/// [Docs link](https://openboatutils.github.io/developers/settings.html#set-default-slipperiness)
public record SettingsSetDefaultSlipperiness(float slipperiness) implements ObuPacket<ClientboundSettingsPacket> {

    public static final NetworkBuffer.Type<SettingsSetDefaultSlipperiness> TEMPLATE = NetworkBufferTemplate.template(
            NetworkBuffer.FLOAT, SettingsSetDefaultSlipperiness::slipperiness,
            SettingsSetDefaultSlipperiness::new
    );

    @Override
    public ClientboundSettingsPacket getPacketType() {
        return ClientboundSettingsPacket.SET_DEFAULT_SLIPPERINESS;
    }
}
