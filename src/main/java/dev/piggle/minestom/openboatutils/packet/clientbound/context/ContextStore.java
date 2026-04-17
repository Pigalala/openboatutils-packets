package dev.piggle.minestom.openboatutils.packet.clientbound.context;

import dev.piggle.minestom.openboatutils.packet.ClientboundContextPacket;
import dev.piggle.minestom.openboatutils.packet.ObuPacket;
import dev.piggle.minestom.openboatutils.packet.clientbound.settings.SettingsTransaction;
import net.minestom.server.network.NetworkBuffer;
import net.minestom.server.network.NetworkBufferTemplate;

/// [Docs link](https://openboatutils.github.io/developers/context.html#store-context)
public record ContextStore(String namespacedKey, SettingsTransaction transaction) implements ObuPacket<ClientboundContextPacket> {

    public static final NetworkBuffer.Type<ContextStore> TEMPLATE = NetworkBufferTemplate.template(
            NetworkBuffer.STRING, ContextStore::namespacedKey,
            SettingsTransaction.TEMPLATE, ContextStore::transaction,
            ContextStore::new
    );

    @Override
    public ClientboundContextPacket getPacketType() {
        return ClientboundContextPacket.STORE_CONTEXT;
    }
}
