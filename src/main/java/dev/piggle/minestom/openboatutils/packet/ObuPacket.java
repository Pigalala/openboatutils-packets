package dev.piggle.minestom.openboatutils.packet;

public interface ObuPacket<T extends PacketType> {

    T getPacketType();
}
