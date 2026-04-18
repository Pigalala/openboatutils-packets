package dev.piggle.obupackets.packet.clientbound.settings;

import dev.piggle.obupackets.PerBlockSetting;
import dev.piggle.obupackets.packet.ClientboundSettingsPacket;
import dev.piggle.obupackets.packet.ObuPacket;
import net.minestom.server.instance.block.Block;
import net.minestom.server.network.NetworkBuffer;
import net.minestom.server.network.NetworkBufferTemplate;

import java.util.Collection;
import java.util.stream.Collectors;

/// [Docs link](https://openboatutils.github.io/developers/settings.html#set-per-block-setting)
public record SettingsSetPerBlockSetting(PerBlockSetting setting, float value, String blocks) implements ObuPacket<ClientboundSettingsPacket> {

    public SettingsSetPerBlockSetting(PerBlockSetting setting, float value, Collection<Block> blocks) {
        this(setting, value, blocks.stream().map(Block::name).collect(Collectors.joining(",")));
    }

    public static final NetworkBuffer.Type<SettingsSetPerBlockSetting> TEMPLATE = NetworkBufferTemplate.template(
            PerBlockSetting.NETWORK_TEMPLATE, SettingsSetPerBlockSetting::setting,
            NetworkBuffer.FLOAT, SettingsSetPerBlockSetting::value,
            NetworkBuffer.STRING, SettingsSetPerBlockSetting::blocks,
            SettingsSetPerBlockSetting::new
    );

    @Override
    public ClientboundSettingsPacket getPacketType() {
        return ClientboundSettingsPacket.SET_PER_BLOCK;
    }
}
