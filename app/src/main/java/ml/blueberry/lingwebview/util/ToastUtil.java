package ml.blueberry.lingwebview.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by lzb on 2017/7/5.
 */

public class ToastUtil {
    public static void Long(Context context, String s){
        Toast.makeText(context, s, Toast.LENGTH_LONG).show();
    }

    public static void Long(Context context, int sid){
        Toast.makeText(context, sid, Toast.LENGTH_LONG).show();
    }

    public static void Short(Context context, String s){
        Toast.makeText(context, s, Toast.LENGTH_SHORT).show();
    }

    public static void Short(Context context, int sid){
        Toast.makeText(context, sid, Toast.LENGTH_SHORT).show();
    }
}
