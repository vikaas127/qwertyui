package com.jaats.agrovehicledriver.listeners;

import com.jaats.agrovehicledriver.model.HelpBean;

/**
 * Created by Jemsheer K D on 20 May, 2017.
 * Package com.jaats.agrovehicledriver.listeners
 * Project LaTaxiDriver
 */

public interface HelpListener {
    void onLoadCompleted(HelpBean helpBean);

    void onLoadFailed(String error);
}
