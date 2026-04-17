package dev.piggle.minestom.openboatutils.packet.clientbound.context;

import dev.piggle.minestom.openboatutils.packet.ClientboundContextPacket;
import dev.piggle.minestom.openboatutils.packet.ObuPacket;
import net.minestom.server.network.NetworkBuffer;
import net.minestom.server.network.NetworkBufferTemplate;

/// [Docs link](https://openboatutils.github.io/developers/context.html#switch-context)
public record ContextSwitch(String namespacedKey) implements ObuPacket<ClientboundContextPacket> {

    public static final NetworkBuffer.Type<ContextSwitch> TEMPLATE = NetworkBufferTemplate.template(
            NetworkBuffer.STRING, ContextSwitch::namespacedKey,
            ContextSwitch::new
    );

    @Override
    public ClientboundContextPacket getPacketType() {
        return ClientboundContextPacket.SWITCH_CONTEXT;
    }
}
