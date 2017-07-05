package ml.blueberry.lingwebview.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.backends.pipeline.Fresco;

import ml.blueberry.lingwebview.R;

/**
 * Created by Administrator on 2017/7/5.
 */

public class MyFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Fresco.initialize(getActivity());//初始化框架
        View fragment_my = inflater.inflate(R.layout.fragment_my, container, false);
        return fragment_my;
    }

}
