package com.it5.swiprefreshmore.demo;

import com.dinuscxj.refresh.IDragDistanceConverter;

/**
 * Created by IT5 on 2016/11/28.
 */

public class DragDistanceConverterEg implements IDragDistanceConverter {

    @Override
    public float convert(float scrollDistance, float refreshDistance) {
        return scrollDistance * 0.5f;
    }
}
