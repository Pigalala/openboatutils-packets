package dev.piggle.minestom.openboatutils.packet.serverbound.configuration;

import dev.piggle.minestom.openboatutils.packet.ObuPacket;
import dev.piggle.minestom.openboatutils.packet.ServerboundConfigurationPacket;
import net.minestom.server.network.NetworkBuffer;
import net.minestom.server.network.NetworkBufferTemplate;

public record ConfigurationVersion(int version, boolean unstable) implements ObuPacket<ServerboundConfigurationPacket> {

    public static final NetworkBuffer.Type<ConfigurationVersion> TEMPLATE = NetworkBufferTemplate.template(
            NetworkBuffer.INT, ConfigurationVersion::version,
            NetworkBuffer.BOOLEAN, ConfigurationVersion::unstable,
            ConfigurationVersion::new
    );

    @Override
    public ServerboundConfigurationPacket getPacketType() {
        return ServerboundConfigurationPacket.VERSION;
    }
}
