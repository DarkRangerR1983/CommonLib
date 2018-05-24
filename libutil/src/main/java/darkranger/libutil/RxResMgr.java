package darkranger.libutil;

import android.content.Context;
import android.graphics.drawable.Drawable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


/**
 * 创建者  : 唐朝
 * 创建时间: 2017/8/8.
 * 类名    :该工具类用于获取本地指定资源信息
 * 类功能  :
 */

public class RxResMgr {

    /**
     * 根据本地Assets目录下资源名称，获取String数据信息
     *
     * @param fileName 文件名称
     * @return String  返回数据
     */
    public static String getStringByAssets(String fileName) {
        Context context = RxTool.getContext();
        if (context == null || RxStringTool.isEmpty(fileName)) {
            return null;
        }
        try {
            StringBuilder s = new StringBuilder("");
            InputStreamReader in = new InputStreamReader(context.getResources().getAssets().open(fileName));
            BufferedReader br = new BufferedReader(in);
            String line;
            while ((line = br.readLine()) != null) {
                s.append(line);
            }
            return s.toString();
        } catch (IOException e) {
            e.printStackTrace();
            RxLogTool.e("AppResourceMgr-->>getStringByAssets", "根据本地Assets目录下资源名称，获取String数据信息失败！" + e.getMessage());
            return null;
        }
    }

    public static Drawable getDrawableByResId(int drawableByResId){
        Context context = RxTool.getContext();
        return context.getResources().getDrawable(drawableByResId);

    }


    /**
     * 根据本地Assets目录下资源名称，获取List集合信息
     *
     * @param fileName 文件名称
     * @return List<String>  返回集合
     */
    public static List<String> getListByAssets(String fileName) {
        Context context = RxTool.getContext();
        if (context == null || RxStringTool.isEmpty(fileName)) {
            return null;
        }
        List<String> fileContent = new ArrayList<String>();
        try {
            InputStreamReader in = new InputStreamReader(context.getResources().getAssets().open(fileName));
            BufferedReader br = new BufferedReader(in);
            String line;
            while ((line = br.readLine()) != null) {
                fileContent.add(line);
            }
            br.close();
            return fileContent;
        } catch (IOException e) {
            e.printStackTrace();
            RxLogTool.e("AppResourceMgr-->>getListByAssets", "根据本地Assets目录下资源名称，获取List集合信息失败！" + e.getMessage());
            return null;
        }
    }


    /**
     * 根据本地Raw目录下资源标识，获取String数据信息
     *
     * @param resId 资源标识
     * @return String 返回数据
     */
    public static String getStringByRaw(int resId) {
        Context context = RxTool.getContext();
        if (context == null) {
            return null;
        }
        try {
            StringBuilder s = new StringBuilder();
            InputStreamReader in = new InputStreamReader(context.getResources().openRawResource(resId));
            BufferedReader br = new BufferedReader(in);
            String line;
            while ((line = br.readLine()) != null) {
                s.append(line);
            }
            return s.toString();
        } catch (IOException e) {
            e.printStackTrace();
            RxLogTool.e("AppResourceMgr-->>getStringByRaw", "根据本地Raw目录下资源标识，获取String数据信息失败！" + e.getMessage());
            return null;
        }
    }

    /**
     * 根据本地values目录下获取string信息
     *
     * @param resId
     * @return
     */
    public static String getStringByValue(int resId) {
        Context context = RxTool.getContext();
        if (context == null) {
            return null;
        }
        return context.getResources().getString(resId);
    }
    public static int getColorByValue(int resId) {
        Context context = RxTool.getContext();
        if (context == null) {
            return -1;
        }
        int color = context.getResources().getColor(resId);
        return color;
    }


    /**
     * 根据本地Raw目录下资源标识，获取List集合信息
     *
     * @param context 上下文对象
     * @param resId   资源标识
     * @return List<String> 返回集合
     */
    public static List<String> getListByRaw(Context context, int resId) {
        if (context == null) {
            return null;
        }
        List<String> fileContent = new ArrayList<String>();
        BufferedReader reader = null;
        try {
            InputStreamReader in = new InputStreamReader(context.getResources().openRawResource(resId));
            reader = new BufferedReader(in);
            String line = null;
            while ((line = reader.readLine()) != null) {
                fileContent.add(line);
            }
            reader.close();
            return fileContent;
        } catch (IOException e) {
            e.printStackTrace();
            RxLogTool.e("AppResourceMgr-->>getListByRaw", "根据本地Raw目录下资源标识，获取List集合信息失败！" + e.getMessage());
            return null;
        }
    }
}
