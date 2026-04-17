package dev.piggle.minestom.openboatutils.packet.clientbound.settings;

import dev.piggle.minestom.openboatutils.packet.ClientboundSettingsPacket;
import dev.piggle.minestom.openboatutils.packet.ObuPacket;
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
