package com.liangtengyu.testApi;

import com.liangtengyu.files.EXCELfile;
import com.liangtengyu.files.PDFfile;
import com.liangtengyu.files.ResourceFile;
import com.liangtengyu.files.WORDfile;
import com.liangtengyu.opration.Compressor;
import com.liangtengyu.opration.Extractor;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lty
 * @Date: 2021/3/25 10:26
 */
public class Test {
    public static void main(String[] args) {
//        Extractor extractor = new Extractor();
        Compressor compressor = new Compressor();
        List<ResourceFile> files = listAllResourceFile();
        for (ResourceFile file : files) {
           file.accept(compressor);
        }
    }

    private static List<ResourceFile> listAllResourceFile() {
        List<ResourceFile> resourceFiles = new ArrayList<>();
        PDFfile pdFfile = new PDFfile("../pdffile.pdf");
        EXCELfile excelfile = new EXCELfile("../excelfile.xls");
        WORDfile wordfile = new WORDfile("../wordfile.word");
        resourceFiles.add(pdFfile);
        resourceFiles.add(excelfile);
        resourceFiles.add(wordfile);
        return resourceFiles;
    }
}
