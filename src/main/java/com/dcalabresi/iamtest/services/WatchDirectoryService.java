package com.dcalabresi.iamtest.services;

import com.dcalabresi.iamtest.entities.WatchDirectory;
import com.dcalabresi.iamtest.repository.WatchDirectoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

/**
 * Created by damian on 3/18/16.
 */
@Service
public class WatchDirectoryService {

    @Autowired
    WatchDirectoryRepository watchDirectoryRepository;

    public List<WatchDirectory> getAll() {
        return watchDirectoryRepository.findAll();
    }

    public WatchDirectory newWatchDirectory(String directory) {
        File f = new File(directory);
        if (f.isDirectory()) {
            WatchDirectory watchDirectory = new WatchDirectory(directory);
            return watchDirectoryRepository.save(watchDirectory);
        } else {
            return null;
        }
    }

    public void deleteWatchDirectory(Integer watchDirectoryId) {
        watchDirectoryRepository.delete(watchDirectoryId);
    }

}
