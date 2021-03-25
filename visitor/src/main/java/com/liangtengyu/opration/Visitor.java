package com.liangtengyu.opration;

import com.liangtengyu.files.EXCELfile;
import com.liangtengyu.files.PDFfile;
import com.liangtengyu.files.WORDfile;

/**
 * @Author: lty
 * @Date: 2021/3/25 14:02
 */
public interface Visitor {
    void v(PDFfile file);
    void v(EXCELfile file);
    void v(WORDfile file);
}
