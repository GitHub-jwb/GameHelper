package com.jwb.gamehelper.base;

/**
 * 网络监听时回调的接口
 * Created by Administrator on 2016/6/27.
 */
public interface NetCallBack {
    /**
     * 网络访问成功
     * @param strResult
     */
    public void success(String strResult);

    /**
     * 网络访问失败
     * @param strResult
     */
    public void fail(String strResult);
}
