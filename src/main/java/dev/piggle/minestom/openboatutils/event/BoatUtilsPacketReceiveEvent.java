package dev.piggle.minestom.openboatutils.event;

import dev.piggle.minestom.openboatutils.packet.ObuPacket;
import net.minestom.server.entity.Player;
import net.minestom.server.event.trait.PlayerEvent;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

/// Can be called if player is in configuration phase
/// @param packet null if unknown packet was received
public record BoatUtilsPacketReceiveEvent(Player player, @Nullable ObuPacket<?> packet) implements PlayerEvent {

    @Override
    public @NonNull Player getPlayer() {
        return player;
    }
}
