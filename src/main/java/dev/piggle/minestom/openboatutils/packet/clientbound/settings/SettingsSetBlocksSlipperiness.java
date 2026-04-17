package dev.piggle.minestom.openboatutils.packet.clientbound.settings;

import dev.piggle.minestom.openboatutils.packet.ClientboundSettingsPacket;
import dev.piggle.minestom.openboatutils.packet.ObuPacket;
import net.minestom.server.instance.block.Block;
import net.minestom.server.network.NetworkBuffer;
import net.minestom.server.network.NetworkBufferTemplate;

import java.util.Collection;
import java.util.stream.Collectors;

/// [Docs link](https://openboatutils.github.io/developers/settings.html#set-block-s-slipperiness)
public record SettingsSetBlocksSlipperiness(float slipperiness, String blocks) implements ObuPacket<ClientboundSettingsPacket> {

    public SettingsSetBlocksSlipperiness(float slipperiness, Collection<Block> blocks) {
        this(slipperiness, blocks.stream().map(Block::name).collect(Collectors.joining(",")));
    }

    public static final NetworkBuffer.Type<SettingsSetBlocksSlipperiness> TEMPLATE = NetworkBufferTemplate.template(
            NetworkBuffer.FLOAT, SettingsSetBlocksSlipperiness::slipperiness,
            NetworkBuffer.STRING, SettingsSetBlocksSlipperiness::blocks,
            SettingsSetBlocksSlipperiness::new
    );

    @Override
    public ClientboundSettingsPacket getPacketType() {
        return ClientboundSettingsPacket.SET_BLOCKS_SLIPPERINESS;
    }
}
