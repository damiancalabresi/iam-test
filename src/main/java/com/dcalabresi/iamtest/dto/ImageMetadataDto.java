package com.dcalabresi.iamtest.dto;

import com.google.common.base.Objects;

/**
 * Created by damian on 3/18/16.
 */
public class ImageMetadataDto {

    private String filePath;

    private Integer width;

    private Integer height;

    private Integer dpi;

    private Integer bitsPerPixel;

    private String format;

    private String colorType;

    public ImageMetadataDto() {
    }

    public ImageMetadataDto(String filePath, Integer width, Integer height, Integer dpi, Integer bitsPerPixel, String format, String colorType) {
        this.filePath = filePath;
        this.width = width;
        this.height = height;
        this.dpi = dpi;
        this.bitsPerPixel = bitsPerPixel;
        this.format = format;
        this.colorType = colorType;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
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

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("filePath", filePath)
                .add("width", width)
                .add("height", height)
                .add("dpi", dpi)
                .add("bitsPerPixel", bitsPerPixel)
                .add("format", format)
                .add("colorType", colorType)
                .toString();
    }

}
