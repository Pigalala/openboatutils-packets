package dev.piggle.obupackets.packet.clientbound.settings;

import dev.piggle.obupackets.packet.ClientboundSettingsPacket;
import dev.piggle.obupackets.packet.ObuPacket;
import net.minestom.server.network.NetworkBuffer;
import net.minestom.server.network.NetworkBufferTemplate;

/// [Docs link](https://openboatutils.github.io/developers/settings.html#set-walltap-multiplier)
public record SettingsSetWalltapMultiplier(float walltapMultiplier) implements ObuPacket<ClientboundSettingsPacket> {

    public static final NetworkBuffer.Type<SettingsSetWalltapMultiplier> TEMPLATE = NetworkBufferTemplate.template(
            NetworkBuffer.FLOAT, SettingsSetWalltapMultiplier::walltapMultiplier,
            SettingsSetWalltapMultiplier::new
    );

    @Override
    public ClientboundSettingsPacket getPacketType() {
        return ClientboundSettingsPacket.SET_WALLTAP_MULTIPLIER;
    }
}
