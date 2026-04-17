package dev.piggle.minestom.openboatutils.packet.clientbound.settings;

import dev.piggle.minestom.openboatutils.packet.ClientboundSettingsPacket;
import dev.piggle.minestom.openboatutils.packet.ObuPacket;
import net.minestom.server.instance.block.Block;
import net.minestom.server.network.NetworkBuffer;
import net.minestom.server.network.NetworkBufferTemplate;
import net.minestom.server.registry.StaticProtocolObject;

import java.util.Collection;
import java.util.stream.Collectors;

/// [Docs link](https://openboatutils.github.io/developers/settings.html#clear-blocks-slipperiness)
public record SettingsClearBlocksSlipperiness(String blocks) implements ObuPacket<ClientboundSettingsPacket> {

    public SettingsClearBlocksSlipperiness(Collection<Block> blocks) {
        this(blocks.stream().map(StaticProtocolObject::name).collect(Collectors.joining(",")));
    }

    public static final NetworkBuffer.Type<SettingsClearBlocksSlipperiness> TEMPLATE = NetworkBufferTemplate.template(
            NetworkBuffer.STRING, SettingsClearBlocksSlipperiness::blocks,
            SettingsClearBlocksSlipperiness::new
    );

    @Override
    public ClientboundSettingsPacket getPacketType() {
        return ClientboundSettingsPacket.REMOVE_BLOCKS_SLIPPERINESS;
    }
}
