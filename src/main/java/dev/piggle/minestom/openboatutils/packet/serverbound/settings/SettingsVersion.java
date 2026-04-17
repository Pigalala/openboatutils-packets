package dev.piggle.minestom.openboatutils.packet.serverbound.settings;

import dev.piggle.minestom.openboatutils.packet.ObuPacket;
import dev.piggle.minestom.openboatutils.packet.ServerboundSettingsPacket;
import net.minestom.server.network.NetworkBuffer;
import net.minestom.server.network.NetworkBufferTemplate;

public record SettingsVersion(int version, boolean unstable) implements ObuPacket<ServerboundSettingsPacket> {

    public static final NetworkBuffer.Type<SettingsVersion> TEMPLATE = NetworkBufferTemplate.template(
            NetworkBuffer.INT, SettingsVersion::version,
            NetworkBuffer.BOOLEAN, SettingsVersion::unstable,
            SettingsVersion::new
    );

    @Override
    public ServerboundSettingsPacket getPacketType() {
        return ServerboundSettingsPacket.VERSION;
    }
}
