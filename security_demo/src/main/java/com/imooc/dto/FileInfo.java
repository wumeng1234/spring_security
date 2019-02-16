package com.imooc.dto;/**
 * Created by 吴猛
 * Date:2019/1/30
 */
public class FileInfo {
    private String path;

    public FileInfo() {
    }

    @Override
    public String toString() {
        return "FileInfo{" +
                "path='" + path + '\'' +
                '}';
    }

    public FileInfo(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
