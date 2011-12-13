package com.habzy.test;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.SlidingDrawer;

public class MyDrawer extends SlidingDrawer {

	public MyDrawer(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
    
	/**
     * 
     * (l,t)
     * _______________________________________________________________
     *|   /\ <======================width===========/\==============> |
     *|   ||                                        ||                |
     *|   ||                                      childTop            |
     *|   ||                                        ||                |     
     *|   ||                                    ____\/____     /\     |
     *|   ||               childLeft            |/////////|    ||     |
     *|   ||    <=============================> |//Child//|childHeight|  
     *| height                                  |//_//_//_|    ||     |
     *|   ||                                    childWidth     \/     |
     *|   ||                                    |<------->|           |
     *|   ||                                                          |
     *|   ||                                                          |
     *|___\/__________________________________________________________|(r,b)
     *   
     * 
     */
     @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b)
    {
        super.onLayout(changed, l, t, r, b);
        
//        final int width = r - l;
//        final int height = b - t;
        
        final View handle = getHandle();
        
//        float density = getContent().getResources().getDisplayMetrics().density;
        
        int childWidth = handle.getMeasuredWidth();
        int childHeight = handle.getMeasuredHeight();
//        int childLeft = isOpened() ? 0 : width - childWidth;
//        int childTop = (height - childHeight - (int) (12 * density));
        
        // handle.layout(childLeft, childTop, childLeft + childWidth, childTop
        // + childHeight);
        handle.layout(0, 0, childWidth, childHeight);
        
    }
	
}
