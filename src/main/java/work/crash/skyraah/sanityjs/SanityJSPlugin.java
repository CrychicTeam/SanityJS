package work.crash.skyraah.sanityjs;

import dev.latvian.mods.kubejs.KubeJSPlugin;
import dev.latvian.mods.kubejs.script.ScriptType;
import dev.latvian.mods.kubejs.util.ClassFilter;
import work.crash.skyraah.sanityjs.event.SanityEvents;

public class SanityJSPlugin extends KubeJSPlugin {
    @Override
    public void registerEvents() {
        SanityEvents.GROUP.register();
    }

    @Override
    public void registerClasses(ScriptType type, ClassFilter filter) {
        super.registerClasses(type, filter);
    }
}

