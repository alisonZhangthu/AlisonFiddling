package alisonzthu.learning.com.alisonfiddle;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    private List<String> mHorizontalDataModel = new ArrayList<>();
    private List<String> mVerticalDataModel = new ArrayList<>();
    private int mCount = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        RecyclerView horizontalRV = findViewById(R.id.horizontal_rv);
        RecyclerView verticalRV = findViewById(R.id.vertical_rv);
        verticalRV.setNestedScrollingEnabled(false);

        RecyclerView.LayoutManager mHorizontalLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        horizontalRV.setLayoutManager(mHorizontalLayoutManager);

        RecyclerView.LayoutManager mVerticalLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        verticalRV.setLayoutManager(mVerticalLayoutManager);

        RecyclerView.Adapter horizontalAdapter = new RecyclerView.Adapter() {
            @NonNull
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_list_item, parent, false);
                return new HorizontalViewHolder(v);
            }

            @Override
            public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

            }

            @Override
            public int getItemCount() {
                return mHorizontalDataModel.size();
            }
        };

        horizontalRV.setAdapter(horizontalAdapter);

        RecyclerView.Adapter verticalAdapter = new RecyclerView.Adapter() {
            @NonNull
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                Log.d("alison", "create view holder: " + (++mCount));
                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.vertical_list_item, parent, false);
                return new VerticalViewHolder(v);
            }

            @Override
            public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            }

            @Override
            public int getItemCount() {
                return mVerticalDataModel.size();
            }
        };

        verticalRV.setAdapter(verticalAdapter);

    }

    private void initializeData() {
        for (int i = 0; i < 80; i ++) {
            mHorizontalDataModel.add("Xueying Zhang Zhang zhang");
            mVerticalDataModel.add("Shuai Chen Chen Chen");
        }
    }
}
