package com.liangtengyu.opration;

import com.liangtengyu.files.EXCELfile;
import com.liangtengyu.files.PDFfile;
import com.liangtengyu.files.WORDfile;

/**
 * @Author: lty
 * @Date: 2021/3/25 14:08
 */
public class Compressor implements Visitor {

    @Override
    public void v(PDFfile file) {
        System.out.println(" Compressor PDFfile");
    }

    @Override
    public void v(EXCELfile file) {
        System.out.println("Compressor EXCELfile");
    }

    @Override
    public void v(WORDfile file) {
        System.out.println("Compressor WORDfile");
    }
}
