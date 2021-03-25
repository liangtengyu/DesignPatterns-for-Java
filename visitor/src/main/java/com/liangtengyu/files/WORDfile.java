package com.liangtengyu.files;

import com.liangtengyu.opration.Extractor;
import com.liangtengyu.opration.Visitor;

/**
 * @Author: lty
 * @Date: 2021/3/25 10:21
 */
public class WORDfile extends ResourceFile {
    public WORDfile(String filepath) {
        super(filepath);
    }
    @Override
    public void accept(Visitor visitor) {
        visitor.v(this);
    }


}
