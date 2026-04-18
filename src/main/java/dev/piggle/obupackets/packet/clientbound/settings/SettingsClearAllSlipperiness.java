package dev.piggle.obupackets.packet.clientbound.settings;

import dev.piggle.obupackets.packet.ClientboundSettingsPacket;
import dev.piggle.obupackets.packet.ObuPacket;
import net.minestom.server.network.NetworkBuffer;
import net.minestom.server.network.NetworkBufferTemplate;

/// [Docs link](https://openboatutils.github.io/developers/settings.html#clear-all-slipperiness)
public record SettingsClearAllSlipperiness() implements ObuPacket<ClientboundSettingsPacket> {

    public static final NetworkBuffer.Type<SettingsClearAllSlipperiness> TEMPLATE = NetworkBufferTemplate.template(new SettingsClearAllSlipperiness());

    @Override
    public ClientboundSettingsPacket getPacketType() {
        return ClientboundSettingsPacket.CLEAR_SLIPPERINESS;
    }
}
