package com.jwb.gamehelper.module.mygame.ui;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.jwb.gamehelper.R;
import com.jwb.gamehelper.base.BaseActivity;
import com.jwb.gamehelper.base.ListViewCallBack;
import com.jwb.gamehelper.common.adapter.CommonAdapter;
import com.jwb.gamehelper.common.adapter.RecAdapter;
import com.jwb.gamehelper.common.adapter.ViewHolder;
import com.jwb.gamehelper.module.mygame.bean.LikeGameInfo;
import com.jwb.gamehelper.module.mygame.bean.MyAllGameInfo;
import com.jwb.gamehelper.module.mygame.dao.LikeGameDao;
import com.jwb.gamehelper.module.mygame.dao.MyAllGameDao;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends BaseActivity {


    private ListView mlvSearchResult;
    private CommonAdapter<MyAllGameInfo.InfoBean> mAdapter;
    private List<MyAllGameInfo.InfoBean> mlistDatas;
    private ImageView mivSearchLogo;
    private EditText mEdtInput;
    private String mInputContent=null;
    private RecyclerView mRvLikeGames;
    List<LikeGameInfo.InfoBean> mLikeGameDatas;
    private RecAdapter<LikeGameInfo.InfoBean> mRecAdapter;
    private LinearLayout mLikeLayout;

    @Override
    public int setViewId() {
        return R.layout.activity_search;
    }

    @Override
    public void findViews() {
        //获取存放搜索结果的listview对象
        mlvSearchResult = (ListView) findViewById(R.id.lv_search_result);
        mivSearchLogo = (ImageView) findViewById(R.id.iv_search_logo);
        mEdtInput = (EditText) findViewById(R.id.et_search);
        mRvLikeGames = (RecyclerView) findViewById(R.id.recyclerview);
        //获得猜你喜欢布局控件对象。
        mLikeLayout = (LinearLayout) findViewById(R.id.like_layout);
    }

    @Override
    public void init() {

        mlistDatas = new ArrayList<>();
        mLikeGameDatas=new ArrayList<>();
        mAdapter = new CommonAdapter<MyAllGameInfo.InfoBean>(this,
                mlistDatas,
                R.layout.layout_money_mygame_item
                ) {
            @Override
            public void convert(ViewHolder helper, int position, MyAllGameInfo.InfoBean item) {
                helper.setText(R.id.game_item_title,item.getName());
                helper.setImageByUrl(R.id.game_item_image,item.getIcon(),SearchActivity.this);
                String score=item.getScore();
                score=score.contains(".")?score.substring(0,score.indexOf(".")):score;
                helper.setRating(R.id.game_item_star,Integer.parseInt(score) );
                helper.setText(R.id.game_item_dlcount,item.getCount_dl()+"人下载");
                helper.setText(R.id.game_item_size,item.getSize());
                helper.setText(R.id.game_item_prize,"奖"+item.getAll_prize()+"U币");
            }
        };
        //给listView设置适配器
        mlvSearchResult.setAdapter(mAdapter);

        mRecAdapter = new RecAdapter<>(this,
                mLikeGameDatas,
                new RecAdapter.RecCallBack() {
                    @Override
                    public void convert(RecAdapter.ViewHolder viewHolder, List mDatas, int position) {
                        Picasso.with(SearchActivity.this).load(mLikeGameDatas.get(position).getIcon()).into(viewHolder.mImg);
                        viewHolder.mTxt1.setText(mLikeGameDatas.get(position).getName());
                        viewHolder.mTxt2.setText(mLikeGameDatas.get(position).getCount_dl()+"人下载");
                    }
                });
        //设置布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRvLikeGames.setLayoutManager(linearLayoutManager);
        mRvLikeGames.setAdapter(mRecAdapter);
    }

    @Override
    public void initEvent() {
        mivSearchLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //获得搜索输入的内容
                mInputContent = mEdtInput.getText().toString();
                loadSearchGameResult();
            }
        });
        mlvSearchResult.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(SearchActivity.this,i+"",Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void loadLikeGameData(){
        mLikeGameDatas.clear();
        LikeGameDao.getLikeGameData(new ListViewCallBack() {
            @Override
            public void updateListView(Object object) {
                List<LikeGameInfo.InfoBean> list= (List<LikeGameInfo.InfoBean>) object;
                mLikeGameDatas.addAll(list);
                mRecAdapter.notifyDataSetChanged();
                //显示
                mLikeLayout.setVisibility(View.VISIBLE);
            }
        });
    }

    private void loadSearchGameResult(){
        mlistDatas.clear();
        MyAllGameDao.getSearchGameResult(mInputContent, new ListViewCallBack() {
            @Override
            public void updateListView(Object object) {
                List<MyAllGameInfo.InfoBean> list= (List<MyAllGameInfo.InfoBean>) object;
                mlistDatas.addAll(list);
                mAdapter.notifyDataSetChanged();
            }
        });
    }
    @Override
    public void loadData() {
        //加载喜欢的游戏数据
        loadLikeGameData();

    }
    //点击返回图标执行的方法
    public void clickBack(View view) {
        finish();
    }
}
