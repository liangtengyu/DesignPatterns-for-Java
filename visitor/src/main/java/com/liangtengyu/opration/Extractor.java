package com.liangtengyu.opration;

import com.liangtengyu.files.EXCELfile;
import com.liangtengyu.files.PDFfile;
import com.liangtengyu.files.WORDfile;

/**
 * @Author: lty
 * @Date: 2021/3/25 11:08
 */
public class Extractor implements Visitor{

    @Override
    public void v(PDFfile file) {
        System.out.println("Extractor pdffile");
    }

    @Override
    public void v(EXCELfile file) {
        System.out.println("Extractor EXCELfile");
    }

    @Override
    public void v(WORDfile file) {
        System.out.println("Extractor WORDfile");
    }
}
