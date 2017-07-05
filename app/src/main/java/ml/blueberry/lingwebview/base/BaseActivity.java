package ml.blueberry.lingwebview.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.Window;

import ml.blueberry.lingwebview.util.LogUtils;
import ml.blueberry.lingwebview.util.ToastUtil;

/**
 * Created by Administrator on 2017/7/5.
 */

public abstract class BaseActivity extends TopActivity {
    private ProgressDialog mProgressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initView();
        initData();
    }


    protected abstract int getLayoutId();
    protected abstract void initView();
    protected abstract void initData();


    public FragmentActivity getActivity() {
        return this;
    }

    protected void getDataSuccessed(int flag, Object object) {}
    protected void getDataFailed(int flag, String errMsg) {}
    protected void getDataFailed(int flag, int err, String errMsg) {
        if(!TextUtils.isEmpty(errMsg)) {
            ToastUtil.Short(this, errMsg);
        }
    }
    protected void getProgess(int progress, int totalProgress) {}

//    protected Handler mHandler = new Handler(new Handler.Callback() {
//
//        @Override
//        public boolean handleMessage(Message msg) {
//
//            switch (msg.what) {
//                case Command.MSG_SUCCESSED:
//                    getDataSuccessed(msg.arg1, msg.obj);
//                    break;
//                case Command.MSG_FAILED:
//                    getDataFailed(msg.arg1, (String)msg.obj);
//                    getDataFailed(msg.arg1, msg.arg2, (String)msg.obj);
//                    break;
//                case Command.MSG_PROGRESS_UPDATED:
//                    getProgess(msg.arg1, msg.arg2);
//                    break;
//                default:
//                    break;
//            }
//            handleOtherThings(msg);
//            return false;
//        }
//    });
//
//    protected void handleOtherThings(Message msg) {
//        if(msg.what <= Command.MSG_PROGRESS_UPDATED) {
//            return;
//        }
//    }


    @Override
    protected void onRestart() {
        super.onRestart();

    }

    @Override
    protected void onResume() {
        super.onResume();
        //		FloatWindow.hideFolatWindow();
//        if(PreferenceUtils.instance().contains(PreferenceUtils.PrefrenceKeys.INFOMATION) && !Info.getInstance().hasLogin()) {
//            Info.getInstance().initInfo();
//        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        hideSavingDialog();
    }

    @Override
    public void finish() {
        hideSavingDialog();
        super.finish();
//        mHandler.removeCallbacksAndMessages(null);
//        overridePendingTransition(R.anim.still_when_right, R.anim.roll_left);
    }

    protected void showSavingDialog(int resStringId) {
        showSavingDialog(getString(resStringId));
    }

    protected synchronized void showSavingDialog(final String msg) {
        if (isFinishing()) {
            return;
        }
        LogUtils.d("BaseActivity", "showSavingDialog");
        try {
            if (mProgressDialog == null) {
                mProgressDialog = ProgressDialog.show(BaseActivity.this, null, msg, true, true);
            }
            if (mProgressDialog.getWindow() != null && !mProgressDialog.isShowing()) {
                mProgressDialog.setCancelable(false);
                mProgressDialog.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected synchronized void hideSavingDialog() {
        if (!isFinishing() && mProgressDialog != null && mProgressDialog.getWindow() != null && mProgressDialog.isShowing()) {
            try {
                LogUtils.d("BaseActivity", "hideSavingDialog");
                mProgressDialog.dismiss();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }



}
