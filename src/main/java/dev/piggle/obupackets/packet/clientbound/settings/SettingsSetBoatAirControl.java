package dev.piggle.obupackets.packet.clientbound.settings;

import dev.piggle.obupackets.packet.ClientboundSettingsPacket;
import dev.piggle.obupackets.packet.ObuPacket;
import net.minestom.server.network.NetworkBuffer;
import net.minestom.server.network.NetworkBufferTemplate;

/// [Docs link](https://openboatutils.github.io/developers/settings.html#set-boat-air-control)
public record SettingsSetBoatAirControl(boolean airControl) implements ObuPacket<ClientboundSettingsPacket> {

    public static final NetworkBuffer.Type<SettingsSetBoatAirControl> TEMPLATE = NetworkBufferTemplate.template(
            NetworkBuffer.BOOLEAN, SettingsSetBoatAirControl::airControl,
            SettingsSetBoatAirControl::new
    );

    @Override
    public ClientboundSettingsPacket getPacketType() {
        return ClientboundSettingsPacket.SET_AIR_CONTROL;
    }
}
