package com.example.android.simpleasynctask;

import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.Random;

public class SimpleAsyncTask extends AsyncTask <Void, Integer, String>{
    private WeakReference<TextView> mTextView;
    private WeakReference<ProgressBar> mProgressBar;

    SimpleAsyncTask(TextView tv, ProgressBar pb) {
        mTextView = new WeakReference<>(tv);
        mProgressBar = new WeakReference<>(pb);
    }

    @Override
    protected void onProgressUpdate (Integer... values) {
//        String str = "Awake at last after sleeping for " + values[0].intValue() + " seconds!";
//        mTextView.get().setText(str);
        mProgressBar.get().setProgress(values[0]);
    }

    @Override
    protected String doInBackground(Void... voids) {
        Random r = new Random();
        int n = r.nextInt(11);

        for(int i = 0; i < n; i++) {
            try {
                Thread.sleep(1000);
                int progress = Math.round(i * 100 / n);
                publishProgress(progress);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "Awake at last after sleeping for " + n + " seconds!";
    }

    protected void onPostExecute(String result) {
        mProgressBar.get().setVisibility(View.GONE);
        mTextView.get().setText(result);
    }
}
