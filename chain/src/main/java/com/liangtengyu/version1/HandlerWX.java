package com.liangtengyu.version1;

/**
 * @Author: lty
 * @Date: 2021/2/25 09:25
 */
public class HandlerWX extends Handler {



    @Override
    public void handle() {
        boolean handled = false;
        //region 业务逻辑
        System.out.println("微信支付处理逻辑....");
        //endregion

        //调用下一个处理器
        if (!handled && successor != null) {
            successor.handle();
        }
    }


    /**
     * 实际上，上面的代码实现不够优雅。处理器类的 handle() 函数，
     * 不仅包含自己的业务逻辑，还包含对下一个处理器的调用，也就是代码中的 successor.handle()。
     * 一个不熟悉这种代码结构的程序员，在添加新的处理器类的时候，
     * 很有可能忘记在 handle() 函数中调用 successor.handle()，
     * 这就会导致代码出现 bug。
     */
}
