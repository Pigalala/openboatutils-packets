package dev.piggle.minestom.openboatutils;

import net.minestom.server.network.NetworkBuffer;
import net.minestom.server.network.NetworkBufferTemplate;

public enum PerBlockSetting {
    JUMP_FORCE,
    FORWARDS_ACCEL,
    YAW_ACCEL,
    TURN_FORWARDS_ACCEL,
    WALLTAP_MULTIPLIER,
    JUMPS,
    COYOTE_TIME,
    ;

    public static final NetworkBuffer.Type<PerBlockSetting> NETWORK_TEMPLATE = NetworkBufferTemplate.template(NetworkBuffer.SHORT, PerBlockSetting::getId, s -> values()[s]);

    public short getId() {
        return (short) ordinal();
    }
}
