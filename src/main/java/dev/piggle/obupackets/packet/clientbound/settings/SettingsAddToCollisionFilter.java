package dev.piggle.obupackets.packet.clientbound.settings;

import dev.piggle.obupackets.packet.ClientboundSettingsPacket;
import dev.piggle.obupackets.packet.ObuPacket;
import net.minestom.server.entity.EntityType;
import net.minestom.server.network.NetworkBuffer;
import net.minestom.server.network.NetworkBufferTemplate;
import net.minestom.server.registry.StaticProtocolObject;

import java.util.Collection;
import java.util.stream.Collectors;

/// [Docs link](https://openboatutils.github.io/developers/settings.html#add-to-collision-filter)
public record SettingsAddToCollisionFilter(String entityTypes) implements ObuPacket<ClientboundSettingsPacket> {

    public SettingsAddToCollisionFilter(Collection<EntityType> entityTypes) {
        this(entityTypes.stream().map(StaticProtocolObject::name).collect(Collectors.joining(",")));
    }

    public static final NetworkBuffer.Type<SettingsAddToCollisionFilter> TEMPLATE = NetworkBufferTemplate.template(
            NetworkBuffer.STRING, SettingsAddToCollisionFilter::entityTypes,
            SettingsAddToCollisionFilter::new
    );

    @Override
    public ClientboundSettingsPacket getPacketType() {
        return ClientboundSettingsPacket.ADD_COLLISION_ENTITYTYPE_FILTER;
    }
}
