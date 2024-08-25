package work.crash.skyraah.sanityjs.event;


import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import work.crash.skyraah.sanityjs.SanityJS;
import work.crash.skyraah.sanityjs.util.IPlayerSanity;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author skyraah
 */
@Mod.EventBusSubscriber(modid = SanityJS.ID)
public class SanityChangeEvent {

    private static final Map<UUID, Float> SANITY_MAP = new HashMap<>();

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.player instanceof ServerPlayer player && event.phase == TickEvent.Phase.END) {
            /*player.getCapability(SanityProvider.CAP).ifPresent(sanity -> {
                float value = sanity.getSanity();
                UUID uuid = player.getUUID();
                Float lastValue = SANITY_MAP.get(uuid);
                if (lastValue != null && lastValue != value) {
                    SanityEvents.SAN_CHANGE.post(new SanityChangeEventJS(lastValue, value, player));
                }
                SANITY_MAP.put(uuid, value);
            });*/
            float value = ((IPlayerSanity) player).getSanity();
            UUID uuid = player.getUUID();
            Float lastValue = SANITY_MAP.get(uuid);
            if (lastValue != null && lastValue != value) {
                SanityEvents.SAN_CHANGE.post(new SanityChangeEventJS(value, lastValue, player));
            }
            SANITY_MAP.put(uuid, value);
        }
    }
}
