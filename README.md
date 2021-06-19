# widgets
Widget

# Define in xml:

```
<com.verma.android.verma_ui.widget.ui.RoundedImageView
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
        
# Or in code:
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

You must use the following properties in your XML to change your CircularImageView.
```
Properties	                        Type	                Default
app:civ_circle_color	                color	                WHITE
app:civ_circle_color_start	        color	                civ_circle_color
app:civ_circle_color_end	        color	                civ_circle_color
app:civ_color_direction	                left_to_right,          right_to_left, top_to_bottom or bottom_to_top	left_to_right
app:civ_border	                        boolean	                true
app:civ_border_width	                dimension	        4dp
app:civ_border_color	                color	                WHITE
app:civ_border_color_start	        color	                civ_border_color
app:civ_border_color_end	        color	                civ_border_color
app:civ_border_color_direction	        left_to_right,          right_to_left, top_to_bottom or bottom_to_top	left_to_right
app:civ_shadow	                        boolean	                false
app:civ_shadow_color	                color	                BLACK
app:civ_shadow_radius	                dimension	        8dp
app:civ_shadow_gravity	                center,                 top, bottom, start or end bottom
```

KOTLIN
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
JAVA
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

Transformation transformation = new RoundedTransformationBuilder()
          .borderColor(Color.BLACK)
          .borderWidthDp(3)
          .cornerRadiusDp(30)
          .oval(false)
          .build();

Picasso.with(context)
    .load(url)
    .fit()
    .transform(transformation)
    .into(imageView);
```
