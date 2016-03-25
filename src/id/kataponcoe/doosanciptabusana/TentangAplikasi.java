package id.kataponcoe.doosanciptabusana;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
 
public class TentangAplikasi extends Activity {
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Tentang Aplikasi");
        setContentView(R.layout.tentangaplikasi);
 
        alertOneButton();
 
    }
 
    /*
     * AlertDialog with one action button.
     */
    public void alertOneButton() {
 
        new AlertDialog.Builder(TentangAplikasi.this)
                .setTitle(R.string.tntang_title)
                .setMessage(R.string.tntang_isi)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
 
                        dialog.cancel();
                    }
                }).show();
    }
 
}