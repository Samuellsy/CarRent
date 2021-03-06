package com.example.carrent;

import java.util.List;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyListViewAdapter extends BaseAdapter {

	List<String>list;
	
	LayoutInflater inflater;
	
	FragmentActivity activity;
	
	public MyListViewAdapter(FragmentActivity fragmentActivity, List<String> list) {
		this.list = list;
		this.activity = fragmentActivity;
		inflater = (LayoutInflater) fragmentActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Object getItem(int arg0) {
		return list.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		return arg0;
	}

	@Override
	public View getView(int arg0, View view, ViewGroup arg2) {
		if (view == null) {
			view = inflater.inflate(R.layout.item, null);
		} 
		
		
		return view;
	}
	
	class ViewHolder {
		TextView tv;
		ImageView im;
	}

}
