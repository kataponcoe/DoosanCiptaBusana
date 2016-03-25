package id.kataponcoe.doosanciptabusana;
 
import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebsiteTelesandi extends Activity {

	private WebView websiteTelesandi;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTitle("Situs SMK Telesandi");
		setContentView(R.layout.peta);
		// WebView
		this.websiteTelesandi = (WebView) findViewById(R.id.webview);
		WebSettings webSettings = websiteTelesandi.getSettings();
		webSettings.setJavaScriptEnabled(true);
		websiteTelesandi.loadUrl("http://www.smktelekomunikasitelesandi.sch.id");
		websiteTelesandi.setWebViewClient(new HelloWebViewClient());
	}

	private class HelloWebViewClient extends WebViewClient {
		@Override
		public boolean shouldOverrideUrlLoading(WebView webView, String url) {
			webView.loadUrl(url);
			return true;
		}
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event){
		if(keyCode == KeyEvent.KEYCODE_BACK && websiteTelesandi.canGoBack()){
			websiteTelesandi.goBack();
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}
}
