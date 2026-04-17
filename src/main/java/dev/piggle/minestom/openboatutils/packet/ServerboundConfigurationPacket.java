package dev.piggle.minestom.openboatutils.packet;

import dev.piggle.minestom.openboatutils.OpenBoatUtils;
import dev.piggle.minestom.openboatutils.packet.serverbound.configuration.ConfigurationVersionPacket;
import net.minestom.server.network.NetworkBuffer;

public enum ServerboundConfigurationPacket implements PacketType {
    VERSION(ConfigurationVersionPacket.TEMPLATE),
    ;

    private final NetworkBuffer.Type<?> bufferType;

    ServerboundConfigurationPacket(NetworkBuffer.Type<?> bufferType) {
        this.bufferType = bufferType;
    }

    public static ObuPacket<?> read(int packetId, NetworkBuffer buffer) {
        ServerboundConfigurationPacket packet = values()[packetId];
        return (ObuPacket<?>) packet.bufferType.read(buffer);
    }

    @Override
    public int getPacketId() {
        return ordinal();
    }

    @Override
    public String getChannel() {
        return OpenBoatUtils.CHANNEL_CONFIGURATION;
    }
}
