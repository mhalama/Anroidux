package cz.goedel.androidux.effects;

/**
 * Used for effect composition.
 *
 * TODO: This should be generated somehow from annotations.
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
