package work.crash.skyraah.sanityjs.util;

import org.spongepowered.asm.mixin.Unique;

public interface IPlayerSanity {
    @Unique
    float getSanity();

    @Unique
    void setSanity(float value);

    @Unique
    void addSanity(float value);
}
