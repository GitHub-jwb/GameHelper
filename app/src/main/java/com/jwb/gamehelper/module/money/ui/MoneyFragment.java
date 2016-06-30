package com.jwb.gamehelper.module.money.ui;

import android.content.Intent;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.PopupWindow;

import com.jwb.gamehelper.R;
import com.jwb.gamehelper.base.BaseFragment;
import com.jwb.gamehelper.base.ListViewCallBack;
import com.jwb.gamehelper.common.adapter.CommonAdapter;
import com.jwb.gamehelper.common.adapter.ViewHolder;
import com.jwb.gamehelper.module.money.bean.TaskGameInfo;
import com.jwb.gamehelper.module.money.dao.MoneyDao;
import com.jwb.gamehelper.module.mygame.ui.MyGameActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/6/29.
 */
public class MoneyFragment extends BaseFragment {
    private PopupWindow mpopWd = null;
    private boolean isLoadOk = false;
    private View mviewPw;
    private View mfmView;
    private List<TaskGameInfo.InfoBean> mlistGame;
    private ListView mlvGame;
    private CommonAdapter<TaskGameInfo.InfoBean> mAdapter;

    public void showLoadDialog() {
        if (!isLoadOk && (mpopWd == null)) {
            mpopWd = new PopupWindow(mviewPw,
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    false);
            mpopWd.showAtLocation(mfmView, Gravity.CENTER, 0, 0);
            WindowManager.LayoutParams params = getActivity().getWindow().getAttributes();
            params.alpha=0.5f;
            getActivity().getWindow().setAttributes(params);
        }
    }

    public void coloseLoadDialog() {
        isLoadOk=true;
        if (mpopWd != null) {
            mpopWd.dismiss();
            mpopWd = null;
        }
    }

    @Override
    public int setViewId() {
        return R.layout.layout_fragment_money;
    }

    @Override
    public void findViews(View view) {
        mfmView = view;
        mlvGame = (ListView) view.findViewById(R.id.lv_game);
    }

    @Override
    public void init() {
        mviewPw = LayoutInflater.from(getActivity()).inflate(R.layout.layout_money_pw_load, null);
        View mheadView=LayoutInflater.from(getActivity()).inflate(R.layout.layout_moneylist_head,null);
        mlistGame = new ArrayList<>();
        mAdapter = new CommonAdapter<TaskGameInfo.InfoBean>(
                getActivity(),
                mlistGame,
                R.layout.layout_moneylist_item
        ) {
            @Override
            public void convert(ViewHolder helper, int position, TaskGameInfo.InfoBean item) {
                helper.setText(R.id.game_item_title, item.getPlatform_name());
                helper.setImageByUrl(R.id.game_item_image, item.getAd_img(), getActivity());
                helper.setText(R.id.game_item_desc, item.getDesc());
                helper.setRating(R.id.game_item_star, Integer.parseInt(item.getRank()));
                helper.setText(R.id.game_item_reward,item.getReward());
            }
        };
        mheadView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), MyGameActivity.class);
                startActivity(intent);
            }
        });
        mlvGame.addHeaderView(mheadView);
        mlvGame.setAdapter(mAdapter);
    }

    @Override
    public void initEvent() {

    }

    @Override
    public void loadData() {
        MoneyDao.getGameData(new ListViewCallBack() {
            @Override
            public void updateListView(Object object) {
                List<TaskGameInfo.InfoBean> listGameInfo = (List<TaskGameInfo.InfoBean>) object;
                mlistGame.addAll(listGameInfo);
                mAdapter.notifyDataSetChanged();
                coloseLoadDialog();
            }
        });
    }

}
