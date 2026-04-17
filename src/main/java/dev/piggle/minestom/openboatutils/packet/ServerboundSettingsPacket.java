package dev.piggle.minestom.openboatutils.packet;

import dev.piggle.minestom.openboatutils.OpenBoatUtils;
import dev.piggle.minestom.openboatutils.packet.serverbound.settings.SettingsVersionPacket;
import net.minestom.server.network.NetworkBuffer;

public enum ServerboundSettingsPacket implements PacketType {
    VERSION(SettingsVersionPacket.TEMPLATE),
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
