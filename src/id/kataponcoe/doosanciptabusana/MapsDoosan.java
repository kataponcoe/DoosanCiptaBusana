package id.kataponcoe.doosanciptabusana;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MapsDoosan extends Activity {

	private WebView mapsDoosan;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTitle("Peta PT Doosan Cipta Busana");
		setContentView(R.layout.peta);
		// WebView
		this.mapsDoosan = (WebView) findViewById(R.id.webview);
		WebSettings webSettings = mapsDoosan.getSettings();
		webSettings.setJavaScriptEnabled(true);
		mapsDoosan
				.loadUrl("https://www.google.co.id/maps/place/PT.+DOOSAN+CIPTA+BUSANA/@-6.1421699,106.9286013,795m/data=!3m2!1e3!4b1!4m2!3m1!1s0x2e698aa34da2acff:0x8e661fc58127d899");
		mapsDoosan.setWebViewClient(new HelloWebViewClient());
	}

	private class HelloWebViewClient extends WebViewClient {
		@Override
		public boolean shouldOverrideUrlLoading(WebView webView, String url) {
			webView.loadUrl(url);
			return true;
		}
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK && mapsDoosan.canGoBack()) {
			mapsDoosan.goBack();
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(0, 0, 0, R.string.tntngapp);
		menu.add(0, 1, 1, R.string.tntngpengembang);
		menu.add(0, 2, 2, R.string.kembali);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		super.onOptionsItemSelected(item);
		switch (item.getItemId()) {
		case 0:
			tentangAplikasi();
			break;

		case 1:
			tentangPengembang();
			break;

		case 2:
			//startActivity(new Intent(this, MainActivity.class));
			onBackPressed();
			break;

		default:
			return super.onOptionsItemSelected(item);
		}
		return false;
	}

	private void tentangAplikasi() {
		new AlertDialog.Builder(this).setTitle(R.string.tntang_title)
				.setMessage(R.string.tntang_isi)
				.setPositiveButton("OK", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialoginterface, int i) {
					}
				}).show();
	}

	private void tentangPengembang() {
		new AlertDialog.Builder(this).setTitle(R.string.tntangdev_title)
				.setMessage(R.string.tntangdev_isi)
				.setPositiveButton("OK", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialoginterface, int i) {
					}
				}).show();
	}

	@Override
	public void onBackPressed() {
		finish();
	}
	
	
}