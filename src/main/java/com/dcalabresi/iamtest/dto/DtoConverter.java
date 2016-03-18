package com.dcalabresi.iamtest.dto;

import com.dcalabresi.iamtest.entities.ImageMetadata;
import com.dcalabresi.iamtest.entities.WatchDirectory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by damian on 3/18/16.
 */
public class DtoConverter {

    public static WatchDirectoryDto getWatchDirectoryDto(WatchDirectory watchDirectory) {
        if(watchDirectory==null) return null;
        return new WatchDirectoryDto(watchDirectory.getId(), watchDirectory.getDirectory());
    }

    public static List<WatchDirectoryDto> getWatchDirectoryDtoList(List<WatchDirectory> watchDirectories) {
        List<WatchDirectoryDto> dtos = new ArrayList<>(watchDirectories.size());
        for (WatchDirectory watchDirectory : watchDirectories) {
            dtos.add(getWatchDirectoryDto(watchDirectory));
        }
        return dtos;
    }

    public static List<ImageMetadataDto> getImageMetadataDtoList(List<ImageMetadata> imageMetadatas) {
        List<ImageMetadataDto> dtos = new ArrayList<>(imageMetadatas.size());
        for (ImageMetadata imageMetadata : imageMetadatas) {
            dtos.add(getImageMetadataDto(imageMetadata));
        }
        return dtos;
    }

    public static ImageMetadataDto getImageMetadataDto(ImageMetadata imageMetadata) {
        return new ImageMetadataDto(imageMetadata.getId(), imageMetadata.getFilePath(), imageMetadata.getDimension(),
                imageMetadata.getDpi(), imageMetadata.getBitsPerPixel(),
                imageMetadata.getFormat(), imageMetadata.getColorType());
    }

}
