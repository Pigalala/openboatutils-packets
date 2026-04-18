package dev.piggle.obupackets.packet;

import dev.piggle.obupackets.OpenBoatUtils;
import dev.piggle.obupackets.packet.serverbound.configuration.ConfigurationVersion;
import net.minestom.server.network.NetworkBuffer;

public enum ServerboundConfigurationPacket implements PacketType {
    VERSION(ConfigurationVersion.TEMPLATE),
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
