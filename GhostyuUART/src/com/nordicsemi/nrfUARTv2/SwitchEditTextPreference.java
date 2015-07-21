package com.nordicsemi.nrfUARTv2;

import android.content.Context;
import android.preference.EditTextPreference;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Switch;

public class SwitchEditTextPreference extends EditTextPreference implements OnCheckedChangeListener{
	
	private static final String KEY_ADD_REPORT = "add_report";
	private static final String KEY_HOUR_REPORT = "hour_report";
	private static final String KEY_EQUATION_REPORT = "equation_report";
	
	private Switch mSwitch;

	public SwitchEditTextPreference(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	protected void onBindView(View view) {
		super.onBindView(view);
		mSwitch = (Switch)view.findViewById(R.id.prf_switch);
		mSwitch.setOnCheckedChangeListener(this);
		if (getSummary().equals("0")) {
			mSwitch.setChecked(false);
		} else {
			mSwitch.setChecked(true);
		}
		Utils.log("onbindView : switch = " +mSwitch);
	}
	
	@Override
	protected void onClick() {
//		if (mSwitch.isChecked()) {
			super.onClick();
//		}
	}

	@Override
	public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
		// TODO Auto-generated method stub
		
	}
	
	public void setChecked(boolean on) {
//		mSwitch.setChecked(on);
	}
}
