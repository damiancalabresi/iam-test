package com.dcalabresi.iamtest.rest;

import com.dcalabresi.iamtest.dto.*;
import com.dcalabresi.iamtest.entities.ImageMetadata;
import com.dcalabresi.iamtest.entities.WatchDirectory;
import com.dcalabresi.iamtest.services.ImageScannerService;
import com.dcalabresi.iamtest.services.WatchDirectoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by damian on 3/18/16.
 */
@RestController
@RequestMapping("/rest/watch")
public class WatchController {

    @Autowired
    WatchDirectoryService watchDirectoryService;

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public WatchDirectoryDto watchDirectory(@RequestBody DirectoryPathDto directoryPathDto) {
        WatchDirectory watchDirectory = watchDirectoryService.newWatchDirectory(directoryPathDto.getDirectory());
        return DtoConverter.getWatchDirectoryDto(watchDirectory);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<WatchDirectoryDto> getWatchDirectories() {
        List<WatchDirectory> watchDirectories = watchDirectoryService.getAll();
        return DtoConverter.getWatchDirectoryDtoList(watchDirectories);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteWatchDirectory(@PathVariable("id") Integer id) {
        watchDirectoryService.deleteWatchDirectory(id);
    }

    @RequestMapping(value = "/scanall", method = RequestMethod.GET)
    public void scanWatchDirectoryList() {
        watchDirectoryService.scanWatchDirectoryList();
    }

    @RequestMapping(value = "/metadata/{id}", method = RequestMethod.GET)
    public List<ImageMetadataDto> getDirectoryMetadataList(@PathVariable("id") Integer id) {
        List<ImageMetadata> metadataList = watchDirectoryService.getDirectoryMetadataList(id);
        return DtoConverter.getImageMetadataDtoList(metadataList);
    }



}
