package dev.piggle.obupackets.packet.clientbound.settings;

import dev.piggle.obupackets.packet.ClientboundSettingsPacket;
import dev.piggle.obupackets.packet.ObuPacket;
import dev.piggle.obupackets.packet.clientbound.ClientboundPacketRegistry;
import net.minestom.server.network.NetworkBuffer;
import net.minestom.server.network.NetworkBufferTemplate;

import java.util.List;

/// [Docs link](https://openboatutils.github.io/developers/settings.html#transaction)
public record SettingsTransaction(int count, List<ObuPacket<ClientboundSettingsPacket>> packets) implements ObuPacket<ClientboundSettingsPacket> {

    public static final NetworkBuffer.Type<SettingsTransaction> TEMPLATE = NetworkBufferTemplate.template(
            NetworkBuffer.INT, SettingsTransaction::count,
            NetworkBuffer.RAW_BYTES, SettingsTransaction::asBytes,
            (_, _) -> null // Hopefully we didn't need this
    );

    public SettingsTransaction(List<ObuPacket<ClientboundSettingsPacket>> packets) {
        this(packets.size(), packets);
    }

    @SuppressWarnings("unchecked")
    public byte[] asBytes() {
        NetworkBuffer buffer = NetworkBuffer.resizableBuffer(256);
        for (ObuPacket<ClientboundSettingsPacket> packet : packets) {
            buffer.write(NetworkBuffer.SHORT, (short) packet.getPacketType().getPacketId());
            var bufferType = (NetworkBuffer.Type<ObuPacket<ClientboundSettingsPacket>>) ClientboundPacketRegistry.get(packet.getClass());
            buffer.write(bufferType, packet);
        }

        byte[] bytes = buffer.read(NetworkBuffer.FixedRawBytes((int) buffer.readableBytes()));
        buffer.clear();
        return bytes;
    }

    @Override
    public ClientboundSettingsPacket getPacketType() {
        return ClientboundSettingsPacket.TRANSACTION;
    }
}
