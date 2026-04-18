package dev.piggle.obupackets.packet.clientbound.settings;

import dev.piggle.obupackets.packet.ClientboundSettingsPacket;
import dev.piggle.obupackets.packet.ObuPacket;
import net.minestom.server.network.NetworkBuffer;
import net.minestom.server.network.NetworkBufferTemplate;

/// [Docs link](https://openboatutils.github.io/developers/settings.html#set-collision-resolution)
public record SettingsSetCollisionResolution(byte collisionResolution) implements ObuPacket<ClientboundSettingsPacket> {

    public SettingsSetCollisionResolution {
        if (collisionResolution > 50) {
            throw new IllegalArgumentException("Collision resolution cannot be greater than 50");
        }
    }

    public SettingsSetCollisionResolution(int resolution) {
        this((byte) resolution);
    }

    public static final NetworkBuffer.Type<SettingsSetCollisionResolution> TEMPLATE = NetworkBufferTemplate.template(
            NetworkBuffer.BYTE, SettingsSetCollisionResolution::collisionResolution,
            SettingsSetCollisionResolution::new
    );

    @Override
    public ClientboundSettingsPacket getPacketType() {
        return ClientboundSettingsPacket.SET_COLLISION_RESOLUTION;
    }
}
