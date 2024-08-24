package work.crash.skyraah.sanityjs.event;


import croissantnova.sanitydim.capability.SanityProvider;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import work.crash.skyraah.sanityjs.SanityJS;

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
        if (event.phase == TickEvent.Phase.START) {
            return;
        }
        if (!(event.player instanceof ServerPlayer player)) {
            return;
        }

        player.getCapability(SanityProvider.CAP).ifPresent(sanity -> {
            float value = sanity.getSanity();
            UUID uuid = player.getUUID();
            Float lastValue = SANITY_MAP.get(uuid);

            if (lastValue == null) {
                SANITY_MAP.put(uuid, value);
                return;
            }
            if (lastValue != value) {
                SANITY_MAP.put(uuid, value);
                SanityEvents.SAN_CHANGE.post(new SanityChangeEventJS(lastValue, player));
            }
        });
    }
}
