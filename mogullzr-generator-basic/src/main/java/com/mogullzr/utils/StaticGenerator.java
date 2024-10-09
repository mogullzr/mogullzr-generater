package com.mogullzr.utils;


import cn.hutool.core.io.FileUtil;

import java.io.File;

public class StaticGenerator {
    public static void main(String[] args) {
        String basicPath = System.getProperty("user.dir");
        // 保证跨系统支持，输入路径
        String inputPath = basicPath + File.separator + "sample"+ File.separator  +"mogullzr-generator-ACM-template";
        // 输出路径
        String outputPath = basicPath;
        copyFilesByHutool(inputPath, outputPath);
    }
    /**
     * 拷贝文件
     * @param inputPath
     * @param outputPath
     */
    public static void copyFilesByHutool(String inputPath, String outputPath) {
        FileUtil.copy(inputPath, outputPath, false);
    }
}
