package com.pnku.mcgt.poi;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.pnku.mcgt.init.McgtBlockInit;
import com.pnku.mcgt.mixin.PointOfInterestTypesAccessor;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.registry.Registries;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.poi.PointOfInterestType;
import net.minecraft.world.poi.PointOfInterestTypes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class McgtPointOfInterestTypes {
    public static void init() {
        Map<BlockState, RegistryEntry<PointOfInterestType>> poiStatesToType = PointOfInterestTypesAccessor
                .getPointOfInterestStatesToType();

        RegistryEntry<PointOfInterestType> cartographerEntry = Registries.POINT_OF_INTEREST_TYPE
                .getEntry(PointOfInterestTypes.CARTOGRAPHER).get();

        PointOfInterestType cartographerPoiType = Registries.POINT_OF_INTEREST_TYPE.get(PointOfInterestTypes.CARTOGRAPHER);

        List<BlockState> cartographerBlockStates = new ArrayList<BlockState>(cartographerPoiType.blockStates);

        for (Block block : McgtBlockInit.more_cartography_tables) {
            ImmutableList<BlockState> blockStates = block.getStateManager().getStates();

            for (BlockState blockState : blockStates) {
                poiStatesToType.putIfAbsent(blockState, cartographerEntry);
            }

            cartographerBlockStates.addAll(blockStates);
        }

        cartographerPoiType.blockStates = ImmutableSet.copyOf(cartographerBlockStates);
    }
}