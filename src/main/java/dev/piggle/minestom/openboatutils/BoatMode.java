package dev.piggle.minestom.openboatutils;

import net.minestom.server.network.NetworkBuffer;
import net.minestom.server.network.NetworkBufferTemplate;

/// [Docs link](https://openboatutils.github.io/modes.html)
public enum BoatMode {
    BROKEN_SLIME_RALLY,
    BROKEN_SLIME_RALLY_BLUE,
    BROKEN_SLIME_BA_NOFD,
    BROKEN_SLIME_PARKOUR,
    BROKEN_SLIME_BA_BLUE_NOFD,
    BROKEN_SLIME_PARKOUR_BLUE,
    BROKEN_SLIME_BA,
    BROKEN_SLIME_BA_BLUE,
    RALLY,
    RALLY_BLUE,
    BA_NOFD,
    PARKOUR,
    BA_BLUE_NOFD,
    PARKOUR_BLUE,
    BA,
    BA_BLUE,
    JUMP_BLOCKS,
    BOOSTER_BLOCKS,
    DEFAULT_ICE,
    DEFAULT_NINE_EIGHT_FIVE,
    NOCOL_BOATS_AND_PLAYERS,
    NOCOL_ALL_ENTITIES,
    BA_JANKLESS,
    BA_BLUE_JANKLESS,
    DEFAULT_BLUE_ICE,
    ;

    public static final NetworkBuffer.Type<BoatMode> BUFFER_TEMPLATE = NetworkBufferTemplate.template(NetworkBuffer.SHORT, BoatMode::getId, s -> values()[s]);
    
    public short getId() {
        return (short) ordinal();
    }
}
