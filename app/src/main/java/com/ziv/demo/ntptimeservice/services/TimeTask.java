package com.ziv.demo.ntptimeservice.services;

import android.os.SystemClock;
import android.util.Log;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import static com.ziv.demo.ntptimeservice.MainActivity.TAG;

public class TimeTask implements Runnable {
    private long ntpTime;

    public void setNtpTime(long ntpTime) {
        this.ntpTime = ntpTime;
    }

    private static final String TAG = "TimeTask";
    private String[] ntpServerPool = {"ntp1.aliyun.com", "ntp2.aliyun.com", "ntp3.aliyun.com", "ntp4.aliyun.com", "ntp5.aliyun.com", "ntp6.aliyun.com", "ntp7.aliyun.com",
            "cn.pool.ntp.org", "cn.ntp.org.cn", "sg.pool.ntp.org", "tw.pool.ntp.org", "jp.pool.ntp.org", "hk.pool.ntp.org", "th.pool.ntp.org",
            "time.windows.com", "time.nist.gov", "time.apple.com", "time.asia.apple.com",
            "dns1.synet.edu.cn", "news.neu.edu.cn", "dns.sjtu.edu.cn", "dns2.synet.edu.cn", "ntp.glnet.edu.cn", "s2g.time.edu.cn",
            "ntp-sz.chl.la", "ntp.gwadar.cn", "3.asia.pool.ntp.org"};

    public long getNtpTime() {
        return ntpTime;
    }


    @Override
    public void run() {
        SntpClient sntpClient = new SntpClient();
        for (String serverHost : ntpServerPool) {
            if (sntpClient.requestTime(serverHost, 30000)) {
//                long ntpTime = sntpClient.getNtpTime();
                setNtpTime(sntpClient.getNtpTime());
                long elapsedRealtime = SystemClock.elapsedRealtime();
                long ntpTimeReference = sntpClient.getNtpTimeReference();
                long now = sntpClient.getNtpTime() + SystemClock.elapsedRealtime() - sntpClient.getNtpTimeReference();
                Log.d(TAG, String.format("Host:%s -> ntpTime = %s, elapsedRealtime = %s, ntpTimeReference = %s.", serverHost, ntpTime, elapsedRealtime, ntpTimeReference));
                Log.d(TAG, "run: NowTime" + now);
                Date current = new Date(now);
                Log.d(TAG, current.toString());
            }
        }
    }
}








