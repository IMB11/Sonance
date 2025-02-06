/*? if >=1.21 && fabric {*/
package dev.imb11.sounds.loaders.fabric.datagen;

import dev.imb11.sounds.api.SoundDefinition;
import dev.imb11.sounds.api.datagen.SoundDefinitionProvider;
import dev.imb11.sounds.sound.CustomSounds;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SpawnEggItem;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public class DynamicItemSounds extends SoundDefinitionProvider<Item> {
    protected DynamicItemSounds(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(dataOutput, registriesFuture, "items", BuiltInRegistries.ITEM);
    }

    @Override
    public void accept(BiConsumer<String, SoundDefinition.Builder<Item>> provider) {
        provider.accept("anvils", create(SoundEvents.ANVIL_FALL)
                .addKey(Items.ANVIL)
                .addKey(Items.CHIPPED_ANVIL)
                .addKey(Items.DAMAGED_ANVIL));

        provider.accept("arrows", create(SoundEvents.ARROW_HIT)
                .addKey(ItemTags.ARROWS)
                .setPitch(0.7f)
                .setVolume(0.3f));

        provider.accept("trial_keys", create(SoundEvents.TRIAL_SPAWNER_SPAWN_ITEM_BEGIN)
                .addKey(Items.TRIAL_KEY)
                .addKey(Items.OMINOUS_TRIAL_KEY)
                .setPitch(1f)
                .setVolume(0.4f));

        provider.accept("wind_charge", create(SoundEvents.BREEZE_WIND_CHARGE_BURST)
                .addKey(Items.WIND_CHARGE)
                .setPitch(2f)
                .setVolume(0.1f));

        provider.accept("wooden_equipment", create(SoundEvents.AXE_STRIP)
                .addKey(Items.WOODEN_AXE)
                .addKey(Items.WOODEN_HOE)
                .addKey(Items.WOODEN_PICKAXE)
                .addKey(Items.WOODEN_SHOVEL)
                .addKey(Items.WOODEN_SWORD)
                .addKey(Items.CARROT_ON_A_STICK)
                .addKey(Items.STICK)
                .addKey(Items.WARPED_FUNGUS_ON_A_STICK)
                .addKey(Items.DEBUG_STICK));

        provider.accept("stone_equipment", create(SoundEvents.ARMOR_EQUIP_GENERIC)
                .addKey(Items.STONE_AXE)
                .addKey(Items.STONE_HOE)
                .addKey(Items.STONE_PICKAXE)
                .addKey(Items.STONE_SHOVEL)
                .addKey(Items.STONE_SWORD));

        provider.accept("chainmail_equipment", create(SoundEvents.ARMOR_EQUIP_CHAIN)
                .addKey(Items.CHAINMAIL_HELMET)
                .addKey(Items.CHAINMAIL_CHESTPLATE)
                .addKey(Items.CHAINMAIL_LEGGINGS)
                .addKey(Items.CHAINMAIL_BOOTS));

        provider.accept("iron_equipment", create(SoundEvents.ARMOR_EQUIP_IRON)
                .addKey(Items.SHEARS)
                .addKey(Items.SHIELD)
                .addKey(Items.IRON_AXE)
                .addKey(Items.IRON_HOE)
                .addKey(Items.IRON_PICKAXE)
                .addKey(Items.IRON_SHOVEL)
                .addKey(Items.IRON_SWORD)
                .addKey(Items.IRON_HORSE_ARMOR)
                .addKey(Items.IRON_HELMET)
                .addKey(Items.IRON_CHESTPLATE)
                .addKey(Items.IRON_LEGGINGS)
                .addKey(Items.IRON_BOOTS));

        provider.accept("golden_equipment", create(SoundEvents.ARMOR_EQUIP_GOLD)
                .addKey(Items.GOLDEN_AXE)
                .addKey(Items.GOLDEN_HOE)
                .addKey(Items.GOLDEN_PICKAXE)
                .addKey(Items.GOLDEN_SHOVEL)
                .addKey(Items.GOLDEN_SWORD)
                .addKey(Items.CLOCK)
                .addKey(Items.GOLDEN_HORSE_ARMOR)
                .addKey(Items.GOLDEN_HELMET)
                .addKey(Items.GOLDEN_CHESTPLATE)
                .addKey(Items.GOLDEN_LEGGINGS)
                .addKey(Items.GOLDEN_BOOTS));

        provider.accept("diamond_equipment", create(SoundEvents.ARMOR_EQUIP_DIAMOND)
                .addKey(Items.DIAMOND_AXE)
                .addKey(Items.DIAMOND_HOE)
                .addKey(Items.DIAMOND_PICKAXE)
                .addKey(Items.DIAMOND_SHOVEL)
                .addKey(Items.DIAMOND_SWORD)
                .addKey(Items.DIAMOND_HORSE_ARMOR)
                .addKey(Items.DIAMOND_HELMET)
                .addKey(Items.DIAMOND_CHESTPLATE)
                .addKey(Items.DIAMOND_LEGGINGS)
                .addKey(Items.DIAMOND_BOOTS));

        provider.accept("netherite_equipment", create(SoundEvents.ARMOR_EQUIP_NETHERITE)
                .addKey(Items.NETHERITE_AXE)
                .addKey(Items.NETHERITE_HOE)
                .addKey(Items.NETHERITE_PICKAXE)
                .addKey(Items.NETHERITE_SHOVEL)
                .addKey(Items.NETHERITE_SWORD)
                .addKey(Items.MACE)
                .addKey(Items.NETHERITE_HELMET)
                .addKey(Items.NETHERITE_CHESTPLATE)
                .addKey(Items.NETHERITE_LEGGINGS)
                .addKey(Items.NETHERITE_BOOTS));

        provider.accept("leather_equipment", create(SoundEvents.ARMOR_EQUIP_LEATHER)
                .addKey(Items.LEATHER_HORSE_ARMOR)
                .addKey(Items.LEATHER_HELMET)
                .addKey(Items.LEATHER_CHESTPLATE)
                .addKey(Items.LEATHER_LEGGINGS)
                .addKey(Items.LEATHER_BOOTS)
                .addKey(Items.LEATHER)
                .addKey(Items.SADDLE)
                .addKey(Items.BRUSH)
                .addKey(Items.WOLF_ARMOR)
                .addKey(Items.RABBIT_HIDE));

        provider.accept("exoskeletal", create(SoundEvents.ARMOR_EQUIP_TURTLE)
                .addKey(Items.ARMADILLO_SCUTE)
                .addKey(Items.TURTLE_SCUTE)
                .addKey(Items.TURTLE_EGG)
                .setPitch(1.8f)
                .setVolume(0.5f));

        provider.accept("enchanting_books", create(SoundEvents.END_PORTAL_FRAME_FILL)
                .addKey(Items.ENCHANTED_BOOK)
                .addKey(Items.EXPERIENCE_BOTTLE)
                .setVolume(0.2f)
                .setPitch(0.01f));

        provider.accept("crop_food", create(SoundEvents.CROP_BREAK)
                .addKey(ConventionalItemTags.VEGETABLES_FOODS)
                .addKey(ConventionalItemTags.FRUITS_FOODS)
                .addKey(ConventionalItemTags.BERRIES_FOODS)
                .addKey(ConventionalItemTags.BREADS_FOODS)
                .setVolume(1.0f)
                .setPitch(1.76f));

        provider.accept("bowl_food", create(SoundEvents.MOOSHROOM_MILK_SUSPICIOUSLY)
                .addKey(ConventionalItemTags.SOUPS_FOODS)
                .setVolume(0.5f)
                .setPitch(1.58f));

        provider.accept("meat_and_fish", create(SoundEvents.PUFFER_FISH_FLOP)
                 .addKey(ConventionalItemTags.RAW_FISHES_FOODS)
                .addKey(ConventionalItemTags.RAW_MEATS_FOODS)
                .addKey(ConventionalItemTags.COOKED_FISHES_FOODS)
                .addKey(ConventionalItemTags.COOKED_MEATS_FOODS)
                .setPitch(1.8f)
                .setVolume(0.20f));

        provider.accept("elytra", create(SoundEvents.ARMOR_EQUIP_ELYTRA)
                .addKey(Items.ELYTRA));

        provider.accept("trident", create(SoundEvents.TRIDENT_HIT)
                .addKey(Items.TRIDENT));

        provider.accept("bows", create(SoundEvents.ARROW_SHOOT)
                .addKey(Items.BOW)
                .addKey(Items.CROSSBOW));

        provider.accept("fishing_rods", create(SoundEvents.POINTED_DRIPSTONE_DRIP_WATER_INTO_CAULDRON)
                .addKey(Items.FISHING_ROD));

        provider.accept("flint_and_steel", create(SoundEvents.FLINTANDSTEEL_USE)
                .addKey(Items.FLINT_AND_STEEL));

        provider.accept("dyes", create(SoundEvents.DYE_USE)
                .addKey(ConventionalItemTags.DYES));

        provider.accept("papers", create(SoundEvents.BOOK_PAGE_TURN)
                .addKey(Items.PAPER)
                .addKey(Items.FILLED_MAP)
                .addKey(Items.MAP));

        provider.accept("fireworks", create(SoundEvents.BAMBOO_SAPLING_HIT)
                .addKey(Items.FIREWORK_ROCKET));

        provider.accept("ingot_metals", create(SoundEvents.METAL_BREAK)
                .addKey(Items.IRON_INGOT)
                .addKey(Items.GOLD_INGOT)
                .addKey(Items.NETHERITE_INGOT)
                .addKey(Items.COPPER_INGOT)
                .addKey(Items.IRON_NUGGET)
                .addKey(Items.GOLD_NUGGET)
                .addKey(Items.NETHERITE_SCRAP)
                .addKey(Items.RAW_GOLD)
                .addKey(Items.RAW_IRON)
                .addKey(Items.RAW_COPPER));

        provider.accept("shiny_metals", create(SoundEvents.AMETHYST_CLUSTER_HIT)
                .addKey(Items.AMETHYST_SHARD)
                .addKey(Items.QUARTZ)
                .addKey(Items.EMERALD)
                .addKey(Items.LAPIS_LAZULI)
                .addKey(Items.DIAMOND));

        provider.accept("bowl", create(SoundEvents.BAMBOO_SAPLING_HIT)
                .addKey(Items.BOWL)
                .setPitch(1.85f)
                .setVolume(0.25f));

        provider.accept("oak_boat", create(SoundEvents.WOOD_HIT)
                .addKey(Items.OAK_BOAT)
                .addKey(Items.OAK_CHEST_BOAT)
                .setPitch(1.75f)
                .setVolume(0.75f));

        provider.accept("birch_boat", create(CustomSounds.BLOCK_BIRCH_PLANKS_HIT.get())
                .addKey(Items.BIRCH_BOAT)
                .addKey(Items.BIRCH_CHEST_BOAT)
                .setPitch(1.75f)
                .setVolume(0.75f));

        provider.accept("spruce_boat", create(CustomSounds.BLOCK_SPRUCE_PLANKS_HIT.get())
                .addKey(Items.SPRUCE_BOAT)
                .addKey(Items.SPRUCE_CHEST_BOAT)
                .setPitch(1.75f)
                .setVolume(0.75f));

        provider.accept("jungle_boat", create(CustomSounds.BLOCK_JUNGLE_PLANKS_HIT.get())
                .addKey(Items.JUNGLE_BOAT)
                .addKey(Items.JUNGLE_CHEST_BOAT)
                .setPitch(1.75f)
                .setVolume(0.75f));

        provider.accept("acacia_boat", create(CustomSounds.BLOCK_ACACIA_PLANKS_HIT.get())
                .addKey(Items.ACACIA_BOAT)
                .addKey(Items.ACACIA_CHEST_BOAT)
                .setPitch(1.75f)
                .setVolume(0.75f));

        provider.accept("dark_oak_boat", create(SoundEvents.WOOD_HIT)
                .addKey(Items.DARK_OAK_BOAT)
                .addKey(Items.DARK_OAK_CHEST_BOAT)
                .setPitch(1.75f)
                .setVolume(0.75f));

        provider.accept("cherry_boat", create(SoundEvents.WOOD_HIT)
                .addKey(Items.CHERRY_BOAT)
                .addKey(Items.CHERRY_CHEST_BOAT)
                .setPitch(1.75f)
                .setVolume(0.75f));

        provider.accept("mangrove_boat", create(CustomSounds.BLOCK_MANGROVE_PLANKS_HIT.get())
                .addKey(Items.MANGROVE_BOAT)
                .addKey(Items.MANGROVE_CHEST_BOAT)
                .setPitch(1.75f)
                .setVolume(0.75f));

        provider.accept("bamboo_raft", create(SoundEvents.BAMBOO_WOOD_HIT)
                .addKey(Items.BAMBOO_RAFT)
                .addKey(Items.BAMBOO_CHEST_RAFT)
                .setPitch(1.75f)
                .setVolume(0.75f));

        provider.accept("minecarts", create(SoundEvents.METAL_PRESSURE_PLATE_CLICK_ON)
                .addKey(Items.MINECART)
                .addKey(Items.CHEST_MINECART)
                .addKey(Items.FURNACE_MINECART)
                .addKey(Items.TNT_MINECART)
                .addKey(Items.HOPPER_MINECART)
                .addKey(Items.COMMAND_BLOCK_MINECART)
                .setPitch(1.75f)
                .setVolume(0.75f));

        provider.accept("dirty_metals", create(SoundEvents.GRAVEL_HIT)
                .addKey(Items.COAL)
                .addKey(Items.CHARCOAL)
                .addKey(Items.FLINT)
                .addKey(Items.CLAY_BALL)
                .addKey(Items.REDSTONE)
                .addKey(Items.GLOWSTONE)
                .addKey(Items.GUNPOWDER));

        provider.accept("shards", create(SoundEvents.DECORATED_POT_STEP)
                .addKey(Items.DISC_FRAGMENT_5)
                .addKey(ItemTags.DECORATED_POT_SHERDS));

        provider.accept("smithing_templates", create(SoundEvents.IRON_GOLEM_STEP)
                .addKey(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE)
                .addKey(TagKey.create(Registries.ITEM, ResourceLocation.parse("trim_templates"))));

        provider.accept("filled_buckets", create(SoundEvents.BUCKET_FILL)
                .addKey(ConventionalItemTags.WATER_BUCKETS)
                .addKey(ConventionalItemTags.ENTITY_WATER_BUCKETS));

        provider.accept("moo", create(SoundEvents.COW_AMBIENT)
                .addKey(Items.MILK_BUCKET));

        provider.accept("banner_templates", create(SoundEvents.WOOL_HIT)
                .addKey(Items.CREEPER_BANNER_PATTERN)
                .addKey(Items.FLOWER_BANNER_PATTERN)
                .addKey(Items.GLOBE_BANNER_PATTERN)
                .addKey(Items.MOJANG_BANNER_PATTERN)
                .addKey(Items.SKULL_BANNER_PATTERN)
                .addKey(Items.PIGLIN_BANNER_PATTERN));

        provider.accept("brewing_items", create(SoundEvents.BOTTLE_FILL)
                .addKey(Items.GLASS_BOTTLE)
                .addKey(Items.POTION)
                .addKey(Items.DRAGON_BREATH)
                .addKey(Items.SPLASH_POTION)
                .addKey(Items.OMINOUS_BOTTLE)
                .addKey(Items.LINGERING_POTION));

        provider.accept("wet_mob_drops", create(SoundEvents.SLIME_BLOCK_HIT)
                .addKey(Items.SLIME_BALL)
                .addKey(Items.HONEYCOMB)
                .addKey(Items.HONEY_BOTTLE)
                .addKey(Items.FERMENTED_SPIDER_EYE)
                .addKey(Items.BLAZE_POWDER)
                .addKey(Items.RABBIT_FOOT)
                .addKey(Items.SPIDER_EYE)
                .addKey(Items.ROTTEN_FLESH)
                .addKey(Items.GLISTERING_MELON_SLICE)
                .addKey(Items.MAGMA_CREAM)
                .addKey(Items.GHAST_TEAR));

        provider.accept("sculk", create(SoundEvents.SCULK_VEIN_FALL)
                .addKey(Items.ECHO_SHARD));

        provider.accept("bones", create(SoundEvents.SKELETON_AMBIENT)
                .addKey(Items.BONE)
                .addKey(Items.BONE_MEAL));

        // Spawn Eggs
//        for (Item item : Registries.ITEM) {
//            if (item instanceof SpawnEggItem spawnEggItem) {
//                EntityType<?> entityType = spawnEggItem.getEntityType(null);
//                Identifier soundEventID = getAmbientSoundForEntity(entityType);
//                @Nullable SoundEvent soundEvent = Registries.SOUND_EVENT.get(soundEventID);
//                if (soundEvent != null) {
//                    String spawnEggName = Registries.ITEM.getId(spawnEggItem).getPath();
//                    provider.accept(spawnEggName, create(soundEvent).addKey(spawnEggItem));
//                } else {
//                    LOGGER.warn("Could not find ambient sound event for entity type " + entityType.getTranslationKey());
//                }
//            }
//        }

        List<Item> spawnEggs = BuiltInRegistries.ITEM.stream().filter(item -> item instanceof SpawnEggItem).toList();
        provider.accept("spawn_eggs", create(SoundEvents.SNIFFER_EGG_PLOP)
                .addKey(Items.EGG)
                .addMultipleKeys(spawnEggs.toArray(Item[]::new)));
    }

//    private Identifier getAmbientSoundForEntity(EntityType<?> entityType) {
//        return Identifier.of("entity." + entityType.getUntranslatedName() + ".ambient");
//    }
}
/*?}*/
