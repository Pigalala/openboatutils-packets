package dev.piggle.obupackets.packet.clientbound.settings;

import dev.piggle.obupackets.packet.ClientboundSettingsPacket;
import dev.piggle.obupackets.packet.ObuPacket;
import net.minestom.server.network.NetworkBuffer;
import net.minestom.server.network.NetworkBufferTemplate;

/// [Docs link](https://openboatutils.github.io/developers/settings.html#set-air-stepping)
public record SettingsSetAirStepping(boolean airStepping) implements ObuPacket<ClientboundSettingsPacket> {

    public static final NetworkBuffer.Type<SettingsSetAirStepping> TEMPLATE = NetworkBufferTemplate.template(
            NetworkBuffer.BOOLEAN, SettingsSetAirStepping::airStepping,
            SettingsSetAirStepping::new
    );

    @Override
    public ClientboundSettingsPacket getPacketType() {
        return ClientboundSettingsPacket.SET_STEP_WHILE_FALLING;
    }
}
