package dev.piggle.minestom.openboatutils;

import dev.piggle.minestom.openboatutils.event.BoatUtilsPacketReceiveEvent;
import dev.piggle.minestom.openboatutils.packet.ObuPacket;
import dev.piggle.minestom.openboatutils.packet.PacketType;
import dev.piggle.minestom.openboatutils.packet.ServerboundConfigurationPacket;
import dev.piggle.minestom.openboatutils.packet.ServerboundSettingsPacket;
import dev.piggle.minestom.openboatutils.packet.clientbound.ClientboundPacketRegistry;
import net.minestom.server.MinecraftServer;
import net.minestom.server.entity.Player;
import net.minestom.server.event.Event;
import net.minestom.server.event.EventNode;
import net.minestom.server.event.player.PlayerPluginMessageEvent;
import net.minestom.server.network.NetworkBuffer;

import java.util.Set;

public class OpenBoatUtils {

    public static final String CHANNEL_SETTINGS = "openboatutils:settings";
    public static final String CHANNEL_CONTEXT = "openboatutils:context";
    public static final String CHANNEL_CONFIGURATION = "openboatutils:configuration";

    private static final Set<String> LISTEN_CHANNELS = Set.of(CHANNEL_SETTINGS, CHANNEL_CONFIGURATION);

    public static void hook(EventNode<Event> eventNode) {
        ClientboundPacketRegistry.init();
        eventNode.addListener(PlayerPluginMessageEvent.class, e -> handlePluginMessage(e.getPlayer(), e.getIdentifier(), e.getMessage()));
    }

    public static void handlePluginMessage(Player player, String channel, byte[] bytes) {
        if (!LISTEN_CHANNELS.contains(channel)) {
            return;
        }

        NetworkBuffer buffer = NetworkBuffer.wrap(bytes, 0, bytes.length + 1);
        int packetId = buffer.read(NetworkBuffer.SHORT);
        ObuPacket<?> packet = switch (channel) {
            case CHANNEL_SETTINGS -> ServerboundSettingsPacket.read(packetId, buffer);
//            case CHANNEL_CONTEXT -> ; // Nothing here yet :(
            case CHANNEL_CONFIGURATION -> ServerboundConfigurationPacket.read(packetId, buffer);
            default -> null;
        };

        MinecraftServer.getGlobalEventHandler().call(new BoatUtilsPacketReceiveEvent(player, packet));
    }

    public static void sendPacket(Player player, ObuPacket<? extends PacketType> packet) {
        player.sendPluginMessage(packet.getPacketType().getChannel(), serializePacket(packet));
    }

    @SuppressWarnings("unchecked")
    public static byte[] serializePacket(ObuPacket<? extends PacketType> packet) {
        NetworkBuffer buffer = NetworkBuffer.resizableBuffer(256);
        var bufferType = (NetworkBuffer.Type<ObuPacket<?>>) ClientboundPacketRegistry.get(packet.getClass());

        buffer.write(NetworkBuffer.SHORT, (short) packet.getPacketType().getPacketId());
        buffer.write(bufferType, packet);

        byte[] bytes = buffer.read(NetworkBuffer.FixedRawBytes((int) buffer.readableBytes()));
        buffer.clear();
        return bytes;
    }
}
