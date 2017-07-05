package ml.blueberry.lingwebview.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import ml.blueberry.lingwebview.R;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void lingtest(View view) {
        Intent intent = new Intent(MainActivity.this,ShowMoreActivity.class);
        startActivity(intent);

    }
}
