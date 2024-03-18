# widgets
Widgets

## Dependency

### Step 1. Add the JitPack repository to your build file ###

Add it in your root build.gradle at the end of repositories:

``` Groovy
allprojects {
    repositories {
        ...
        maven { url "https://jitpack.io" }
    }
}
```

### Step 2. Add the dependency ###

``` Groovy
dependencies {
   implementation 'com.github.vermasourav:Widgets:2.0.0'
}
```


## RoundedImageView Setup

### Define in xml:

```
<com.verma.android.widgets.RoundedImageView
        xmlns:app="http://schemas.android.com/apk/res-auto"
        android:id="@+id/imageView1"
        android:src="@drawable/photo1"
        android:scaleType="fitCenter"
        app:riv_corner_radius="30dip"
        app:riv_border_width="2dip"
        app:riv_border_color="#333333"
        app:riv_mutate_background="true"
        app:riv_tile_mode="repeat"
        app:riv_oval="true" />
 ```       

### Or in code:
```
    RoundedImageView riv = new RoundedImageView(context);
    riv.setScaleType(ScaleType.CENTER_CROP);
    riv.setCornerRadius((float) 10);
    riv.setBorderWidth((float) 2);
    riv.setBorderColor(Color.DKGRAY);
    riv.mutateBackground(true);
    riv.setImageDrawable(drawable);
    riv.setBackground(backgroundDrawable);
    riv.setOval(true);
    riv.setTileModeX(Shader.TileMode.REPEAT);
    riv.setTileModeY(Shader.TileMode.REPEAT);
```
================================

## CircularImageView  Setup

You must use the following properties in your XML to change your CircularImageView.

```
    Properties	Type	Default
    app:civ_circle_color	color	WHITE
    app:civ_circle_color_start	color	civ_circle_color
    app:civ_circle_color_end	color	civ_circle_color
    app:civ_color_direction	left_to_right, right_to_left, top_to_bottom or bottom_to_top	left_to_right
    app:civ_border	boolean	true
    app:civ_border_width	dimension	4dp
    app:civ_border_color	color	WHITE
    app:civ_border_color_start	color	civ_border_color
    app:civ_border_color_end	color	civ_border_color
    app:civ_border_color_direction	left_to_right, right_to_left, top_to_bottom or bottom_to_top	left_to_right
    app:civ_shadow	boolean	false
    app:civ_shadow_color	color	BLACK
    app:civ_shadow_radius	dimension	8dp
    app:civ_shadow_gravity	center, top, bottom, start or end	bottom
```

### Or in code: KOTLIN

```
val circularImageView = findViewById<CircularImageView>(R.id.circularImageView)
circularImageView.apply {
    // Set Color
    circleColor = Color.WHITE
    // or with gradient
    circleColorStart = Color.BLACK
    circleColorEnd = Color.RED
    circleColorDirection = CircularImageView.GradientDirection.TOP_TO_BOTTOM

    // Set Border
    borderWidth = 10f
    borderColor = Color.BLACK
    // or with gradient
    borderColorStart = Color.BLACK
    borderColorEnd = Color.RED
    borderColorDirection = CircularImageView.GradientDirection.TOP_TO_BOTTOM

    // Add Shadow with default param
    shadowEnable = true
    // or with custom param
    shadowRadius = 7f
    shadowColor = Color.RED
    shadowGravity = CircularImageView.ShadowGravity.CENTER
}
```

### Or in code: KOTLIN JAVA

```
    CircularImageView circularImageView = findViewById(R.id.circularImageView);
    // Set Color
    circularImageView.setCircleColor(Color.WHITE);
    // or with gradient
    circularImageView.setCircleColorStart(Color.BLACK);
    circularImageView.setCircleColorEnd(Color.RED);
    circularImageView.setCircleColorDirection(CircularImageView.GradientDirection.TOP_TO_BOTTOM);
    
    // Set Border
    circularImageView.setBorderWidth(10f);
    circularImageView.setBorderColor(Color.BLACK);
    // or with gradient
    circularImageView.setBorderColorStart(Color.BLACK);
    circularImageView.setBorderColorEnd(Color.RED);
    circularImageView.setBorderColorDirection(CircularImageView.GradientDirection.TOP_TO_BOTTOM);
    
 
```

## ExPinView Setup

Provides a widget for enter PIN/OTP/password etc

<p><img src="Screenshots/Screenshort_2.png" width="35%" />
<img src="Screenshots/Screenshort_3.png" width="35%" /></p>


### Usage

PinView inherits from EditText, which means you can use all the APIs from EditText.

#### Step 1:

Add PinView in your layout.

#### XML Code

``` xml

     <com.verma.android.widgets.ExPinView
            android:id="@+id/firstPinView"
            style="@style/exPinWidget.exPinView"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:cursorVisible="true"
            android:hint="Hint."
            android:inputType="text"
            android:itemBackground="@mipmap/ic_launcher"
            android:padding="@dimen/ex_pv_common_padding"
            android:textColor="@color/ex_pv_text_colors"
            android:textSize="18sp"
            android:textStyle="bold"
            app:cursorColor="@color/ex_pv_line_selected"
            app:cursorWidth="2dp"
            app:itemCount="5"
            app:itemHeight="48dp"
            app:itemRadius="4dp"
            app:itemSpacing="0dp"
            app:itemWidth="48dp"
            app:lineColor="@color/ex_pv_line_colors"
            app:lineWidth="2dp"
            app:viewType="rectangle">
        </com.verma.android.widgets.ExPinView>
        
```

#### Java Code

``` Java


  final ExPinView pinView = findViewById(R.id.secondPinView);
        pinView.setTextColor(ResourcesCompat.getColor(getResources(), R.color.colorAccent, getTheme()));
        pinView.setTextColor(ResourcesCompat.getColorStateList(getResources(), com.verma.android.widgets.R.color.ex_pv_text_colors, getTheme()));
        pinView.setLineColor(ResourcesCompat.getColor(getResources(), R.color.colorPrimary, getTheme()));
        pinView.setLineColor(ResourcesCompat.getColorStateList(getResources(), com.verma.android.widgets.R.color.ex_pv_line_colors, getTheme()));
        pinView.setItemCount(4);
        pinView.setItemHeight(getResources().getDimensionPixelSize(com.verma.android.widgets.R.dimen.ex_pv_pin_view_item_size));
        pinView.setItemWidth(getResources().getDimensionPixelSize(com.verma.android.widgets.R.dimen.ex_pv_pin_view_item_size));
        pinView.setItemRadius(getResources().getDimensionPixelSize(com.verma.android.widgets.R.dimen.ex_pv_pin_view_item_size));
        pinView.setItemSpacing(getResources().getDimensionPixelSize(com.verma.android.widgets.R.dimen.ex_pv_pin_view_item_size));
        pinView.setLineWidth(getResources().getDimensionPixelSize(com.verma.android.widgets.R.dimen.ex_pv_pin_view_item_size));
        pinView.setAnimationEnable(true);// start animation when adding text
        pinView.setCursorVisible(false);
        pinView.setCursorColor(ResourcesCompat.getColor(getResources(), com.verma.android.widgets.R.color.ex_pv_line_selected, getTheme()));
        pinView.setCursorWidth(getResources().getDimensionPixelSize(com.verma.android.widgets.R.dimen.ex_pv_pin_view_cursor_width));  
        
        pinView.addTextChangedListener(new TextWatcher() {...});
       
        pinView.setItemBackgroundColor(Color.BLACK);
        pinView.setItemBackground(getResources().getDrawable(com.verma.android.widgets.R.drawable.ex_pv_item_background));
        pinView.setItemBackgroundResources(com.verma.android.widgets.R.drawable.ex_pv_item_background);
        pinView.setHideLineWhenFilled(false);
        pinView.setPasswordHidden(false);
        pinView.setTransformationMethod(new PasswordTransformationMethod());
```

#### Step 2:

Specifies `pinViewStyle` in your theme,

``` xml
<style name="AppTheme" parent="Theme.AppCompat.Light">
    ...
    <item name="exPinViewStyle">@style/exPinWidget.exPinView</item>
</style>
```

or use the `exPinWidget.exPinView` style.

``` xml
    <com.verma.android.widgets.ExPinView
        android:id="@+id/pinView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        style="@style/exPinWidget.exPinView" />
```

#### Step 3 (Optional):

To highlight current item, use 'selected' state, in other words,

add `android:state_selected="true"` to `app:lineColor`

``` xml
<selector xmlns:android="http://schemas.android.com/apk/res/android">
    <!-- Use for the item to be input, set the value as the default to disable it -->
    <item android:color="@color/ex_pv_line_selected" android:state_selected="true" />
    <item android:color="@color/ex_pv_line_focused" android:state_focused="true" />
    <item android:color="@color/ex_pv_line_default" />
</selector>
```

or add `android:cursorVisible="true"`.

### Attributes

* **itemCount**, the length of your pin code.
* **itemWidth**, the width of each item.
* **itemHeight**, the height of each item.
* **itemSpacing**, the spacing between two items.
* **lineWidth**, the line (border) width.
* **lineColor**, the line (border) colors.
* **viewType**, the view type of PinView, currently this will be one of `rectangle`, `line` or `none`.
* **cursorVisible**, show cursor or not.
* **cursorColor**, the cursor color.
* **cursorWidth**, the width of cursor.
* **itemBackground**, the item background.
* **hideLineWhenFilled**, specifies whether the line (border) should be hidden or visible when text entered.



## Screenshots
<p>
    <img src="Screenshots/Screenshort_1.png" width="35%" />
    <img src="Screenshots/Screenshort_2.png" width="35%" />
    <img src="Screenshots/Screenshort_3.png" width="35%" />
    <img src="Screenshots/Screenshort_4.png" width="35%" />
    <img src="Screenshots/Screenshort_5.png" width="35%" />

</p>

 
## Thanks

## License
