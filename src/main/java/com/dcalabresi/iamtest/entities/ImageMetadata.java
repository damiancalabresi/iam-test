package com.dcalabresi.iamtest.entities;

import com.google.common.base.Objects;

import javax.persistence.*;

/**
 * Created by damian on 3/18/16.
 */
@Entity
public class ImageMetadata {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String filePath;

    private String dimension;

    private Integer dpi;

    private Integer bitsPerPixel;

    private String format;

    private String colorType;

    @ManyToOne(fetch = FetchType.LAZY)
    private WatchDirectory watchDirectory;

    public ImageMetadata() {
    }

    public ImageMetadata(String filePath, String dimension, Integer dpi, Integer bitsPerPixel, String format, String colorType) {
        this.filePath = filePath;
        this.dimension = dimension;
        this.dpi = dpi;
        this.bitsPerPixel = bitsPerPixel;
        this.format = format;
        this.colorType = colorType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public Integer getDpi() {
        return dpi;
    }

    public void setDpi(Integer dpi) {
        this.dpi = dpi;
    }

    public Integer getBitsPerPixel() {
        return bitsPerPixel;
    }

    public void setBitsPerPixel(Integer bitsPerPixel) {
        this.bitsPerPixel = bitsPerPixel;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getColorType() {
        return colorType;
    }

    public void setColorType(String colorType) {
        this.colorType = colorType;
    }

    public WatchDirectory getWatchDirectory() {
        return watchDirectory;
    }

    public void setWatchDirectory(WatchDirectory watchDirectory) {
        this.watchDirectory = watchDirectory;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("filePath", filePath)
                .add("dimension", dimension)
                .add("dpi", dpi)
                .add("bitsPerPixel", bitsPerPixel)
                .add("format", format)
                .add("colorType", colorType)
                .add("watchDirectory", watchDirectory)
                .toString();
    }

}
