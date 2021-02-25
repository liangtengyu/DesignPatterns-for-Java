package com.liangtengyu.version2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lty
 * @Date: 2021/2/25 09:52
 */
public class HandlerChainForCard {
    List<Handler> handlers = new ArrayList<>();

    public void setHandler(Handler handler) {
        handlers.add(handler);
    }

    public void handle(){
        for (Handler handler : handlers) {
            boolean b = handler.doHandle();
            if (b) {
                break;
            }
        }
    }
}
