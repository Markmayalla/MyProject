package tz.co.comptech.m_safariproduction.Api;

/*
    Created in 05/11/2018

    This file used to provide root server url
        e.g
            www.m-safariapp.com/api/mob
 */
class Connection {
    /*
            Variable holding root url
     */
    private final static String root = "/";

    /*
        Function returning root url to class extend this class
     */
    static String getRoot() {
        return root;
    }
}


