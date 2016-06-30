package com.jwb.gamehelper.module.money.dao;

import com.google.gson.Gson;
import com.jwb.gamehelper.base.ListViewCallBack;
import com.jwb.gamehelper.common.constant.Constant;
import com.jwb.gamehelper.module.money.bean.TaskGameInfo;

import java.util.List;

/**
 * Created by Administrator on 2016/6/29.
 */
public class MoneyDao {
    public static void getGameData(ListViewCallBack listViewCallBack){
        Gson gson=new Gson();
        TaskGameInfo gameInfo = gson.fromJson(Constant.GAME_TASK_LIST_JSON, TaskGameInfo.class);
        listViewCallBack.updateListView(gameInfo.getInfo());
    }
}
