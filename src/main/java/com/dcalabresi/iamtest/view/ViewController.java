package com.dcalabresi.iamtest.view;

import com.dcalabresi.iamtest.dto.DirectoryPathDto;
import com.dcalabresi.iamtest.dto.FilePathDto;
import com.dcalabresi.iamtest.dto.ImageFilterDto;
import com.dcalabresi.iamtest.entities.ImageMetadata;
import com.dcalabresi.iamtest.entities.WatchDirectory;
import com.dcalabresi.iamtest.services.ImageScannerService;
import com.dcalabresi.iamtest.services.WatchDirectoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by damian on 3/18/16.
 */
@Controller
public class ViewController {

    @Autowired
    ImageScannerService imageScannerService;

    @Autowired
    WatchDirectoryService watchDirectoryService;

    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/scan")
    public String scan(Model model) {
        model.addAttribute("filePathDto", new FilePathDto());
        model.addAttribute("imageFilterDto", new ImageFilterDto());
        model.addAttribute("scannedImages", imageScannerService.getScannedImages());
        return "scan";
    }

    @RequestMapping(value = "/scan/new", method = RequestMethod.POST)
    public String scanNew(@ModelAttribute(value="filePathDto") FilePathDto filePathDto, Model model) {
        imageScannerService.scanImage(filePathDto.getFilePath());
        return scan(model);
    }

    @RequestMapping(value = "/scan/filter", method = RequestMethod.POST)
    public String scanFilter(@ModelAttribute(value="imageFilterDto") ImageFilterDto imageFilterDto, Model model) {
        List<ImageMetadata> scannedImages = imageScannerService.getScannedImagesFilter(imageFilterDto.getFilePath(),
                imageFilterDto.getDimension(),
                imageFilterDto.getFormat());
        model.addAttribute("filePathDto", new FilePathDto());
        model.addAttribute("scannedImages", scannedImages);
        return "scan";
    }

    @RequestMapping(value = "/watch")
    public String watch(Model model) {
        model.addAttribute("directoryPathDto", new DirectoryPathDto());
        model.addAttribute("watchDirectories", watchDirectoryService.getAll());
        return "watch";
    }

    @RequestMapping(value = "/watch/new", method = RequestMethod.POST)
    public String watchNew(@ModelAttribute(value="directoryPathDto") DirectoryPathDto directoryPathDto, Model model) {
        watchDirectoryService.newWatchDirectory(directoryPathDto.getDirectory());
        return watch(model);
    }

    @RequestMapping(value = "/watch/delete", method = RequestMethod.GET)
    public String watchDelete(@RequestParam("directoryId") Integer directoryId, Model model) {
        watchDirectoryService.deleteWatchDirectory(directoryId);
        return watch(model);
    }

    @RequestMapping(value = "/watch/image", method = RequestMethod.GET)
    public String watchImages(@RequestParam("directoryId") Integer directoryId, Model model) {
        WatchDirectory watchDirectory = watchDirectoryService.get(directoryId);
        List<ImageMetadata> metadataList = watchDirectoryService.getDirectoryMetadataList(directoryId);
        model.addAttribute("directory", watchDirectory);
        model.addAttribute("images", metadataList);
        return "watch-image";
    }

}
