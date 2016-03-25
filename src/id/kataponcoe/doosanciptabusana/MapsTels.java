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

public class MapsTels extends Activity {

	private WebView mapsTels;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTitle("Peta SMK Telesandi Bekasi");
		setContentView(R.layout.peta);
		// WebView
		this.mapsTels = (WebView) findViewById(R.id.webview);
		WebSettings webSettings = mapsTels.getSettings();
		webSettings.setJavaScriptEnabled(true);
		mapsTels.loadUrl("https://www.google.com/maps/place/SMK+Telekomunikasi+Telesandi/@-6.2537811,107.0610166,103m/data=!3m1!1e3!4m2!3m1!1s0x0:0x7f0f671bf57691ae!6m1!1e1");
		mapsTels.setWebViewClient(new HelloWebViewClient());
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
		if (keyCode == KeyEvent.KEYCODE_BACK && mapsTels.canGoBack()) {
			mapsTels.goBack();
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
			startActivity(new Intent(this, MainActivity.class));
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
