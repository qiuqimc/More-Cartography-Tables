package com.pnku.mcgt.block;

import net.minecraft.block.*;
import net.minecraft.sound.BlockSoundGroup;

public class MoreCartographyTablesBlock extends CartographyTableBlock {
    public final String cartographytableType;

    public MoreCartographyTablesBlock(MapColor colour, String cartographytableType) {
        super(Settings.copy(Blocks.CARTOGRAPHY_TABLE).mapColor(colour));
        this.cartographytableType = cartographytableType;
    }

    public MoreCartographyTablesBlock(MapColor colour, BlockSoundGroup sound, String cartographytableType) {
        super(Settings.copy(Blocks.CARTOGRAPHY_TABLE).mapColor(colour).sounds(sound));
        this.cartographytableType = cartographytableType;
    }
}