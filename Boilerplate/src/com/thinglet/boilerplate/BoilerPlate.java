package com.thinglet.boilerplate;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;

public class BoilerPlate extends Activity {

	WebView mWebView;

	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		
		mWebView=new WebView(this);
		
		mWebView.getSettings().setAllowFileAccess(true);
		mWebView.getSettings().setJavaScriptEnabled(true);
		mWebView.addJavascriptInterface(new JavaScriptInterface(), "android");
		mWebView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
		mWebView.loadUrl("file:///android_asset/www/index.html");
		
		setContentView(mWebView);
	
	}
	
	public boolean onKeyDown(int keyCode, KeyEvent event) {

		if ((keyCode == KeyEvent.KEYCODE_BACK) && mWebView.canGoBack()) {

			mWebView.goBack();            
			return true;

		}

		return super.onKeyDown(keyCode, event);

	}

	final class JavaScriptInterface {

		JavaScriptInterface () { }
	
		public String getSomeString() {

			return "string";

		}
	
	}
    
}