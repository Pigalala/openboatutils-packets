package dev.piggle.obupackets.packet;

import dev.piggle.obupackets.OpenBoatUtils;

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
