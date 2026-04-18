package dev.piggle.obupackets.packet.clientbound.context;

import dev.piggle.obupackets.packet.ClientboundContextPacket;
import dev.piggle.obupackets.packet.ObuPacket;
import net.minestom.server.network.NetworkBuffer;
import net.minestom.server.network.NetworkBufferTemplate;

/// [Docs link](https://openboatutils.github.io/developers/context.html#switch-context)
public record ContextDrop(String namespacedKey) implements ObuPacket<ClientboundContextPacket> {

    public static final NetworkBuffer.Type<ContextDrop> TEMPLATE = NetworkBufferTemplate.template(
            NetworkBuffer.STRING, ContextDrop::namespacedKey,
            ContextDrop::new
    );

    @Override
    public ClientboundContextPacket getPacketType() {
        return ClientboundContextPacket.DROP_CONTEXT;
    }
}
