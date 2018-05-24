package darkranger.libutil;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;

/**
 * @author: david tang
 * @date: 2018/5/24.
 * @className:
 * @classFunction:
 */
public class RxImei {
    public static String getImei() {
        String imeiSIM1 = null;
        int permissionCheck = ContextCompat.checkSelfPermission(RxTool.getContext(), Manifest.permission.READ_PHONE_STATE);
        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
            CTelephoneInfo telephonyInfo = CTelephoneInfo.getInstance(RxTool.getContext());
            telephonyInfo.setCTelephoneInfo();
            imeiSIM1 = telephonyInfo.getImeiSIM1();
        }
        return imeiSIM1;
    }

    public static String getAllImei(){
        CTelephoneInfo telephonyInfo = CTelephoneInfo.getInstance(RxTool.getContext());
        telephonyInfo.setCTelephoneInfo();
        if (TextUtils.isEmpty(telephonyInfo.getImeiSIM2())){
            return telephonyInfo.getImeiSIM1();
        }
        return telephonyInfo.getImeiSIM1()+","+telephonyInfo.getImeiSIM2();
    }

    public static String getImei2() {
        CTelephoneInfo telephonyInfo = CTelephoneInfo.getInstance(RxTool.getContext());
        telephonyInfo.setCTelephoneInfo();
        return telephonyInfo.getImeiSIM2();
    }
}
