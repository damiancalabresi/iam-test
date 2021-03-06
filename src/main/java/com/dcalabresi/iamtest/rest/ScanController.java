package com.dcalabresi.iamtest.rest;

import com.dcalabresi.iamtest.dto.DtoConverter;
import com.dcalabresi.iamtest.dto.FilePathDto;
import com.dcalabresi.iamtest.dto.ImageMetadataDto;
import com.dcalabresi.iamtest.entities.ImageMetadata;
import com.dcalabresi.iamtest.services.ImageScannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by damian on 3/18/16.
 */
@RestController
@RequestMapping("/rest/scan")
public class ScanController {

    @Autowired
    ImageScannerService imageScannerService;

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public ImageMetadataDto scanImage(@RequestBody FilePathDto filePathDto) {
        ImageMetadata imageMetadata = imageScannerService.scanImage(filePathDto.getFilePath());
        return DtoConverter.getImageMetadataDto(imageMetadata);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<ImageMetadataDto> getScannedImages() {
        List<ImageMetadata> imageMetadatas = imageScannerService.getScannedImages();
        return DtoConverter.getImageMetadataDtoList(imageMetadatas);
    }

    @RequestMapping(value = "/filter", method = RequestMethod.GET)
    public List<ImageMetadataDto> getScannedImagesByFilter(@RequestParam(value = "filepath", defaultValue = "") String filePath,
                                                           @RequestParam(value = "dimension", defaultValue = "") String dimension,
                                                           @RequestParam(value = "format", defaultValue = "") String format) {
        List<ImageMetadata> imageMetadatas = imageScannerService.getScannedImagesFilter(filePath, dimension, format);
        return DtoConverter.getImageMetadataDtoList(imageMetadatas);
    }

}
