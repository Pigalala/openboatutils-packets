package dev.piggle.minestom.openboatutils.packet.clientbound.settings;

import dev.piggle.minestom.openboatutils.packet.ClientboundSettingsPacket;
import dev.piggle.minestom.openboatutils.packet.ObuPacket;
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
