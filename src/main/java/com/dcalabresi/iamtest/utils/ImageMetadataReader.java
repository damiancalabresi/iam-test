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
        File file = new File(filePath);
        try {
            ImageMetadata imageMetadata = new ImageMetadata();
            ImageInfo imageInfo = Imaging.getImageInfo(file);
            imageMetadata.setFilePath(filePath);
            imageMetadata.setBitsPerPixel(imageInfo.getBitsPerPixel());
            imageMetadata.setColorType(imageInfo.getColorType().name());
            imageMetadata.setDpi(imageInfo.getPhysicalHeightDpi());
            imageMetadata.setFormat(imageInfo.getFormat().getName());
            String dimension = imageInfo.getWidth() + "x" + imageInfo.getHeight();
            imageMetadata.setDimension(dimension);
            return imageMetadata;
        } catch (ImageReadException | IOException e) {
            return null;
        }
    }
}
