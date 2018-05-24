package darkranger.libutil.view.colorpicker.renderer;


import java.util.List;

import darkranger.libutil.view.colorpicker.ColorCircle;

/**
 * @author vondear
 */
public interface ColorWheelRenderer {
    float GAP_PERCENTAGE = 0.025f;

    void draw();

    ColorWheelRenderOption getRenderOption();

    void initWith(ColorWheelRenderOption colorWheelRenderOption);

    List<ColorCircle> getColorCircleList();
}
