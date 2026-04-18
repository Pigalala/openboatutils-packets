package dev.piggle.obupackets.packet.clientbound.settings;

import dev.piggle.obupackets.packet.ClientboundSettingsPacket;
import dev.piggle.obupackets.packet.ObuPacket;
import net.minestom.server.network.NetworkBuffer;
import net.minestom.server.network.NetworkBufferTemplate;

/// [Docs link](https://openboatutils.github.io/developers/settings.html#resend-version)
public record SettingsResendVersion() implements ObuPacket<ClientboundSettingsPacket> {

    public static final NetworkBuffer.Type<SettingsResendVersion> TEMPLATE = NetworkBufferTemplate.template(new SettingsResendVersion());

    @Override
    public ClientboundSettingsPacket getPacketType() {
        return ClientboundSettingsPacket.RESEND_VERSION;
    }
}
