package dev.piggle.minestom.openboatutils;

import net.minestom.server.network.NetworkBuffer;
import net.minestom.server.network.NetworkBufferTemplate;

public enum CollisionMode {
    VANILLA,
    NO_BOATS_OR_PLAYERS,
    NO_ENTITIES,
    ENTITYTYPE_FILTER,
    NO_BOATS_OR_PLAYERS_PLUS_FILTER,
    ;

    public static final NetworkBuffer.Type<CollisionMode> NETWORK_TEMPLATE = NetworkBufferTemplate.template(NetworkBuffer.SHORT, CollisionMode::getId, s -> values()[s]);

    public short getId() {
        return (short) ordinal();
    }
}
