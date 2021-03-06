package com.ziv.demo.ntptimeservice;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.ziv.demo.ntptimeservice.services.NtpTime;
import com.ziv.demo.ntptimeservice.services.SntpClient;
import com.ziv.demo.ntptimeservice.services.TimeTask;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";
    public TextView textView;


//    private static final String[] DATE_PATTERNS = {
//            "EEE, dd MMM yyyy HH:mm:ss Z", // RFC 822, updated by RFC 1123
//            "EEEE, dd-MMM-yy HH:mm:ss Z", // RFC 850, obsoleted by RFC 1036
//            "EEE MMM d HH:mm:ss yyyy", // ANSI C's asctime() format
//            "EEE MMM dd kk:mm:ss z yyyy" // Local Date Time
//    };
//    private static final TimeZone GMT_ZONE = TimeZone.getTimeZone("GMT");
    /*private String ntpServer = "ntp1.aliyun.com";
    private long ntpTime=0;
    private boolean ntpFlag=false;*/

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

/*        ExecutorService threadExecutor = Executors.newSingleThreadExecutor();
        threadExecutor.submit(timeTask);*/
/*        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                SntpClient sntpClient = new SntpClient();
                sntpClient.requestTime(ntpServer,3000);
                Log.d(TAG, "run:Thread "+sntpClient.getNtpTime());
                ntpTime=sntpClient.getNtpTime();
            }
        });
        thread.start();
        while (!ntpFlag){
            if(ntpTime!=0){
                Log.d(TAG, "onCreate: ???????????????ntp?????????"+ntpTime);
                ntpFlag=true;}
        }*/
        NtpTime ntpTime=new NtpTime();
        Log.d(TAG, "onCreate: "+ntpTime.getNtpTime());


/*        Log.d(TAG, "Date parse start.");
        String time = new Date(1617885471511L).toString();
        String lastModify = "Tue, 19 Nov 2019 11:01:23 GMT";
        Log.d(TAG, "Date time: " + time);
        Date date = parseDate(time);
        Date modifyDate = parseDate(lastModify);

        if (date != null) {
            Log.d(TAG, "Date: " + date.getTime());
            Log.d(TAG, "Date: modifyDate = " + modifyDate.getTime());
        } else {
            Log.e(TAG, "Date parse failed.");
        }
        Log.d(TAG, "Date parse end.");*/
    }

/*    private static Date parseDate(String time) {
        for (String pattern : DATE_PATTERNS) {
            try {
                Log.d(TAG, "DATE_PATTERNS: " + pattern);
                SimpleDateFormat df = new SimpleDateFormat(pattern, Locale.ENGLISH);
                df.setTimeZone(GMT_ZONE);
                return df.parse(time);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return null;
    }*/


}
