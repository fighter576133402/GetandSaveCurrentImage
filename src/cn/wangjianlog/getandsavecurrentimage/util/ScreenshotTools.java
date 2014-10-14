package cn.wangjianlog.getandsavecurrentimage.util;

import java.io.File;

import android.app.Activity;
import android.content.Context;
import android.os.Environment;
import cn.wangjianlog.androidtools.util.BitmapUtil;
import cn.wangjianlog.androidtools.util.SDCardUtil;
import cn.wangjianlog.androidtools.util.SystemUtil;

/**
 * 
 * @author WangJian
 *
 */
public class ScreenshotTools {
	public static long minSizeSDcard = 50;     
	  public static String filePath = Environment.getExternalStorageDirectory()     
	      + "/FJBICache";     
	  public static String fileName = "chart.png";     
	  public static String detailPath = filePath + File.separator + fileName;     
	  public static final int SEND_EMAIL = 1;     
	  /**    
	    *       
	    * 截屏并发送邮件    
	    *       
	    * @author WangJian    
	    * **/     
	  public static void takeScreenShotToEmail(Context context, Activity a) {     
	    if (SDCardUtil.getAvailableSDcard(context)) {     
	      BitmapUtil.savePic(SystemUtil.takeScreenShot(a), filePath, fileName);     
	      SystemUtil.sendEmail(context, null, null, null, detailPath);     
	    }     
	  }     
	  
}
