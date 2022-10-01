package com.fali.services.imp;

import com.fali.services.FlickrSercice;
import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.FlickrException;

import com.flickr4java.flickr.uploader.UploadMetaData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
@Service
@Slf4j
public class FlickrServiceImp implements FlickrSercice {

    private Flickr flickr;

    @Autowired
    public FlickrServiceImp(Flickr flickr){
        this.flickr=flickr;
    }

    @Override
    public String savePhoto(InputStream photo, String title) throws FlickrException {

        UploadMetaData uploadMetaData =new UploadMetaData();
        uploadMetaData.setTitle(title);

        String photoId = flickr.getUploader().upload(photo,uploadMetaData);
        return flickr.getPhotosInterface().getPhoto(photoId).getMedium640Url();
    }


}
