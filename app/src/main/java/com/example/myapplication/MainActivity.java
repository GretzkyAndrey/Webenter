package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    private WebView webView;
    private Button find_btn;
    private EditText edit_link;


    @Override
    public File getNoBackupFilesDir() {
        return super.getNoBackupFilesDir();
    }

    @Override
    public <T extends View> T findViewById(int id) {
        return super.findViewById(id);
    }

    String site = "https://monoad.ru/admin/adm.php?mp=zebra_availabil_edit&id=8765";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getWindow().getDecorView().setSystemUiVisibility(

                View.SYSTEM_UI_FLAG_LAYOUT_STABLE

                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION

                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN

                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION

                        | View.SYSTEM_UI_FLAG_FULLSCREEN);


        find_btn = findViewById(R.id.find_btn);
        edit_link = findViewById(R.id.edit_link);
        WebView webView = findViewById(R.id.webView);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(site);
        webView.setWebViewClient(new WebViewClient());
        edit_link.setOnEditorActionListener( new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if( event != null && event.getKeyCode() == KeyEvent.KEYCODE_ENTER){
                    // обработка нажатия Enter
                    String link = edit_link.getText().toString();
                    webView.loadUrl(link);
                    return true;


                }
                return false;
            }
        });


        //find_btn.setOnClickListener(new View.OnClickListener() {
            //@Override
          //  public void onClick(View v) {
              //  String link = edit_link.getText().toString();
                //webView.loadUrl(link);
            //}
        //});





        WebViewClient webViewClient = new WebViewClient() {

            @SuppressWarnings("deprecation") @Override

            public boolean shouldOverrideUrlLoading(WebView view, String url) {

                view.loadUrl(url);

                return true;

            }



            @TargetApi(Build.VERSION_CODES.N) @Override

            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {

                view.loadUrl(request.getUrl().toString());

                return true;

            }

        };
        webView.setWebViewClient(webViewClient);
    }
}