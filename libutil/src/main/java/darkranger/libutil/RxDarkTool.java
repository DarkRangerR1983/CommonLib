package darkranger.libutil;

import android.annotation.SuppressLint;
import android.content.Context;

/**
 * @author: david tang
 * @date: 2018/5/24.
 * @className:
 * @classFunction:
 */
public class RxDarkTool {
    @SuppressLint("StaticFieldLeak")
    private static Context context;
    /**
     * 初始化工具类
     *
     * @param context 上下文
     */
    public static void init(Context context) {
        RxDarkTool.context = context.getApplicationContext();

    }
}
