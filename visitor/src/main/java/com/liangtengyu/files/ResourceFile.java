package com.liangtengyu.files;

import com.liangtengyu.opration.Extractor;
import com.liangtengyu.opration.Visitor;

/**
 * @Author: lty
 * @Date: 2021/3/25 10:19
 */
public abstract class ResourceFile {
    protected String filepath;

    public ResourceFile(String filepath) {
        this.filepath=filepath;
    }

    public abstract void accept(Visitor visitor);

}
