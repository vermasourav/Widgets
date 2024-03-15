/*
 * Created by: V3RMA SOURAV on 14/03/24, 10:41 pm
 * Copyright © 2023 All rights reserved
 * Class name : Corner
 * Last modified:  14/03/24, 10:41 pm
 * Location: Bangalore, India
 */

package com.verma.android.widgets.roundedimageview;


import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
@IntDef({
        Corner.TOP_LEFT, Corner.TOP_RIGHT,
        Corner.BOTTOM_LEFT, Corner.BOTTOM_RIGHT
})
public @interface Corner {
    int TOP_LEFT = 0;
    int TOP_RIGHT = 1;
    int BOTTOM_RIGHT = 2;
    int BOTTOM_LEFT = 3;
}
