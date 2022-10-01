package com.fali.services;

import com.flickr4java.flickr.FlickrException;

import java.io.InputStream;

public interface FlickrSercice {

    String savePhoto(InputStream photo ,String title) throws FlickrException;
}
