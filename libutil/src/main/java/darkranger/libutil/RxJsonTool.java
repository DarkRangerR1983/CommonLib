package darkranger.libutil;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

public class RxJsonTool {

    public RxJsonTool() {
    }

    public static String createJSONString(Object object) {
        String str = JSONObject.toJSONString(object,false);
        return str;
    }
    public static <T> T changeJSONToBean(String gsonString, Class<T> cls) {
        T t = JSON.parseObject(gsonString, cls);
        return t;
    }
    public static <T> List<T> changeJSONToList(String gsonString, Class<T> cls) {
        List<T> ts = JSON.parseArray(gsonString, cls);
        return ts;
    }

}
