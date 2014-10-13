package cn.wangjianlog.getandsavecurrentimage;

import cn.wangjianlog.getandsavecurrentimage.util.ScreenshotTools;
import cn.wangjianlog.getandsavecurrentimage.util.Util;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;


public class MainActivity extends ActionBarActivity implements OnTouchListener{
	private Button get_screen_pic;
	private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        get_screen_pic = (Button) findViewById(R.id.get_screen_pic);
        get_screen_pic.setOnTouchListener(this);
        mContext = this;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


	@Override
	public boolean onTouch(View v, MotionEvent event) {
		
		int action = event.getAction();
		switch (action) {
		case MotionEvent.ACTION_UP:
//			Util.GetandSaveCurrentImage(MainActivity.this);
			ScreenshotTools.takeScreenShotToEmail(mContext, MainActivity.this);     
			break;

		default:
			break;
		}
		return false;
	}
}
