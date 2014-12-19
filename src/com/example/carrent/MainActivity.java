package com.example.carrent;

import java.util.ArrayList;

import android.app.ActionBar;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends FragmentActivity {
	
	private ArrayList<Fragment> list = null;
	
	private ViewPager mViewPager;
	
	private ImageView iv_bottom_line;
	
	private Resources resources;
	
	private TextView one;
	
	private TextView two;
	
	private TextView three;
	
	private TextView four;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ActionBar actionBar = getActionBar();
		
		Resources r = getResources();
	
		Drawable myDrawable = r.getDrawable(R.drawable.bcd);
		
		actionBar.setBackgroundDrawable(myDrawable);		//…Ë÷√ActionBar±≥æ∞…´
		
		
		initView();
		
		initWidth();
		
		initViewPager();
		
	}


	private void initViewPager() {
		Fragment one = MyFragment.newInstance(Contents.A);
		Fragment two = MyFragment.newInstance(Contents.B);
		Fragment three = MyFragment.newInstance(Contents.C);
		Fragment four = MyFragment.newInstance(Contents.D);
		
		
		list = new ArrayList<Fragment>();
		
		list.add(one);
		list.add(two);
		list.add(three);
		list.add(four);
		
		mViewPager.setAdapter(new FragmentAdapter(getSupportFragmentManager(),list));
		mViewPager.setCurrentItem(0);
		mViewPager.setOnPageChangeListener(new MyViewPagerChangedListener());
		
		
	}
	
	private void initView(){
		mViewPager = (ViewPager) findViewById(R.id.myviewpager);
		iv_bottom_line = (ImageView) findViewById(R.id.iv_bottom_line);
		one = (TextView) findViewById(R.id.one);
		two = (TextView) findViewById(R.id.two);
		three = (TextView) findViewById(R.id.three);
		four = (TextView) findViewById(R.id.four);
		
		one.setOnClickListener(new MyClickListener(0));
		two.setOnClickListener(new MyClickListener(1));
		three.setOnClickListener(new MyClickListener(2));
		four.setOnClickListener(new MyClickListener(3));
		
	}
	
	private int first = 0;
	private int second = 0;
	private int third = 0;
	
	private void initWidth(){
		int lineWidth = iv_bottom_line.getLayoutParams().width;
		Log.d("lineWidth ", lineWidth + "");
		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		int width = dm.widthPixels;
		
		resources = getResources();
		
		first = width /4;
		second = first * 2;
		third = first * 3;
		
	}
	
	private int currPosition = 0; 
	
	class MyViewPagerChangedListener implements OnPageChangeListener{

		@Override
		public void onPageScrollStateChanged(int arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onPageSelected(int arg0) {
			Log.d("onchanged", "onchanged " + arg0);
			TranslateAnimation ta = null;
			switch (arg0) {
			case 0:
				one.setTextColor(Color.WHITE);
				two.setTextColor(Color.GRAY);
				 three.setTextColor(Color.GRAY);
				 four.setTextColor(Color.GRAY);
				if (currPosition == 1) {
					ta = new TranslateAnimation(first, 0, 0, 0);
				}
				if (currPosition == 2) {
					ta = new TranslateAnimation(second, 0, 0, 0);
				}
				if (currPosition == 3) {
					ta = new TranslateAnimation(third, 0, 0, 0);
				}
				
				break;
				
			case 1:
				two.setTextColor(Color.WHITE);
				one.setTextColor(Color.GRAY);
				 three.setTextColor(Color.GRAY);
				 four.setTextColor(Color.GRAY);
				if (currPosition == 0) {
					ta = new TranslateAnimation(0, first, 0, 0);
				}
				if (currPosition == 2) {
					ta = new TranslateAnimation(second, first, 0, 0);
				}
				if (currPosition == 3) {
					ta = new TranslateAnimation(third, first, 0, 0);
				}
				
				break;
				
			case 2:
				three.setTextColor(Color.WHITE);
				one.setTextColor(Color.GRAY);
				 two.setTextColor(Color.GRAY);
				 four.setTextColor(Color.GRAY);
				
								if (currPosition == 0) {
					ta = new TranslateAnimation(0, second, 0, 0);
				}
				if (currPosition == 1) {
					ta = new TranslateAnimation(first, second, 0, 0);
				}
				if (currPosition == 3) {
					ta = new TranslateAnimation(third, second, 0, 0);
				}
				break;
				
			case 3:
				four.setTextColor(Color.WHITE);
				one.setTextColor(Color.GRAY);
				 three.setTextColor(Color.GRAY);
				 two.setTextColor(Color.GRAY);
				if (currPosition == 0) {
					ta = new TranslateAnimation(0, third, 0, 0);
				}
				if (currPosition == 1) {
					ta = new TranslateAnimation(first, third, 0, 0);
				}
				if (currPosition == 2) {
					ta = new TranslateAnimation(second, third, 0, 0);
				}
				break;

				
			}
			
			currPosition = arg0;
			
			ta.setDuration(300);
			ta.setFillAfter(true);
			iv_bottom_line.startAnimation(ta);
		}
		protected void resetTextView(){
			 one.setTextColor(Color.GRAY);
			 two.setTextColor(Color.GRAY);
			 three.setTextColor(Color.GRAY);
			 four.setTextColor(Color.GRAY);
			   }
	}
	
	class MyClickListener implements OnClickListener{
		
		private int index =0;
		
		public MyClickListener (int i){
			index = i;
		}

		@Override
		public void onClick(View v) {
			mViewPager.setCurrentItem(index);
			
		}
		
	}

}
