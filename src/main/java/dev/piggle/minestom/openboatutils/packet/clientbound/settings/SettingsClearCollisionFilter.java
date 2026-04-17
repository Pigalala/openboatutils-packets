package dev.piggle.minestom.openboatutils.packet.clientbound.settings;

import dev.piggle.minestom.openboatutils.packet.ClientboundSettingsPacket;
import dev.piggle.minestom.openboatutils.packet.ObuPacket;
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
