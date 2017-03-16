package cn.georgeyang.gycachedemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.yanzhenjie.nohttp.Logger;
import com.yanzhenjie.nohttp.NoHttp;
import com.yanzhenjie.nohttp.rest.OnResponseListener;
import com.yanzhenjie.nohttp.rest.Request;
import com.yanzhenjie.nohttp.rest.RequestQueue;
import com.yanzhenjie.nohttp.rest.Response;

import cn.georgeyang.gycachedemo.bean.JavaBeanRequest;
import cn.georgeyang.gycachedemo.bean.PicBean;

public class MainActivity extends AppCompatActivity implements OnResponseListener<PicBean> {
    private RecyclerView mRecyclerView;
    private RequestQueue requestQueue = NoHttp.newRequestQueue();
    private MAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // specify an adapter (see also next example)
        mAdapter = new MAdapter();
        mRecyclerView.setAdapter(mAdapter);

        String url = "http://image.baidu.com/data/imgs?col=%E7%BE%8E%E5%A5%B3&tag=%E5%B0%8F%E6%B8%85%E6%96%B0&sort=0&pn=1&rn=100&p=channel&from=1";
        Request<PicBean> request = new JavaBeanRequest(url, PicBean.class);
        requestQueue.add(0, request, this);
    }

    @Override
    public void onStart(int i) {
        Logger.d(i);
    }

    @Override
    public void onSucceed(int i, Response<PicBean> response) {
        Logger.d(response);
        mAdapter.setList(response.get().imgs);
    }

    @Override
    public void onFailed(int i, Response<PicBean> response) {
        Logger.d(response);
    }

    @Override
    public void onFinish(int i) {

    }
}
