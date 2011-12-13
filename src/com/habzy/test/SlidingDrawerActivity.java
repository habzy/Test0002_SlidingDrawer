package com.habzy.test;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class SlidingDrawerActivity extends Activity implements
        SlidingTab.OnTriggerListener
{
    private static final String TAG = "SlidingDrawerActivity";
    
    /**
     * UI used for an incoming call
     */
    private SlidingTab mIncomingCallWidget;
    
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        mIncomingCallWidget = (SlidingTab) findViewById(R.id.incomingCallWidget);
        mIncomingCallWidget.setLeftTabResources(R.drawable.ic_jog_dial_answer,
                R.drawable.jog_tab_target_green,
                R.drawable.jog_tab_bar_left_answer,
                R.drawable.jog_tab_left_answer);
        mIncomingCallWidget.setRightTabResources(R.drawable.ic_jog_dial_decline,
                R.drawable.jog_tab_target_red,
                R.drawable.jog_tab_bar_right_decline,
                R.drawable.jog_tab_right_decline);
        
        // For now, we only need to show two states: answer and decline.
        mIncomingCallWidget.setRightHintText(R.string.slide_to_decline_hint);
        mIncomingCallWidget.setLeftHintText(R.string.slide_to_answer_hint);
        
        mIncomingCallWidget.setOnTriggerListener(this);
        
    }
    
    /**
     * Handles "Answer" and "Reject" actions for an incoming call. We get this
     * callback from the SlidingTab when the user triggers an action.
     * 
     */
    public void onTrigger(View v, int whichHandle)
    {
        Log.d(TAG, "onDialTrigger(whichHandle = " + whichHandle + ")...");
        
        switch (whichHandle)
        {
            case SlidingTab.OnTriggerListener.LEFT_HANDLE:
                Log.d(TAG, "LEFT_HANDLE: answer!");
                
                // hideIncomingCallWidget();
                
                break;
            
            case SlidingTab.OnTriggerListener.RIGHT_HANDLE:
                Log.d(TAG, "RIGHT_HANDLE: reject!");
                
                // hideIncomingCallWidget();
                
                break;
            
            default:
                Log.e(TAG, "onDialTrigger: unexpected whichHandle value: "
                        + whichHandle);
                break;
        }
        
    }
    
    @Override
    public void onGrabbedStateChange(View v, int grabbedState)
    {
        // TODO Auto-generated method stub
        
    }
}