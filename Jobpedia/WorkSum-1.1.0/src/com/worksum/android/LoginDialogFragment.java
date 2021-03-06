package com.worksum.android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.jobs.lib_v1.data.ObjectSessionStore;

/**
 * @author chao.qin
 * 2016/2/3
 */
public class LoginDialogFragment extends GeneralFragment implements View.OnClickListener {

    private ImageView mCloseView;
    private Button mLoginBtn;
    private Button mRegisterBtn;

    Intent mData;
    LoginFragment.LoginCallback mLoginCallback;

    @Override
    protected void setupView(ViewGroup v, Bundle savedInstanceState) {
        super.setupView(v, savedInstanceState);

        mData = getActivity().getIntent();
        if (mData != null && mData.getExtras() != null) {
            mLoginCallback = (LoginFragment.LoginCallback) ObjectSessionStore.popObject(mData.getExtras().getString("callback_key"));
        }

        mCloseView = (ImageView) findViewById(R.id.login_dialog_close_btn);
        mLoginBtn = (Button) findViewById(R.id.login_dialog_login_btn);
        mRegisterBtn = (Button) findViewById(R.id.login_dialog_register_btn);

        mCloseView.setOnClickListener(this);
        mLoginBtn.setOnClickListener(this);
        mRegisterBtn.setOnClickListener(this);

    }

    @Override
    public int getLayoutId() {
        return R.layout.login_dialog;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_dialog_close_btn:
                onBackPressed();
                break;
            case R.id.login_dialog_login_btn:
                FragmentContainer.showLoginFragment(getActivity(), mLoginCallback);
                onBackPressed();
                break;
            case R.id.login_dialog_register_btn:
                RegisterFragment.showRegisterFragment(this);
                onBackPressed();
                break;
        }
    }
}
