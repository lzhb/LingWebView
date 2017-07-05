package ml.blueberry.lingwebview.ui;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import ml.blueberry.lingwebview.R;

/**
 * Created by Administrator on 2017/7/5.
 */

public class ActivitiesFragment extends Fragment {
    private WebView webView;
    private WebSettings settings;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View fragment_faq = inflater.inflate(R.layout.fragment_faq, container, false);
        webView = (WebView) fragment_faq.findViewById(R.id.webView_faq);

        return fragment_faq;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        init();
    }

    private void init() {
        settings = webView.getSettings();
        //        settings.setJavaScriptEnabled(true);
        settings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);

        webView.loadUrl("http://sogou.com");
        //使网页用WebView打开
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // TODO Auto-generated method stub
                //返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
                view.loadUrl(url);
                return true;
            }
        });
    }
    public WebView getWebView() {
        return webView;
    }
}
