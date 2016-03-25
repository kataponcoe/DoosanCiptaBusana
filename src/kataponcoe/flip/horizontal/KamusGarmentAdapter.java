/*
Copyright 2015 Dreamcode Developer

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

package kataponcoe.flip.horizontal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import kataponcoe.flip.horizontal.KamusGarment;
import kataponcoe.flip.horizontal.DebugKataponcoe;
import kataponcoe.flip.horizontal.KataponcoeLog;
import kataponcoe.flip.horizontal.IO;
import kataponcoe.flip.horizontal.UI;
import id.kataponcoe.doosanciptabusana.R;

import java.util.ArrayList;
import java.util.List;

public class KamusGarmentAdapter extends BaseAdapter {

  private LayoutInflater inflater;

  private int repeatCount = 1;

  private List<KamusGarment.Data> travelData;

  public KamusGarmentAdapter(Context context) {
    inflater = LayoutInflater.from(context);
    travelData = new ArrayList<KamusGarment.Data>(KamusGarment.IMG_DESCRIPTIONS);
  }

  @Override
  public int getCount() {
    return travelData.size() * repeatCount;
  }

  public int getRepeatCount() {
    return repeatCount;
  }

  public void setRepeatCount(int repeatCount) {
    this.repeatCount = repeatCount;
  }

  @Override
  public Object getItem(int position) {
    return position;
  }

  @Override
  public long getItemId(int position) {
    return position;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    View layout = convertView;
    if (convertView == null) {
      layout = inflater.inflate(R.layout.flipviewbook, null);
      KataponcoeLog.d("created new view from adapter: %d", position);
    }

    final KamusGarment.Data data = travelData.get(position % travelData.size());

    UI
        .<ImageView>findViewById(layout, R.id.photo)
        .setImageBitmap(IO.readBitmap(inflater.getContext().getAssets(), data.imageFilename));


    return layout;
  }

  public void removeData(int index) {
    if (travelData.size() > 1) {
      travelData.remove(index);
    }
  }
}
