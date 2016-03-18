package com.dcalabresi.iamtest.services;

import com.dcalabresi.iamtest.entities.ImageMetadata;
import com.dcalabresi.iamtest.repository.ImageMetadataRepository;
import com.dcalabresi.iamtest.utils.ImageMetadataReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by damian on 3/18/16.
 */
@Service
public class ImageScannerService {

    @Autowired
    ImageMetadataRepository imageMetadataRepository;

    public ImageMetadata scanImage(String filePath) {
        ImageMetadata imageMetadata = ImageMetadataReader.readMetadataFromFile(filePath);
        if(imageMetadata!=null) imageMetadataRepository.save(imageMetadata);
        return imageMetadata;
    }

    public List<ImageMetadata> getScannedImages() {
        return imageMetadataRepository.findAll();
    }

    public List<ImageMetadata> getScannedImagesFilter(String filePath, String dimension, String format) {
        return imageMetadataRepository.findByFilePathContainingAndDimensionContainingAndFormatContaining(filePath,
                dimension, format);
    }
}
