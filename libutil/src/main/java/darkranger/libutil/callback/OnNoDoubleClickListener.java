package darkranger.libutil.callback;

import android.view.View;

import java.util.Calendar;

/**
 * @author: david tang
 * @date: 2018/3/28.
 * @className:  避免在1秒内出发多次点击
 * @classFunction:
 */
public abstract class OnNoDoubleClickListener implements View.OnClickListener {
    public static final int MIN_CLICK_DELAY_TIME = 1000;
    private long lastClickTime = 0;
    private int id = -1;

    @Override
    public void onClick(final View v) {
        long currentTime = Calendar.getInstance().getTimeInMillis();
        int mId = v.getId();
        if (id != mId) {
            id = mId;
            lastClickTime = currentTime;
            onNoDoubleClick(v);
            return;
        }
        if (currentTime - lastClickTime > MIN_CLICK_DELAY_TIME) {
            lastClickTime = currentTime;
            onNoDoubleClick(v);
        }
    }

    protected abstract void onNoDoubleClick(View v);
}
