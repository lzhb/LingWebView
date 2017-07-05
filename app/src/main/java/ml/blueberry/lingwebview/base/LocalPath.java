package ml.blueberry.lingwebview.base;

import android.os.Environment;

/**
 * Created by Administrator on 2017/7/5.
 */

public class LocalPath {

    public static  String ROOT = Environment.getExternalStorageDirectory().getAbsolutePath() + "/lingWebView";
    public static  String VR_TEST = ROOT + "/vr_test";

    public static  String VR_AVATAR = ROOT + "/avatar";

    public static  String ACCOUNT = ROOT + "/account";

    public static String AVATAR_PHOTO = ROOT + "/avatar/陪伴星球VR";

}
