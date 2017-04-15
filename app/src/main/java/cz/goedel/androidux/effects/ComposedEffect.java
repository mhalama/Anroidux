package cz.goedel.androidux.effects;

import javax.inject.Inject;

/**
 * Used for effect composition
 */
public class ComposedEffect implements Effect {

    private Effect[] effects;

    public ComposedEffect(Effect[] effects) {
        this.effects = effects;
    }

    @Override
    public void register() {
        for (int i = 0; i < effects.length; i++) {
            effects[i].register();
        }
    }

    @Override
    public void unregister() {
        for (int i = 0; i < effects.length; i++) {
            effects[i].unregister();
        }

    }
}
