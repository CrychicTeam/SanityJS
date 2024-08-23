package work.crash.skyraah.sanityjs.event;

import dev.latvian.mods.kubejs.event.EventGroup;
import dev.latvian.mods.kubejs.event.EventHandler;

public interface SanityEvents {
    EventGroup GROUP = EventGroup.of("SanityEvents");

    EventHandler SAN_CHANGE = GROUP.server("change", () -> SanityChangeEventJS.class);
}
