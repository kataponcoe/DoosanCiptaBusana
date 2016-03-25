package id.kataponcoe.doosanciptabusana;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import kataponcoe.flip.horizontal.FlipViewController;
import kataponcoe.flip.horizontal.KamusGarmentAdapter;
import id.kataponcoe.doosanciptabusana.R;

public class FlipKamusGarment extends Activity {

  private FlipViewController flipView;

  /**
   * Called when the activity is first created.
   */
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setTitle("Kamus Garment");

    flipView = new FlipViewController(this, FlipViewController.HORIZONTAL);

    flipView.setAdapter(new KamusGarmentAdapter(this));

    setContentView(flipView);
  }
  
  @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(0, 0, 0, R.string.tntngapp);
		menu.add(0, 1, 1, R.string.tntngpengembang);
		menu.add(0, 2, 2, R.string.keluar);
		return super.onCreateOptionsMenu(menu);
		}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		super.onOptionsItemSelected(item);
			switch(item.getItemId()){
			case 0 :
            tentangAplikasi();
            break;

			case 1:
				tentangPengembang();
				break;
              
			case 2:
				 startActivity(new Intent(this, MenuLogin.class));
				break;

        default:
            return super.onOptionsItemSelected(item);
    }
			return false;
}
	
	private void tentangAplikasi(){
		new AlertDialog.Builder(this)
			.setTitle(R.string.tntang_title)
			.setMessage(R.string.tntang_isi)
			.setPositiveButton("OK",new DialogInterface.OnClickListener(){	
				public void onClick(DialogInterface dialoginterface, int i){}
				}) .show();
			}
	private void tentangPengembang(){
		new AlertDialog.Builder(this)
			.setTitle(R.string.tntangdev_title)
			.setMessage(R.string.tntangdev_isi)
			.setPositiveButton("OK",new DialogInterface.OnClickListener(){	
				public void onClick(DialogInterface dialoginterface, int i){}
				}) .show();
			}

  @Override
  protected void onResume() {
    super.onResume();
    flipView.onResume();
  }

  @Override
  protected void onPause() {
    super.onPause();
    flipView.onPause();
  }
}
