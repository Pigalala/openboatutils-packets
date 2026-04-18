package dev.piggle.obupackets.packet.clientbound.settings;

import dev.piggle.obupackets.packet.ClientboundSettingsPacket;
import dev.piggle.obupackets.packet.ObuPacket;
import net.minestom.server.network.NetworkBuffer;
import net.minestom.server.network.NetworkBufferTemplate;

/// [Docs link](https://openboatutils.github.io/developers/settings.html#clear-collision-filter)
public record SettingsClearCollisionFilter() implements ObuPacket<ClientboundSettingsPacket> {

    public static final NetworkBuffer.Type<SettingsClearCollisionFilter> TEMPLATE = NetworkBufferTemplate.template(new SettingsClearCollisionFilter());

    @Override
    public ClientboundSettingsPacket getPacketType() {
        return ClientboundSettingsPacket.CLEAR_COLLISION_ENTITYTYPE_FILTER;
    }
}
