package dev.piggle.obupackets.packet;

import dev.piggle.obupackets.OpenBoatUtils;
import dev.piggle.obupackets.packet.serverbound.settings.SettingsVersion;
import net.minestom.server.network.NetworkBuffer;

public enum ServerboundSettingsPacket implements PacketType {
    VERSION(SettingsVersion.TEMPLATE),
    ;

    private final NetworkBuffer.Type<?> bufferType;

    ServerboundSettingsPacket(NetworkBuffer.Type<?> bufferType) {
        this.bufferType = bufferType;
    }

    public static ObuPacket<?> read(int packetId, NetworkBuffer buffer) {
        ServerboundSettingsPacket packet = values()[packetId];
        return (ObuPacket<?>) packet.bufferType.read(buffer);
    }

    @Override
    public int getPacketId() {
        return ordinal();
    }

    @Override
    public String getChannel() {
        return OpenBoatUtils.CHANNEL_SETTINGS;
    }
}
