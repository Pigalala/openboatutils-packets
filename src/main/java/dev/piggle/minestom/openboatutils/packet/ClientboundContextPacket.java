package dev.piggle.minestom.openboatutils.packet;

import dev.piggle.minestom.openboatutils.OpenBoatUtils;

public enum ClientboundContextPacket implements PacketType {
    RESET_CONTEXT,
    SWITCH_CONTEXT,
    DROP_CONTEXT,
    STORE_CONTEXT,
    ENTITY_CONTEXT,
    ;

    @Override
    public int getPacketId() {
        return ordinal();
    }

    @Override
    public String getChannel() {
        return OpenBoatUtils.CHANNEL_CONTEXT;
    }
}
