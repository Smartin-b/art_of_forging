package net.acetheeldritchking.art_of_forging;


import net.acetheeldritchking.art_of_forging.effects.ThougnessPuncture;
import net.acetheeldritchking.art_of_forging.item.DummyItem;
import net.acetheeldritchking.art_of_forging.item.ModularItemTriple;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import se.mickelus.tetra.TetraRegistries;

public class AoFRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ArtOfForging.MOD_ID);
    public static final RegistryObject<Item> DUMMY_ITEM = ITEMS.register("dummyitem", DummyItem::new);
    public static final RegistryObject<Item> Test_TRIPPLE = ITEMS.register("modular_triple", ModularItemTriple::new);

    public static void init(IEventBus bus){
        bus.register(AoFRegistry.class);
        ITEMS.register(bus);
        bus.register(new ThougnessPuncture());
    }

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        //ThougnessPuncture.init();
        event.enqueueWork(() -> {
            ThougnessPuncture.init();
        });
    }
}
