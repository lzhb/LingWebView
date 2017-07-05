package ml.blueberry.lingwebview.ui;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import ml.blueberry.lingwebview.R;

public class ShowMoreActivity extends FragmentActivity implements View.OnClickListener {
    private TextView txt_activities;
    private TextView txt_faq;
    private TextView txt_questionnaire;
    private TextView txt_my;
    private FrameLayout ly_content;
    private TextView titleTV;
    private ActivitiesFragment mActivitiesFragment;
    private FAQFragment mFAQFragment;
    private QuestionnaireFragment mQuestionnaireFragment;
    private MyFragment mMyFragment;

    private FragmentManager fManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_more);
        fManager = getFragmentManager();

        initView();
    }

    protected void initView() {
        titleTV = (TextView) findViewById(R.id.title);

        txt_activities = (TextView) findViewById(R.id.txt_showmore_activities);
        txt_faq = (TextView) findViewById(R.id.txt_showmore_faq);
        txt_questionnaire = (TextView) findViewById(R.id.txt_questionnaire);
        txt_my = (TextView) findViewById(R.id.txt_showmore_my);
        ly_content = (FrameLayout) findViewById(R.id.ly_content);

        txt_activities.setOnClickListener(this);
        txt_faq.setOnClickListener(this);
        txt_questionnaire.setOnClickListener(this);
        txt_my.setOnClickListener(this);
    }

    private void defaultSelected() {
        txt_activities.setSelected(false);
        txt_faq.setSelected(false);
        txt_questionnaire.setSelected(false);
        txt_my.setSelected(false);
    }

    //隐藏所有Fragment
    private void hideAllFragment(FragmentTransaction fragmentTransaction) {
        if (mActivitiesFragment != null)
            fragmentTransaction.hide(mActivitiesFragment);
        if (mFAQFragment != null)
            fragmentTransaction.hide(mFAQFragment);
        if (mQuestionnaireFragment != null)
            fragmentTransaction.hide(mQuestionnaireFragment);
        if (mMyFragment != null)
            fragmentTransaction.hide(mMyFragment);
    }

    @Override
    public void onClick(View v) {
        FragmentTransaction fTransaction = fManager.beginTransaction();
        hideAllFragment(fTransaction);
        int i = v.getId();
        if (i == R.id.txt_showmore_activities) {
            defaultSelected();
            txt_activities.setSelected(true);
            titleTV.setVisibility(View.VISIBLE);
            titleTV.setText("活动中心");
            if (mActivitiesFragment == null) {
                mActivitiesFragment = new ActivitiesFragment();
                fTransaction.add(R.id.ly_content, mActivitiesFragment);
            } else {
                fTransaction.show(mActivitiesFragment);
            }

        } else if (i == R.id.txt_showmore_faq) {
            defaultSelected();
            txt_faq.setSelected(true);
            titleTV.setVisibility(View.VISIBLE);
            titleTV.setText("常见问题");
            if (mFAQFragment == null) {
                mFAQFragment = new FAQFragment();
                fTransaction.add(R.id.ly_content, mFAQFragment);
            } else {
                fTransaction.show(mFAQFragment);
            }

        } else if (i == R.id.txt_questionnaire) {
            defaultSelected();
            txt_questionnaire.setSelected(true);
            titleTV.setVisibility(View.INVISIBLE);//问卷没有title

            View view=findViewById(R.id.ly_content);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
            layoutParams.setMargins(0,0,0,0);
            view.setLayoutParams(layoutParams);

            if (mQuestionnaireFragment == null) {
                mQuestionnaireFragment = new QuestionnaireFragment();
                fTransaction.add(R.id.ly_content, mQuestionnaireFragment);
            } else {
                fTransaction.show(mQuestionnaireFragment);
            }

        } else if (i == R.id.txt_showmore_my) {
            defaultSelected();
            txt_my.setSelected(true);
            titleTV.setVisibility(View.VISIBLE);
            titleTV.setText("个人资料");
            if (mMyFragment == null) {
                mMyFragment = new MyFragment();
                fTransaction.add(R.id.ly_content, mMyFragment);
            } else {
                fTransaction.show(mMyFragment);
            }

        }
        fTransaction.commit();
    }
    private WebView webView;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if(keyCode==KeyEvent.KEYCODE_BACK)
        {
            if(txt_activities.isSelected()){
                webView=mActivitiesFragment.getWebView();
                if(webView.canGoBack())
                {
                    webView.goBack();//返回上一页面
                    return true;
                }
                else
                {
                    System.exit(0);//退出程序
                }
            }
            if(txt_faq.isSelected()){
                webView=mFAQFragment.getWebView();
                if(webView.canGoBack())
                {
                    webView.goBack();//返回上一页面
                    return true;
                }
                else
                {
                    System.exit(0);//退出程序
                }
            }
            if(txt_questionnaire.isSelected()){
                webView=mQuestionnaireFragment.getWebView();
                if(webView.canGoBack())
                {
                    webView.goBack();//返回上一页面
                    return true;
                }
                else
                {
                    System.exit(0);//退出程序
                }
            }
            if(txt_my.isSelected()){


            }

        }
        return super.onKeyDown(keyCode, event);
    }
}
