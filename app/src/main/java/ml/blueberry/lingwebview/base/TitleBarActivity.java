package ml.blueberry.lingwebview.base;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import ml.blueberry.lingwebview.R;

/**
 * Created by Administrator on 2017/7/5.
 */

public abstract class TitleBarActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initTitleBar();

    }


    protected abstract String title();

    protected void initTitleBar() {
        String title = title();
        TextView titleTV = (TextView)findViewById(R.id.title);
        if(TextUtils.isEmpty(title)) {
            titleTV.setVisibility(View.GONE);
        } else {
            titleTV.setText(title);
            titleTV.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });
        }

    }

    @Override
    protected void onDestroy() {

        super.onDestroy();
    }


}
