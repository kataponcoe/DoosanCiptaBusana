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

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import id.kataponcoe.doosanciptabusana.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		SimpleAdapter adapter = new SimpleAdapter(this, getData(),
				android.R.layout.simple_list_item_1, new String[] { "title" },
				new int[] { android.R.id.text1 });
		setListAdapter(adapter);
		getListView().setScrollbarFadingEnabled(false);
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

  @SuppressWarnings("unchecked")
  @Override
  protected void onListItemClick(ListView l, View v, int position, long id) {
    Map<String, Object> map = (Map<String, Object>) l.getItemAtPosition(position);
    Intent intent = new Intent(this, (Class<? extends Activity>) map.get("activity"));
    startActivity(intent);
  }

  private List<? extends Map<String, ?>> getData() {
    List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
    addItem(data, "Sejarah Doosan Cipta", FlipSejarahDoosan.class);
    addItem(data, "Istilah Kamus Garment", FlipKamusGarment.class);
    addItem(data, "Letak Peta Doosan Cipta", MapsDoosan.class);
    addItem(data, "Letak Peta SMK Telesandi bekasi", MapsTels.class);
    addItem(data, "Situs Resmi SMK Telesandi bekasi", WebsiteTelesandi.class);
    addItem(data, "Tentang Aplikasi", TentangAplikasi.class);
    addItem(data, "Tentang Pengembang", TentangPengembang.class);
    addItem(data, "Keluar", MenuLogin.class);
    
    return data;
  }

  private void addItem(List<Map<String, Object>> data, String title,
                       Class<? extends Activity> activityClass) {
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("title", data.size() + ". " + title);
    map.put("activity", activityClass);
    data.add(map);
  }
}
