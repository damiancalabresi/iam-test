package com.dcalabresi.iamtest.services;

import com.dcalabresi.iamtest.entities.ImageMetadata;
import com.dcalabresi.iamtest.entities.WatchDirectory;
import com.dcalabresi.iamtest.repository.ImageMetadataRepository;
import com.dcalabresi.iamtest.repository.WatchDirectoryRepository;
import com.dcalabresi.iamtest.utils.ImageMetadataReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by damian on 3/18/16.
 */
@Service
public class WatchDirectoryService {

    private static Logger logger = LoggerFactory.getLogger(WatchDirectoryService.class);

    @Autowired
    WatchDirectoryRepository watchDirectoryRepository;

    @Autowired
    ImageMetadataRepository imageMetadataRepository;

    private static ConcurrentHashMap<Integer, List<ImageMetadata>> watchMetadata = new ConcurrentHashMap<>();

    public List<WatchDirectory> getAll() {
        return watchDirectoryRepository.findAll();
    }

    public WatchDirectory get(Integer watchDirectoryId) {
        return watchDirectoryRepository.findOne(watchDirectoryId);
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

    public List<ImageMetadata> getDirectoryMetadataList(Integer watchDirectoryId) {
        return imageMetadataRepository.findByWatchDirectoryId(watchDirectoryId);
    }

    @Scheduled(fixedRate = 5000)
    @Transactional
    public void scanWatchDirectoryList() {
        logger.info("Scanning watch directory list");
        List<WatchDirectory> watchDirectories = watchDirectoryRepository.findAll();
        watchMetadata.clear();
        for (WatchDirectory watchDirectory : watchDirectories) {
            scanWatchDirectory(watchDirectory);
        }
    }

    private void scanWatchDirectory(WatchDirectory watchDirectory) {
        imageMetadataRepository.deleteByWatchDirectoryId(watchDirectory.getId());
        List<ImageMetadata> imageMetadataList = new ArrayList<>();
        String directory = watchDirectory.getDirectory();
        File dirFile = new File(directory);
        File[] files = dirFile.listFiles();
        for (File file : files) {
            ImageMetadata imageMetadata = ImageMetadataReader.readMetadataFromFile(file);
            if(imageMetadata!=null) {
                imageMetadata.setWatchDirectory(watchDirectory);
                imageMetadataList.add(imageMetadata);
            }
        }
        imageMetadataRepository.save(imageMetadataList);
    }

}
