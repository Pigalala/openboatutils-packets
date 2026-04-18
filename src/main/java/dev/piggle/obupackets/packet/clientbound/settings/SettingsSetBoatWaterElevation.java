package dev.piggle.obupackets.packet.clientbound.settings;

import dev.piggle.obupackets.packet.ClientboundSettingsPacket;
import dev.piggle.obupackets.packet.ObuPacket;
import net.minestom.server.network.NetworkBuffer;
import net.minestom.server.network.NetworkBufferTemplate;

/// [Docs link](https://openboatutils.github.io/developers/settings.html#set-boat-water-elevation)
public record SettingsSetBoatWaterElevation(boolean waterElevation) implements ObuPacket<ClientboundSettingsPacket> {

    public static final NetworkBuffer.Type<SettingsSetBoatWaterElevation> TEMPLATE = NetworkBufferTemplate.template(
            NetworkBuffer.BOOLEAN, SettingsSetBoatWaterElevation::waterElevation,
            SettingsSetBoatWaterElevation::new
    );

    @Override
    public ClientboundSettingsPacket getPacketType() {
        return ClientboundSettingsPacket.SET_BOAT_WATER_ELEVATION;
    }
}
