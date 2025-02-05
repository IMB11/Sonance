package dev.imb11.sounds.config;

import dev.imb11.mru.yacl.ConfigHelper;
import dev.imb11.sounds.config.utils.ConfigGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;

import java.util.HashMap;

public class SoundsConfig {
    public static final ConfigHelper HELPER = new ConfigHelper("sounds", "config");
    private static final HashMap<Class<?>, ConfigGroup> CONFIG_GROUPS = new HashMap<>();

    static {
        addGroup(new WorldSoundsConfig());
        addGroup(new ChatSoundsConfig());
        addGroup(new EventSoundsConfig());
        addGroup(new UISoundsConfig());
        addGroup(new ModConfig());
    }

    private static void addGroup(ConfigGroup group) {
        CONFIG_GROUPS.put(group.getClass(), group);
    }

    public static void loadAll() {
        CONFIG_GROUPS.values().forEach(ConfigGroup::load);
    }

    public static ConfigGroup[] getAll() {
        return CONFIG_GROUPS.values().toArray(new ConfigGroup[0]);
    }

    public static <T extends ConfigGroup> T getRaw(Class<T> clazz) {
        if (CONFIG_GROUPS.containsKey(clazz)) {
            return (T) CONFIG_GROUPS.get(clazz);
        }

        throw new IllegalArgumentException("No config group found for class " + clazz.getName());
    }

    public static <T extends ConfigGroup> T get(Class<T> clazz) {
        if (CONFIG_GROUPS.containsKey(clazz)) {
            return (T) CONFIG_GROUPS.get(clazz).getHandler().instance();
        }

        throw new IllegalArgumentException("No config group found for class " + clazz.getName());
    }

    public static RegistryEntry.Reference<SoundEvent> getSoundEventReference(SoundEvent soundEvent) {
        //? if <1.21.2 {
         return Registries.SOUND_EVENT.getEntry(RegistryKey.of(Registries.SOUND_EVENT.getKey(), soundEvent.getId())).get();
        //?} else {
        /*return Registries.SOUND_EVENT.getOptional(RegistryKey.of(Registries.SOUND_EVENT.getKey(), soundEvent.id())).get();
        *///?}
    }
}
