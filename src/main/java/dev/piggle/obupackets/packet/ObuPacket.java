package dev.piggle.obupackets.packet;

public interface ObuPacket<T extends PacketType> {

    T getPacketType();
}
