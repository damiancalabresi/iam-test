package com.dcalabresi.iamtest.rest;

import com.dcalabresi.iamtest.dto.DirectoryPathDto;
import com.dcalabresi.iamtest.dto.FilePathDto;
import com.dcalabresi.iamtest.dto.ImageMetadataDto;
import com.dcalabresi.iamtest.dto.WatchDirectoryDto;
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
        return getWatchDirectoryDto(watchDirectory);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<WatchDirectoryDto> getWatchDirectories() {
        List<WatchDirectory> watchDirectories = watchDirectoryService.getAll();
        return getWatchDirectoryDtoList(watchDirectories);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteWatchDirectory(@PathVariable("id") Integer id) {
        watchDirectoryService.deleteWatchDirectory(id);
    }

    private WatchDirectoryDto getWatchDirectoryDto(WatchDirectory watchDirectory) {
        if(watchDirectory==null) return null;
        return new WatchDirectoryDto(watchDirectory.getId(), watchDirectory.getDirectory());
    }

    private List<WatchDirectoryDto> getWatchDirectoryDtoList(List<WatchDirectory> watchDirectories) {
        List<WatchDirectoryDto> dtos = new ArrayList<>(watchDirectories.size());
        for (WatchDirectory watchDirectory : watchDirectories) {
            dtos.add(getWatchDirectoryDto(watchDirectory));
        }
        return dtos;
    }

}
