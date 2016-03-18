package com.dcalabresi.iamtest.utils;

import com.dcalabresi.iamtest.entities.ImageMetadata;
import org.apache.commons.imaging.ImageInfo;
import org.apache.commons.imaging.ImageReadException;
import org.apache.commons.imaging.Imaging;

import java.io.File;
import java.io.IOException;

/**
 * Created by damian on 3/18/16.
 */
public class ImageMetadataReader {

    public static ImageMetadata readMetadataFromFile(String filePath) {
        ImageMetadata imageMetadata = new ImageMetadata();
        File file = new File(filePath);
        try {
            ImageInfo imageInfo = Imaging.getImageInfo(file);
            imageMetadata.setFilePath(filePath);
            imageMetadata.setBitsPerPixel(imageInfo.getBitsPerPixel());
            imageMetadata.setColorType(imageInfo.getColorType().name());
            imageMetadata.setDpi(imageInfo.getPhysicalHeightDpi());
            imageMetadata.setFormat(imageInfo.getFormat().getName());
            imageMetadata.setHeight(imageInfo.getHeight());
            imageMetadata.setWidth(imageInfo.getWidth());
        } catch (ImageReadException | IOException e) {
        }
        return imageMetadata;
    }
}
