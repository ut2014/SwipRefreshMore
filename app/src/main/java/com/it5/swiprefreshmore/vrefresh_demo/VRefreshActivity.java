package com.it5.swiprefreshmore.vrefresh_demo;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.it5.swiprefreshmore.R;

import java.util.ArrayList;
import java.util.List;


public class VRefreshActivity extends AppCompatActivity {
    private VRefresh swiperefreshlayou;
    private ListView lv;
    private List<String> mList=new ArrayList<>();
    private ArrayAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vrefresh);
        initialize();
        initSwip();
    }

    private void initSwip() {
        for (int i = 0; i < 5; i++) {
            mList.add("----" + i);
        }
        //进度条颜色
        swiperefreshlayou.setColorSchemeResources(android.R.color.holo_red_light,android.R.color.holo_green_light, android.R.color.holo_blue_bright, android.R.color.holo_orange_light);
//      swiperefreshlayou.setProgressBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
        swiperefreshlayou.setSize(0);//0和1  圆形进度条两种不同效果 0刚开始有渲染效果
        myAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,mList);//listview adapter
        swiperefreshlayou.setView(this, lv);//设置嵌套的子view -listview
        swiperefreshlayou.setMoreData(false);//设置是否还有数据可加载(一般根据服务器反回来决定)
        lv.setAdapter(myAdapter);
        swiperefreshlayou.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Message msg = mhandler.obtainMessage();
                msg.what = REFRESH_COMPLETE;
                mhandler.sendMessageDelayed(msg, 2000);//3秒后通知停止刷新
            }
        });
        swiperefreshlayou.setOnLoadListener(new VRefresh.OnLoadListener() {
            @Override
            public void onLoadMore() {
                Message msg = mhandler.obtainMessage();
                msg.what = LOADMORE_COMPLETE;
                mhandler.sendMessageDelayed(msg, 2000);//3秒后通知停止加载更多
            }
        });
    }

    private void initialize() {
        swiperefreshlayou= (VRefresh) findViewById(R.id.swiperefreshlayou);
        lv= (ListView) findViewById(R.id.lv);

    }

    private static final int REFRESH_COMPLETE = 0;//刷新完成标识
    private static final int LOADMORE_COMPLETE = 1;//加载更多完成标识
    Handler mhandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case LOADMORE_COMPLETE:
                    for (int i = 0; i < 5; i++) {
                        mList.add("----" + i);
                    }
                    myAdapter.notifyDataSetChanged();
                    swiperefreshlayou.setMoreData(true);//设置还有数据可以加载
                    swiperefreshlayou.setLoading(false);//停止加载更多
                    break;
                case REFRESH_COMPLETE:
                    mList.clear();
                    for (int i = 0; i < 5; i++) {
                        mList.add("----" + i);
                    }
                    swiperefreshlayou.setMoreData(true);//设置还有数据可以加载
                    myAdapter.notifyDataSetChanged();
                    swiperefreshlayou.setRefreshing(false);//停止刷新
                    break;
            }
        }
    };


}
