package com.example.speechhelper.relax;

import com.example.speechhelper.R;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ViewSwitcher.ViewFactory;

@SuppressWarnings("deprecation")
public class NightActivity extends Activity implements ViewFactory,OnItemSelectedListener {  
	private Button nightBack;
    ImageSwitcher mSwitcher;  
    private Integer[] mThumbIds = { R.drawable.night_icon};  

    private Integer[] mImageIds = { R.drawable.night_icon};  

    @Override  
    public void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        requestWindowFeature(Window.FEATURE_NO_TITLE);  
        setContentView(R.layout.activity_night);  
        nightBack = (Button) this.findViewById(R.id.nightBack);
        nightBack.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(NightActivity.this,
						MusicActivity.class);
				startActivityForResult(intent, 0);
			}
		});
        mSwitcher = (ImageSwitcher) findViewById(R.id.nightImageSwitcher);   
        mSwitcher.setFactory(this);  
        mSwitcher.setInAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_in));  
        mSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_out));  

        Gallery g = (Gallery) findViewById(R.id.nightGallery);  

        g.setAdapter(new ImageAdapter(this));  
        g.setOnItemSelectedListener(this);  

    }  

    @SuppressWarnings("rawtypes")
	public void onItemSelected(AdapterView parent, View v, int position, long id) {  
        mSwitcher.setImageResource(mImageIds[position]);  
    }  

    @SuppressWarnings("rawtypes")
	public void onNothingSelected(AdapterView parent) {  
    }  


@Override  
    public View makeView() {  
    ImageView i = new ImageView(this);   
    i.setScaleType(ImageView.ScaleType.FIT_CENTER);  
    i.setLayoutParams(new ImageSwitcher.LayoutParams(  
    LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));  
    return i;  
    }  
 
    public class ImageAdapter extends BaseAdapter {  
        private Context mContext;  
        public ImageAdapter(Context c) {  
             mContext = c;  
          }  

    public int getCount() {  
        return mThumbIds.length;  
    }  

   public Object getItem(int position) {  
    return position;  
   }  

   public long getItemId(int position) {  
    return position;  
   }  
  

  @Override
      public View getView(int position, View convertView, ViewGroup parent) {  
        ImageView i = new ImageView(mContext);
        i.setImageResource(mThumbIds[position]);  
        i.setAdjustViewBounds(true);  
        i.setLayoutParams(new Gallery.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));   
        return i;  
    }  

  }  

}  