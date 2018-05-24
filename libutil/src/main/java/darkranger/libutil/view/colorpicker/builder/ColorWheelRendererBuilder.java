package darkranger.libutil.view.colorpicker.builder;


import darkranger.libutil.view.colorpicker.ColorPickerView;
import darkranger.libutil.view.colorpicker.renderer.ColorWheelRenderer;
import darkranger.libutil.view.colorpicker.renderer.FlowerColorWheelRenderer;
import darkranger.libutil.view.colorpicker.renderer.SimpleColorWheelRenderer;

/**
 * @author vondear
 */
public class ColorWheelRendererBuilder {
    public static ColorWheelRenderer getRenderer(ColorPickerView.WHEEL_TYPE wheelType) {
        switch (wheelType) {
            case CIRCLE:
                return new SimpleColorWheelRenderer();
            case FLOWER:
                return new FlowerColorWheelRenderer();
                default:
                    break;
        }
        throw new IllegalArgumentException("wrong WHEEL_TYPE");
    }
}