package com.dcalabresi.iamtest.services;

import com.dcalabresi.iamtest.entities.ImageMetadata;
import com.dcalabresi.iamtest.utils.ImageMetadataReader;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by damian on 3/18/16.
 */
@Service
public class ImageScannerService {

    public ImageMetadata scanImage(String filePath) {
        ImageMetadata imageMetadata = ImageMetadataReader.readMetadataFromFile(filePath);
        return imageMetadata;
    }

    public List<ImageMetadata> getScannedImages() {
        return new ArrayList<>();
    }

    public List<ImageMetadata> getScannedImagesFilter(String filePath, String dimension, String format) {
        return new ArrayList<>();
    }
}
