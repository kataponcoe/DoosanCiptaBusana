/*
Copyright 2016 Arief Wardhana

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at
 
   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */

package id.kataponcoe.doosanciptabusana;

import id.kataponcoe.doosanciptabusana.ListAdapter.ListAction;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class MainActivity extends Activity {
	
	private final String SEJARAH_DOOSAN_CIPTA = "Sejarah Doosan Cipta";
	private final String ISTILAH_KAMUS_GARMENT = "Istilah Kamus Garment";
	private final String LOKASI_DOOSAN_CIPTA = "Letak Peta Doosan Cipta";
	private final String LOKASI_SMK_TELESANDI_BEKASI = "Letak Peta SMK Telesandi bekasi";
	private final String WEB_TELESANDI = "Situs Resmi SMK Telesandi bekasi";
	private final String TENTANG_APLIKASI = "Tentang Aplikasi";
	private final String TENTANG_PENGEMBANG = "Tentang Pengembang";
	private final String KELUAR = "Keluar";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);
		ListView list = (ListView)findViewById(R.id.list_item);
		ListAdapter adapter = new ListAdapter(getData());
		adapter.setOnListActionClicked(new ListAction() {
			
			@Override
			public void openMenu(String menuName) {
				startActivity(menuName);
			}
		});
		list.setAdapter(adapter);
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
				 finish();
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

	private void startActivity(String menuList)
	{   
		switch (menuList) {
		case SEJARAH_DOOSAN_CIPTA: startActivity(new Intent(MainActivity.this, FlipSejarahDoosan.class)); break;
		case ISTILAH_KAMUS_GARMENT: startActivity(new Intent(MainActivity.this, FlipKamusGarment.class)); break;
		case LOKASI_DOOSAN_CIPTA: startActivity(new Intent(MainActivity.this, MapsDoosan.class)); break;
		case LOKASI_SMK_TELESANDI_BEKASI: startActivity(new Intent(MainActivity.this, MapsTels.class)); break;
		case WEB_TELESANDI: startActivity(new Intent(MainActivity.this, WebsiteTelesandi.class)); break;
		case TENTANG_APLIKASI: startActivity(new Intent(MainActivity.this, TentangAplikasi.class)); break;
		case TENTANG_PENGEMBANG: startActivity(new Intent(MainActivity.this, TentangPengembang.class)); break;
		default: finish(); break;
		}
	}
  
  
  private List<String> getData() 
  {
    List<String> data = new ArrayList<String>();  
    data.add(SEJARAH_DOOSAN_CIPTA);
    data.add(ISTILAH_KAMUS_GARMENT);
    data.add(LOKASI_DOOSAN_CIPTA);
    data.add(LOKASI_SMK_TELESANDI_BEKASI);
    data.add(WEB_TELESANDI);
    data.add(TENTANG_APLIKASI);
    data.add(TENTANG_PENGEMBANG);
    data.add(KELUAR);
    
    return data;
  }

}
