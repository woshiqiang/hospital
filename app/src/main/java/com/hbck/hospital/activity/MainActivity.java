package com.hbck.hospital.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;

import com.hbck.hospital.R;
import com.hbck.hospital.fragment.HomeFragment;
import com.hbck.hospital.fragment.MeFragment;
import com.hbck.hospital.fragment.OrderFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author admin
 * @time 2018-11-29 17:19
 * @类描述：主界面
 * @变更记录:
 */
public class MainActivity extends AppCompatActivity {
    @BindView(R.id.rg_main)
    RadioGroup rgMain;

    private Fragment[] fragments;
    private int index;
    private int currentIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();

    }

    private void initView() {
        rgMain.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId) {
                case R.id.rb_home:
                    index = 0;
                    break;
                case R.id.rb_msg:
                    index = 1;
                    break;
                case R.id.rb_me:
                    index = 2;
                    break;
            }

            showFragment(index);
        });

        fragments = new Fragment[]{new HomeFragment(), new OrderFragment(), new MeFragment()};
        getSupportFragmentManager().beginTransaction().add(R.id.fl_main, fragments[0]).add(R.id.fl_main, fragments[1]).hide(fragments[1]).show(fragments[0]).commit();
    }

    /**
     * 切换fragment
     *
     * @param index：0-2
     */
    public void showFragment(int index) {
        if (currentIndex != index) {
            FragmentTransaction trx = getSupportFragmentManager().beginTransaction();
            trx.hide(fragments[currentIndex]);
            if (!fragments[index].isAdded()) {
                trx.add(R.id.fl_main, fragments[index]);
            }
            trx.show(fragments[index]).commit();
        }

        currentIndex = index;
    }


}
