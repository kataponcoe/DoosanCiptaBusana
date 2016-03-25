package id.kataponcoe.doosanciptabusana;

import java.util.List;

import android.R;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ListAdapter extends BaseAdapter 
{
	List<String> menu;
	
	public ListAdapter(List<String> listMenu) {
		this.menu = listMenu;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		final ViewHolder holder;

        if (convertView == null)
        {
            convertView = View.inflate(parent.getContext(),, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) convertView.getTag();
        }
        
        return convertView;
	}
	
	class ViewHolder
	{
		public TextView menuName; 
		
		public ViewHolder(View v) {
			menuName = (TextView) v.findViewById(R.id.row)
		}
	}

}
