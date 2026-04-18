package dev.piggle.obupackets.packet.clientbound.context;

import dev.piggle.obupackets.packet.ClientboundContextPacket;
import dev.piggle.obupackets.packet.ObuPacket;
import net.minestom.server.network.NetworkBuffer;
import net.minestom.server.network.NetworkBufferTemplate;

/// [Docs link](https://openboatutils.github.io/developers/context.html#reset-context)
public record ContextReset() implements ObuPacket<ClientboundContextPacket> {

    public static final NetworkBuffer.Type<ContextReset> TEMPLATE = NetworkBufferTemplate.template(new ContextReset());

    @Override
    public ClientboundContextPacket getPacketType() {
        return ClientboundContextPacket.RESET_CONTEXT;
    }
}
