package com.kryzcorp.kryzaleasus.fcf.controllers;

/**
 * Created by KryzAleAsus on 26/6/2017.
 */
import com.kryzcorp.kryzaleasus.fcf.interfaces.IApplicationListener;
import com.kryzcorp.kryzaleasus.fcf.interfaces.IRetrieveUserData;
import com.kryzcorp.kryzaleasus.fcf.models.FacebookProvider;
import com.kryzcorp.kryzaleasus.fcf.models.UserLogged;

public class MainController {

    private UserLogged mUserLogged;

    public MainController(final IApplicationListener applicationListener){

        FacebookProvider.getInstance().retrieveUserData(new IRetrieveUserData() {
            @Override
            public void onRetrieveDataSuccess(UserLogged userLogged) {

                MainController.this.mUserLogged = userLogged;

                applicationListener.onTaskCompleted();
            }

            @Override
            public void onFailedToRetrieveData(String error) {

                applicationListener.onFailedToCompleteTask(error);
            }
        });

    }

    public void logOut(){

        FacebookProvider.getInstance().logOut();
    }

    public String getUserName(){

        if ( this.mUserLogged != null )
            return this.mUserLogged.getName();

        return null;
    }

    public String getUserPhoto(){

        if ( this.mUserLogged != null)
            return this.mUserLogged.getUrlPhoto();

        return null;
    }
}