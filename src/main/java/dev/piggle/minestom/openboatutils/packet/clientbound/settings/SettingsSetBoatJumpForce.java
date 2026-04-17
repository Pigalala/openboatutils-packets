package dev.piggle.minestom.openboatutils.packet.clientbound.settings;

import dev.piggle.minestom.openboatutils.packet.ClientboundSettingsPacket;
import dev.piggle.minestom.openboatutils.packet.ObuPacket;
import net.minestom.server.network.NetworkBuffer;
import net.minestom.server.network.NetworkBufferTemplate;

/// [Docs link](https://openboatutils.github.io/developers/settings.html#set-boat-jump-force)
public record SettingsSetBoatJumpForce(float jumpForce) implements ObuPacket<ClientboundSettingsPacket> {

    public static final NetworkBuffer.Type<SettingsSetBoatJumpForce> TEMPLATE = NetworkBufferTemplate.template(
            NetworkBuffer.FLOAT, SettingsSetBoatJumpForce::jumpForce,
            SettingsSetBoatJumpForce::new
    );

    @Override
    public ClientboundSettingsPacket getPacketType() {
        return ClientboundSettingsPacket.SET_BOAT_JUMP_FORCE;
    }
}
