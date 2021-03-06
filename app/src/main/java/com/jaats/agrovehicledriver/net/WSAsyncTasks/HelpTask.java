package com.jaats.agrovehicledriver.net.WSAsyncTasks;

import android.os.AsyncTask;

import java.util.HashMap;

import com.jaats.agrovehicledriver.model.HelpBean;
import com.jaats.agrovehicledriver.net.invokers.HelpInvoker;

/**
 * Created by Jemsheer K D on 20 May, 2017.
 * Package com.jaats.agrovehicledriver.net.WSAsyncTasks
 * Project LaTaxiDriver
 */

public class HelpTask extends AsyncTask<String, Integer, HelpBean> {

    private HelpTaskListener helpTaskListener;

    private HashMap<String, String> urlParams;

    public HelpTask(HashMap<String, String> urlParams) {
        super();
        this.urlParams = urlParams;
    }

    @Override
    protected HelpBean doInBackground(String... params) {
        System.out.println(">>>>>>>>>doInBackground");
        HelpInvoker helpInvoker = new HelpInvoker(urlParams, null);
        return helpInvoker.invokeHelpWS();
    }

    @Override
    protected void onPostExecute(HelpBean result) {
        super.onPostExecute(result);
        if (result != null)
            helpTaskListener.dataDownloadedSuccessfully(result);
        else
            helpTaskListener.dataDownloadFailed();
    }

    public static interface HelpTaskListener {
        void dataDownloadedSuccessfully(HelpBean helpBean);

        void dataDownloadFailed();
    }

    public HelpTaskListener getHelpTaskListener() {
        return helpTaskListener;
    }

    public void setHelpTaskListener(HelpTaskListener helpTaskListener) {
        this.helpTaskListener = helpTaskListener;
    }
}
