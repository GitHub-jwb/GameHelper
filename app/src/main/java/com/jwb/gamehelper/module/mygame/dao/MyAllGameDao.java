package com.jwb.gamehelper.module.mygame.dao;

import com.google.gson.Gson;
import com.jwb.gamehelper.base.ListViewCallBack;
import com.jwb.gamehelper.base.NetCallBack;
import com.jwb.gamehelper.common.constant.Constant;
import com.jwb.gamehelper.common.net.HttpNet;
import com.jwb.gamehelper.module.mygame.bean.MyAllGameInfo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/6/30.
 */
public class MyAllGameDao {
    public static void getAllGameData(int iPage, final ListViewCallBack callBack){
        Map<String,String> params=new HashMap<>();
        params.put("platform","2");//标识平台类型：1代表ios,2代表安卓
        params.put("page",iPage+"");

        HttpNet.doHttpRequest("POST", Constant.MONEY_GAME_LIST_URL, params, new NetCallBack() {
            @Override
            public void success(String strResult) {
                Gson gson=new Gson();
                MyAllGameInfo gameInfo = gson.fromJson(strResult, MyAllGameInfo.class);
                callBack.updateListView(gameInfo.getInfo());
            }

            @Override
            public void fail(String strResult) {

            }
        });
    }

    public static void getSearchGameResult(String searchStr, final ListViewCallBack callBack){
        Map<String,String> params=new HashMap<>();
        params.put("platform","2");//标识平台类型：1代表ios,2代表安卓
        params.put("name",searchStr);//检索的游戏名称
        HttpNet.doHttpRequest("POST", Constant.MONEY_GAME_LIST_URL, params, new NetCallBack() {
            @Override
            public void success(String strResult) {
                Gson gson=new Gson();
                MyAllGameInfo gameInfo = gson.fromJson(strResult, MyAllGameInfo.class);
                callBack.updateListView(gameInfo.getInfo());
            }

            @Override
            public void fail(String strResult) {

            }
        });
    }
}
