package darkranger.libutil.view.progressing.style;


import darkranger.libutil.view.progressing.sprite.Sprite;
import darkranger.libutil.view.progressing.sprite.SpriteContainer;

/**
 * @author vondear
 */
public class MultiplePulse extends SpriteContainer {
    @Override
    public Sprite[] onCreateChild() {
        return new Sprite[]{
                new Pulse(),
                new Pulse(),
                new Pulse(),
        };
    }

    @Override
    public void onChildCreated(Sprite... sprites) {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].setAnimationDelay(200 * (i + 1));
        }
    }
}
