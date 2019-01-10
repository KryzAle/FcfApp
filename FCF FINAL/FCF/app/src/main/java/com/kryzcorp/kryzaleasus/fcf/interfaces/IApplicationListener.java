package com.kryzcorp.kryzaleasus.fcf.interfaces;

/**
 * Created by KryzAleAsus on 26/6/2017.
 */


public interface IApplicationListener {

    void onTaskCompleted();
    void onFailedToCompleteTask(String error);
}
