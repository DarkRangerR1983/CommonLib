package darkranger.libutil.view.flexbox;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import darkranger.libutil.view.flexbox.widget.BaseTagView;


/**
 * 创建者  : 唐朝
 * 创建时间: 2018/1/26.
 * 类名    :
 * 类功能  :
 */

public class StringTagView extends BaseTagView<String> {

    public StringTagView(Context context) {
        this(context, null);
    }

    public StringTagView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public StringTagView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setItem(String item) {
        super.setItem(item);
        textView.setText(item);
    }
}
