package dev.piggle.obupackets.packet.clientbound.context;

import dev.piggle.obupackets.packet.ClientboundContextPacket;
import dev.piggle.obupackets.packet.ObuPacket;
import dev.piggle.obupackets.packet.clientbound.settings.SettingsTransaction;
import net.minestom.server.network.NetworkBuffer;
import net.minestom.server.network.NetworkBufferTemplate;

import java.util.UUID;

/// [Docs link](https://openboatutils.github.io/developers/context.html#entity-context)
public record ContextEntity(UUID entityUuid, SettingsTransaction transaction) implements ObuPacket<ClientboundContextPacket> {

    public static final NetworkBuffer.Type<ContextEntity> TEMPLATE = NetworkBufferTemplate.template(
            NetworkBuffer.UUID, ContextEntity::entityUuid,
            SettingsTransaction.TEMPLATE, ContextEntity::transaction,
            ContextEntity::new
    );

    @Override
    public ClientboundContextPacket getPacketType() {
        return ClientboundContextPacket.STORE_CONTEXT;
    }
}
