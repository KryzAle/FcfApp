package com.kryzcorp.kryzaleasus.fcf.controllers;

import android.content.Intent;

import com.kryzcorp.kryzaleasus.fcf.interfaces.IApplicationListener;
import com.kryzcorp.kryzaleasus.fcf.models.FacebookProvider;
/**
 * Created by KryzAleAsus on 26/6/2017.
 */

public class LoginController {

    public LoginController(){

    }

    public void initializeLoginProvider(IApplicationListener applicationListener){

        FacebookProvider.getInstance().initialize(applicationListener);

    }

    public void onActivityResult( int request_code, int result_code, Intent data){

        FacebookProvider.getInstance().onActivityResult(request_code,result_code,data);
    }
}