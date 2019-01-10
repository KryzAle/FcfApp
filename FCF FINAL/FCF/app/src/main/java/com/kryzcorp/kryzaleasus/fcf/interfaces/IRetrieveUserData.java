package com.kryzcorp.kryzaleasus.fcf.interfaces;

/**
 * Created by KryzAleAsus on 26/6/2017.
 */
import com.kryzcorp.kryzaleasus.fcf.models.UserLogged;

public interface IRetrieveUserData {

    void onRetrieveDataSuccess(UserLogged userLogged);
    void onFailedToRetrieveData(String error);
}
