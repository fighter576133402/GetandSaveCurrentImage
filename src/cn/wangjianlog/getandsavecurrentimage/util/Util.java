package cn.wangjianlog.getandsavecurrentimage.util;

import java.io.File;
import java.io.FileOutputStream;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Rect;
import android.os.Environment;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

public class Util {
    public static void GetandSaveCurrentImage(Activity activity)
    {
    	/**
    	//1.构建Bitmap
    	WindowManager windowManager = activity.getWindowManager();
    	Display display = windowManager.getDefaultDisplay();
    	int w = display.getWidth();
    	int h = display.getHeight();
    	
    	Bitmap Bmp = Bitmap.createBitmap( w, h, Config.ARGB_8888 );    
    	
    	//2.获取屏幕
    	View decorview = activity.getWindow().getDecorView(); 
    	decorview.setDrawingCacheEnabled(true); 
    	Bmp = decorview.getDrawingCache(); 
		*/
    	/************************************************************************************/
    	View views = activity.getWindow().getDecorView(); 
    	views.buildDrawingCache(); 
    	 
        // 获取状态栏高度 
        Rect frames = new Rect(); 
        views.getWindowVisibleDisplayFrame(frames); 
        int statusBarHeights = frames.top; 
        Display display2 = activity.getWindowManager().getDefaultDisplay(); 
        int widths = display2.getWidth(); 
        int heights = display2.getHeight(); 
        //第一种方式      
        views.layout(0, statusBarHeights,widths, heights - statusBarHeights); 
        views.setDrawingCacheEnabled(true);//允许当前窗口保存缓存信息 ，两种方式都需要加上 
        Bitmap bmp = Bitmap.createBitmap(views.getDrawingCache()); 
        //第二种方式      
        // 1、source 位图  2、X x坐标的第一个像素  3、Y y坐标的第一个像素  4、宽度的像素在每一行  5、高度的行数 
        //Bitmap bmp = Bitmap.createBitmap(views.getDrawingCache(), 0, statusBarHeights,widths, heights - statusBarHeights); 
    	//3.保存Bitmap 
    	try {
    		String folder = getSDPath()+ "screen";
    		File path = new File(folder);
    		//文件
    	    String filepath = folder + "/Screen_1.png";
    		File file = new File(filepath);
    		if(!path.exists()){
    			path.mkdirs();
    		}
    		if (!file.exists()) {
    			file.createNewFile();
    		}
    		
    		FileOutputStream fos = null;
    		fos = new FileOutputStream(file);
    		if (null != fos) {
    			bmp.compress(Bitmap.CompressFormat.PNG, 90, fos);
        		fos.flush();
        		fos.close();  
        		
            	Toast.makeText(activity, "截屏文件已保存至SDCard/screen/ScreenImage/下", Toast.LENGTH_LONG).show();
    		}

    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    /**
	 * 得到SD卡路径
	 */
	public static String getSDPath() {
		return Environment.getExternalStorageDirectory() + "/";
	}
}
