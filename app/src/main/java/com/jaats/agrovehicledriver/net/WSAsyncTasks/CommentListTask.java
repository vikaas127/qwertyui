package com.jaats.agrovehicledriver.net.WSAsyncTasks;

import android.os.AsyncTask;

import java.util.HashMap;

import com.jaats.agrovehicledriver.model.CommentListBean;
import com.jaats.agrovehicledriver.net.invokers.CommentListInvoker;

/**
 * Created by Jemsheer K D on 19 May, 2017.
 * Package com.jaats.agrovehicledriver.net.WSAsyncTasks
 * Project LaTaxiDriver
 */

public class CommentListTask extends AsyncTask<String, Integer, CommentListBean> {

    private CommentListTaskListener commentListTaskListener;

    private HashMap<String, String> urlParams;

    public CommentListTask(HashMap<String, String> urlParams) {
        super();
        this.urlParams = urlParams;
    }

    @Override
    protected CommentListBean doInBackground(String... params) {
        System.out.println(">>>>>>>>>doInBackground");
        CommentListInvoker commentListInvoker = new CommentListInvoker(urlParams, null);
        return commentListInvoker.invokeCommentListWS();
    }

    @Override
    protected void onPostExecute(CommentListBean result) {
        super.onPostExecute(result);
        if (result != null)
            commentListTaskListener.dataDownloadedSuccessfully(result);
        else
            commentListTaskListener.dataDownloadFailed();
    }

    public static interface CommentListTaskListener {
        void dataDownloadedSuccessfully(CommentListBean commentListBean);

        void dataDownloadFailed();
    }

    public CommentListTaskListener getCommentListTaskListener() {
        return commentListTaskListener;
    }

    public void setCommentListTaskListener(CommentListTaskListener commentListTaskListener) {
        this.commentListTaskListener = commentListTaskListener;
    }
}
