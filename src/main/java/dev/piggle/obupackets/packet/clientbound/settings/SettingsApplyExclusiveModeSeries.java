package dev.piggle.obupackets.packet.clientbound.settings;

import dev.piggle.obupackets.BoatMode;
import dev.piggle.obupackets.packet.ClientboundSettingsPacket;
import dev.piggle.obupackets.packet.ObuPacket;
import net.minestom.server.network.NetworkBuffer;
import net.minestom.server.network.NetworkBufferTemplate;

import java.util.List;

/// [Docs link](https://openboatutils.github.io/developers/settings.html#apply-exclusive-mode-series)
public record SettingsApplyExclusiveModeSeries(List<BoatMode> modes) implements ObuPacket<ClientboundSettingsPacket> {

    public static final NetworkBuffer.Type<SettingsApplyExclusiveModeSeries> TEMPLATE = NetworkBufferTemplate.template(
            BoatMode.BUFFER_TEMPLATE.list(), SettingsApplyExclusiveModeSeries::modes,
            SettingsApplyExclusiveModeSeries::new
    );

    @Override
    public ClientboundSettingsPacket getPacketType() {
        return ClientboundSettingsPacket.EXCLUSIVE_MODE_SERIES;
    }
}
