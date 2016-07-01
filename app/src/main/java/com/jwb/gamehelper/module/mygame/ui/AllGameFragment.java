package com.jwb.gamehelper.module.mygame.ui;

import android.view.View;
import android.widget.ListView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.jwb.gamehelper.R;
import com.jwb.gamehelper.base.BaseFragment;
import com.jwb.gamehelper.base.ListViewCallBack;
import com.jwb.gamehelper.common.adapter.CommonAdapter;
import com.jwb.gamehelper.common.adapter.ViewHolder;
import com.jwb.gamehelper.module.mygame.bean.MyAllGameInfo;
import com.jwb.gamehelper.module.mygame.dao.MyAllGameDao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/6/30.
 */
public class AllGameFragment extends BaseFragment {


    private PullToRefreshListView mrlvGame;
    private int miCurPage =1;//记录加载数据页数
    private CommonAdapter<MyAllGameInfo.InfoBean> mAdapter;
    private List<MyAllGameInfo.InfoBean> mlistGames;

    @Override
    public int setViewId() {
        return R.layout.layout_mygame_fragment;
    }

    @Override
    public void findViews(View view) {
        mrlvGame = (PullToRefreshListView) view.findViewById(R.id.lv_mygame);
    }

    @Override
    public void init() {
        mlistGames=new ArrayList<>();
        mAdapter = new CommonAdapter<MyAllGameInfo.InfoBean>(this.getActivity(),
                mlistGames,
                R.layout.layout_money_mygame_item
                ) {
            @Override
            public void convert(ViewHolder helper, int position, MyAllGameInfo.InfoBean item) {
                helper.setText(R.id.game_item_title,item.getName());
                helper.setImageByUrl(R.id.game_item_image,item.getIcon(),getActivity());
                String score=item.getScore();
                score=score.contains(".")?score.substring(0,score.indexOf(".")):score;
                helper.setRating(R.id.game_item_star,Integer.parseInt(score) );
                helper.setText(R.id.game_item_dlcount,item.getCount_dl()+"人下载");
                helper.setText(R.id.game_item_size,item.getSize());
                helper.setText(R.id.game_item_prize,"奖"+item.getAll_prize()+"U币");
            }
        };
        mrlvGame.setAdapter(mAdapter);
    }

    @Override
    public void initEvent() {
        mrlvGame.setMode(PullToRefreshBase.Mode.BOTH);
        mrlvGame.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                miCurPage=1;
                mlistGames.clear();
                loadData();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                miCurPage++;
                loadData();
            }
        });
    }

    @Override
    public void loadData() {
        MyAllGameDao.getAllGameData(miCurPage, new ListViewCallBack() {
            @Override
            public void updateListView(Object object) {
                List<MyAllGameInfo.InfoBean> listDatas= (List<MyAllGameInfo.InfoBean>) object;
                mlistGames.addAll(listDatas);
                mAdapter.notifyDataSetChanged();
                mrlvGame.onRefreshComplete();
            }
        });
    }
}
