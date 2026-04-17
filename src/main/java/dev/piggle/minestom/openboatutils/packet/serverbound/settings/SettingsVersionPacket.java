package dev.piggle.minestom.openboatutils.packet.serverbound.settings;

import dev.piggle.minestom.openboatutils.packet.ObuPacket;
import dev.piggle.minestom.openboatutils.packet.ServerboundSettingsPacket;
import net.minestom.server.network.NetworkBuffer;
import net.minestom.server.network.NetworkBufferTemplate;

public record SettingsVersionPacket(int version, boolean unstable) implements ObuPacket<ServerboundSettingsPacket> {

    public static final NetworkBuffer.Type<SettingsVersionPacket> TEMPLATE = NetworkBufferTemplate.template(
            NetworkBuffer.INT, SettingsVersionPacket::version,
            NetworkBuffer.BOOLEAN, SettingsVersionPacket::unstable,
            SettingsVersionPacket::new
    );

    @Override
    public ServerboundSettingsPacket getPacketType() {
        return ServerboundSettingsPacket.VERSION;
    }
}
