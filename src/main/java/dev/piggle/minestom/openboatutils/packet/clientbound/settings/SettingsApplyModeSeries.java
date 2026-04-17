package dev.piggle.minestom.openboatutils.packet.clientbound.settings;

import dev.piggle.minestom.openboatutils.BoatMode;
import dev.piggle.minestom.openboatutils.packet.ClientboundSettingsPacket;
import dev.piggle.minestom.openboatutils.packet.ObuPacket;
import net.minestom.server.network.NetworkBuffer;
import net.minestom.server.network.NetworkBufferTemplate;

import java.util.List;

/// [Docs link](https://openboatutils.github.io/developers/settings.html#apply-mode-series)
public record SettingsApplyModeSeries(List<BoatMode> modes) implements ObuPacket<ClientboundSettingsPacket> {

    public static final NetworkBuffer.Type<SettingsApplyModeSeries> TEMPLATE = NetworkBufferTemplate.template(
            BoatMode.BUFFER_TEMPLATE.list(), SettingsApplyModeSeries::modes,
            SettingsApplyModeSeries::new
    );

    @Override
    public ClientboundSettingsPacket getPacketType() {
        return ClientboundSettingsPacket.MODE_SERIES;
    }
}
