package dev.piggle.obupackets.packet.clientbound.settings;

import dev.piggle.obupackets.packet.ClientboundSettingsPacket;
import dev.piggle.obupackets.packet.ObuPacket;
import net.minestom.server.network.NetworkBuffer;
import net.minestom.server.network.NetworkBufferTemplate;

/// [Docs link](https://openboatutils.github.io/developers/settings.html#set-swim-force)
public record SettingsSetSwimForce(float swimForce) implements ObuPacket<ClientboundSettingsPacket> {

    public static final NetworkBuffer.Type<SettingsSetSwimForce> TEMPLATE = NetworkBufferTemplate.template(
            NetworkBuffer.FLOAT, SettingsSetSwimForce::swimForce,
            SettingsSetSwimForce::new
    );

    @Override
    public ClientboundSettingsPacket getPacketType() {
        return ClientboundSettingsPacket.SET_SWIM_FORCE;
    }
}
