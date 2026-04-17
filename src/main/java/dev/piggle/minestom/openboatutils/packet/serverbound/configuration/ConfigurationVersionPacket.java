package dev.piggle.minestom.openboatutils.packet.serverbound.configuration;

import dev.piggle.minestom.openboatutils.packet.ObuPacket;
import dev.piggle.minestom.openboatutils.packet.ServerboundConfigurationPacket;
import net.minestom.server.network.NetworkBuffer;
import net.minestom.server.network.NetworkBufferTemplate;

public record ConfigurationVersionPacket(int version, boolean unstable) implements ObuPacket<ServerboundConfigurationPacket> {

    public static final NetworkBuffer.Type<ConfigurationVersionPacket> TEMPLATE = NetworkBufferTemplate.template(
            NetworkBuffer.INT, ConfigurationVersionPacket::version,
            NetworkBuffer.BOOLEAN, ConfigurationVersionPacket::unstable,
            ConfigurationVersionPacket::new
    );

    @Override
    public ServerboundConfigurationPacket getPacketType() {
        return ServerboundConfigurationPacket.VERSION;
    }
}
