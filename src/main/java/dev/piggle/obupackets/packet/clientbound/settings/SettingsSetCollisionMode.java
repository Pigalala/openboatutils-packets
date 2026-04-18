package dev.piggle.obupackets.packet.clientbound.settings;

import dev.piggle.obupackets.CollisionMode;
import dev.piggle.obupackets.packet.ClientboundSettingsPacket;
import dev.piggle.obupackets.packet.ObuPacket;
import net.minestom.server.network.NetworkBuffer;
import net.minestom.server.network.NetworkBufferTemplate;

/// [Docs link](https://openboatutils.github.io/developers/settings.html#set-collision-mode)
public record SettingsSetCollisionMode(CollisionMode collisionMode) implements ObuPacket<ClientboundSettingsPacket> {

    public static final NetworkBuffer.Type<SettingsSetCollisionMode> TEMPLATE = NetworkBufferTemplate.template(
            CollisionMode.NETWORK_TEMPLATE, SettingsSetCollisionMode::collisionMode,
            SettingsSetCollisionMode::new
    );

    @Override
    public ClientboundSettingsPacket getPacketType() {
        return ClientboundSettingsPacket.SET_COLLISION_MODE;
    }
}
