package com.example.tabbarteste;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.tabbarteste.fragments.FragmentTres;
import com.example.tabbarteste.fragments.FragmentUm;
import com.example.tabbarteste.fragments.FragmentoDois;
import com.example.tabbarteste.fragments.Main;
import com.example.tabbarteste.fragments.Quatro;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.button)
    Button button;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.frameLayoutFragmentContent)
    FrameLayout frameLayoutFragmentContent;

    private Integer ITEM_1 = 0;
    private Integer ITEM_2 = 1;
    private Integer ITEM_MAIN = 2;
    private Integer ITEM_4 = 3;
    private Integer ITEM_5 = 4;

    private Integer IMG_ITEM_1 = R.drawable.ic_trophy;
    private Integer IMG_ITEM_2 = R.drawable.ic_cat;
    private Integer IMG_ITEM_MAIN = R.drawable.ic_dog;
    private Integer IMG_ITEM_4 = R.drawable.ic_dog;
    private Integer IMG_ITEM_5 = R.drawable.ic_plant;
    private Integer SELECTED = R.drawable.ic_clover;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setTabBar(ITEM_MAIN);


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                setTabBar(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        tab.setIcon(IMG_ITEM_1);
                        break;
                    case 1:
                        tab.setIcon(IMG_ITEM_2);
                        break;
                    case 3:
                        tab.setIcon(IMG_ITEM_4);
                        break;
                    case 4:
                        tab.setIcon(IMG_ITEM_5);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                setTabBar(tab.getPosition());
            }
        });
    }

    public void setTabBar(Integer tabId){
        switch (tabId){
            case 0:
                button.setCompoundDrawablesWithIntrinsicBounds(0,IMG_ITEM_MAIN,0,0);
                tabLayout.getTabAt(ITEM_1).setIcon(SELECTED);
                initFragment(Quatro.newInstance());
                break;
            case 1:
                button.setCompoundDrawablesWithIntrinsicBounds(0,IMG_ITEM_MAIN,0,0);
                tabLayout.getTabAt(ITEM_2).setIcon(SELECTED);
                initFragment(FragmentUm.newInstance());
                break;
            case 3:
                button.setCompoundDrawablesWithIntrinsicBounds(0,IMG_ITEM_MAIN,0,0);
                tabLayout.getTabAt(ITEM_4).setIcon(SELECTED);
                initFragment(FragmentoDois.newInstance());
                break;
            case 4:
                button.setCompoundDrawablesWithIntrinsicBounds(0,IMG_ITEM_MAIN,0,0);
                tabLayout.getTabAt(ITEM_5).setIcon(SELECTED);
                initFragment(FragmentTres.newInstance());
                break;
            default:
                button.setCompoundDrawablesWithIntrinsicBounds(0,SELECTED,0,0);
                tabLayout.getTabAt(ITEM_1).setIcon(IMG_ITEM_1);
                tabLayout.getTabAt(ITEM_2).setIcon(IMG_ITEM_2);
                tabLayout.getTabAt(ITEM_4).setIcon(IMG_ITEM_4);
                tabLayout.getTabAt(ITEM_5).setIcon(IMG_ITEM_5);
                initFragment(Main.newInstance());
                break;
        }
    }

    private void initFragment(Fragment genericFragmet) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frameLayoutFragmentContent, genericFragmet);
        ft.commitAllowingStateLoss();
    }

    @OnClick(R.id.button)
    public void onViewClicked() {
          setTabBar(ITEM_MAIN);
    }
}
