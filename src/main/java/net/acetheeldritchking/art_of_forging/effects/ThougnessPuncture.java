package net.acetheeldritchking.art_of_forging.effects;

import net.acetheeldritchking.art_of_forging.ArtOfForging;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ForgeMod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import se.mickelus.tetra.blocks.workbench.gui.WorkbenchStatsGui;
import se.mickelus.tetra.effect.ItemEffect;
import se.mickelus.tetra.gui.stats.bar.GuiStatBar;
import se.mickelus.tetra.gui.stats.getter.*;
import se.mickelus.tetra.items.modular.impl.holo.gui.craft.HoloStatsGui;

import static se.mickelus.tetra.gui.stats.StatsHelper.barLength;

public class ThougnessPuncture {
    private static final ItemEffect puncture = ItemEffect.get(ArtOfForging.MOD_ID+":puncture");
    private static final Logger LOGGER = LogManager.getLogger();

    public static void init(){
        final IStatGetter punctureStatGetter = new StatGetterEffectLevel(puncture, 1);
        final GuiStatBar punctureBar = new GuiStatBar(0, 0, barLength, "art_of_forging.effect.puncture.name", 0, 10, false, punctureStatGetter, LabelGetterBasic.decimalLabel,
                    new TooltipGetterDecimal("art_of_forging.effect.puncture.tooltip", punctureStatGetter));
        WorkbenchStatsGui.addBar(punctureBar);
        HoloStatsGui.addBar(punctureBar);
    }


}
