package com.verma.android.verma_ui.widget.ui.dashboard;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.verma.android.verma_ui.R;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

public class TableDashBoard {
    private final String TAG = this.getClass().getSimpleName();
    public static class DATA {
        public DATA(String name, String imageURL , Long serviceId) {
            this.name = name;
            this.imageURL = imageURL;
            this.serviceId = serviceId;
        }

        private String name;
        private String imageURL;
        private Long serviceId;


        public Long getServiceId() {
            return serviceId;
        }

        public DATA setServiceId(Long serviceId) {
            this.serviceId = serviceId;
            return this;
        }


        public String getName() {
            return name;
        }

        public DATA setName(String name) {
            this.name = name;
            return this;
        }

        public String getImageURL() {
            return imageURL;
        }

        public DATA setImageURL(String imageURL) {
            this.imageURL = imageURL;
            return this;
        }

    }

    public static List<DATA> testData(){
        List<DATA> data = new ArrayList<>();
        String companies[] = {
                "Windows",
                "iPhone",
                "Nokia",
                "Samsung",
                "Google",
                "Windows",
                "iPhone",
                "Nokia",
                "Samsung",
                "Google",
                "Windows",
                "iPhone",
                "Nokia",
                "Samsung"
        };
        for (int i=0; i<companies.length;i++){
            DATA data1 = new DATA(companies[i],"https://upload.wikimedia.org/wikipedia/commons/thumb/7/72/Noto_Emoji_Oreo_1f405.svg/800px-Noto_Emoji_Oreo_1f405.svg.png",Long.getLong(i+""));
            data.add(data1);
        }

        return data;

    }

    private Context mContext              =   null;
    private TableLayout tableLayout       =   null;
    private int MAX_COLUMN                =   2;
    @ColorInt
    public int TEXT_COLOR                 =   Color.WHITE;
    @ColorInt
    public  int TEXT_COLOR_BACKGROUND     =   Color.BLUE;
    @ColorInt
    public  int BACKGROUND_FOCCUS     =   Color.LTGRAY;


    public  int IMAGE_SIZE      =   60;
    public  int TEXT_SIZE       =   12;

    public TableDashBoard withImageSize(int IMAGE_SIZE) { this.IMAGE_SIZE = IMAGE_SIZE;return this;}
    public TableDashBoard withTextSize(int TEXT_SIZE) { this.TEXT_SIZE = TEXT_SIZE;return this;}


    private List<DATA> data = new ArrayList<>();




    public int getTextColor() { return TEXT_COLOR;}
    public void setTextColor(@ColorInt int TEXT_COLOR) {
        this.TEXT_COLOR = TEXT_COLOR;
    }
    public TableDashBoard withTextColor(@ColorInt int TEXT_COLOR) { this.TEXT_COLOR = TEXT_COLOR;return this;}



    public int getFocusColor() { return BACKGROUND_FOCCUS;}
    public void setFocusColor(@ColorInt int BACKGROUND_FOCCUS) {
        this.BACKGROUND_FOCCUS = BACKGROUND_FOCCUS;
    }
    public TableDashBoard withFocusColor(@ColorInt int BACKGROUND_FOCCUS) { this.BACKGROUND_FOCCUS = BACKGROUND_FOCCUS;return this;}





    public int getTextBackgroundColor() { return TEXT_COLOR_BACKGROUND;}
    public void seTextBackgroundColor(@ColorInt int TEXT_COLOR_BACKGROUND) {this.TEXT_COLOR_BACKGROUND = TEXT_COLOR_BACKGROUND;}
    public TableDashBoard withTextBackgroundColor(@ColorInt int TEXT_COLOR_BACKGROUND) { this.TEXT_COLOR_BACKGROUND = TEXT_COLOR_BACKGROUND;return this;}


    public List<DATA> geData() {
        return data;
    }

    public void setData(List<DATA> data) {
        this.data = data;
    }

    public TableDashBoard withData(List<DATA> data) {
        setData(data);
    return this;
    }



    protected Set<OnClickListener> listeners;
    public interface OnClickListener{
        public void onClick(View pView, int textId, int imageId, Long serviceId);
        public void OnFocusChange(View pView, int textId, int imageId, boolean hasFocus, Long serviceId);
    }

    public void addListener(OnClickListener l) {
        listeners.add(l);
    }

    public View getFirstElement(){
             return  firstLayout;
    }
    public int getMaxColumn() {
        return MAX_COLUMN;
}

    public void setMaxColumn(int NUMBER_OF_ROW) {
        this.MAX_COLUMN = NUMBER_OF_ROW;
    }

    public TableDashBoard withMaxColumn(int pMaxRow) {
        this.MAX_COLUMN = pMaxRow;
        return this;
    }

    public TableLayout getTableLayout() {
        return tableLayout;
    }

    public void setTableLayout(TableLayout tableLayout) {
        this.tableLayout = tableLayout;
    }

    public TableDashBoard withTableLayout(TableLayout tableLayout) {
        this.tableLayout = tableLayout;
        return this;
    }

    public Context getContext() {
        return mContext;
    }

    public void setContext(Context context) {
        this.mContext = context;
    }

    public TableDashBoard withContext(Context context) {
        this.mContext = context;
        return this;
    }


    public TableDashBoard(){
        listeners = new HashSet<OnClickListener>();
    }


    public TableDashBoard(Context pContext, TableLayout pTableLayout){
        mContext = pContext;
        tableLayout = pTableLayout;
        listeners = new HashSet<OnClickListener>();

    }

    private final int IMAGE_CONSTANT = 1117;
    private final int TEXT_CONSTANT = 1100009;

    private void notifyClickToAll(View pView, Long dataId) {
        if(null == pView){
            Log.d(TAG, "notifyClickToAll: view is null ");
            return;
        }
         for(OnClickListener listener : listeners) {
             int id = pView.getId();
             listener.onClick(pView, id*TEXT_CONSTANT ,id*IMAGE_CONSTANT, dataId );
        }
    }

    private void notifyFocusChangeToAll(View pView, boolean hasFocus, Long dataId) {
        if(null == pView){
            Log.d(TAG, "notifyFocusChangeToAll: view is null ");
            return;
        }
        for(OnClickListener listener : listeners) {
            int id = pView.getId();
            listener.OnFocusChange(pView, id*TEXT_CONSTANT ,id*IMAGE_CONSTANT, hasFocus,dataId);
        }

    }

    private TextView getTextView(int id, String title, int color, int typeface, int bgColor) {
        TextView tv = new TextView(mContext);
        tv.setId(id);
        tv.setText(title.toUpperCase());
        tv.setTextColor(color);
        tv.setPadding(convertDpToPixel(5), convertDpToPixel(5), convertDpToPixel(5), convertDpToPixel(5));
        tv.setTypeface(Typeface.DEFAULT, typeface);
        tv.setTextSize(TEXT_SIZE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) { //>= API 17
            tv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
         } else {
            tv.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
        }

        tv.setBackgroundColor(bgColor);

        TableRow.LayoutParams paramsText = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT);
        paramsText.gravity = Gravity.CENTER_HORIZONTAL;
        paramsText.topMargin= convertDpToPixel(5);


        tv.setLayoutParams(paramsText);
        // tv.setOnClickListener(this);
        return tv;
    }

    private void setImage(ImageView imageView){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) { //>= API 21
            imageView.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_default_icon, mContext.getApplicationContext().getTheme()));
        } else {
            imageView.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_default_icon));
        }
    }




    private ImageView getImageView(int id, String pUrl) {
        ImageView imageView = new ImageView(mContext);
        imageView.setId(id*100);
       // imageView.setImageDrawable(mContext.getDrawable(R.drawable.ic_default_icon));

         //imageView.setOnClickListener(this);

        //TableRow.LayoutParams params = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,convertDpToPixel(50));
        TableRow.LayoutParams params = new TableRow.LayoutParams(convertDpToPixel(IMAGE_SIZE),convertDpToPixel(IMAGE_SIZE));
        params.gravity = Gravity.CENTER_HORIZONTAL;

        imageView.setLayoutParams(params);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setAdjustViewBounds(true);

        return imageView;


    }


    private LinearLayout getItemsView(int id, final DATA title, int color, int typeface, int bgColor) {
        LinearLayout dataLayout  = new LinearLayout(mContext);
        dataLayout.setFocusableInTouchMode(true);

        dataLayout.setId(id);
        if(id==1){
            dataLayout.requestFocus();
        }
        dataLayout.setOrientation(LinearLayout.VERTICAL);
        TableRow.LayoutParams dataLayoutParams = new TableRow.LayoutParams(0, TableRow.LayoutParams.MATCH_PARENT,  1.0f);
        dataLayout.setLayoutParams(dataLayoutParams);
        dataLayout.setGravity(Gravity.CENTER);

        ImageView imageView = getImageView(id*IMAGE_CONSTANT,title.imageURL);

        if(TextUtils.isEmpty(title.imageURL)){
            setImage(imageView);
        }else{
            new ImageSupport().setImageWithGlide(getContext(), title.imageURL, imageView);
        }

        TextView textView =getTextView(id *TEXT_CONSTANT, title.name, color,typeface,bgColor);

        dataLayout.addView(imageView);
        dataLayout.addView(textView);

        //dataLayout.setBackgroundColor(mContext.getColor(android.R.color.transparent));


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) { //>= API 21
            dataLayout.setBackgroundColor(mContext.getColor(android.R.color.transparent));
         } else {
            dataLayout.setBackgroundColor(ContextCompat.getColor(mContext, android.R.color.transparent));
         }

        dataLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: ---");
                v.requestFocus();
                notifyClickToAll(v, title.serviceId);
            }
        });

        dataLayout.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.d(TAG, "onFocusChange: ----");
                notifyFocusChangeToAll(v, hasFocus,title.serviceId);
                if(hasFocus){
                    notifyClickToAll(v, title.serviceId);
                }
            }
        });

        return dataLayout;
    }


    private int convertDpToPixel(float dp) {
        DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
        float px = dp * (metrics.densityDpi / 160f);
        return Math.round(px);
    }


    @NonNull
    private TableLayout.LayoutParams getTblLayoutColumnParams() {
        TableLayout.LayoutParams params = new TableLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);

      //params.setMargins(convertDpToPixel(5),convertDpToPixel(5),convertDpToPixel(5),convertDpToPixel(5));
        //params.weight = 1.0f;
        // params.gravity = Gravity.CENTER_HORIZONTAL;
        return params;
    }

    @NonNull
    private TableLayout.LayoutParams getTblLayoutRowParams() {
        TableLayout.LayoutParams params = new TableLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT);
        params.gravity = Gravity.CENTER_HORIZONTAL;
        return params;
    }


    /**
     * This function add the DATA to the table
     **/

    private LinearLayout firstLayout;
    public void showUI() {
         if(null == data){
            return;
        }
        int numCompanies = data.size();


        for (int i = 0; i <numCompanies; i++) {
            TableRow tr = new TableRow(mContext);
            tr.setLayoutParams(getTblLayoutRowParams());
            //tr.setId(i);
            for (int column = 0; column< MAX_COLUMN; column++){
                try {
                    DATA name = data.get(i);
                    LinearLayout layout = getItemsView(getRowId() , name, TEXT_COLOR, Typeface.NORMAL, TEXT_COLOR_BACKGROUND);
                    tr.addView(layout);
                    if(i==0 && column ==0){
                        firstLayout = layout;
                    }

                    if(column != MAX_COLUMN -1){
                        i++;
                    }

                }catch (Exception e) {
                    Log.d(TAG, "showUI: "+ e.toString());
                }

            }
            try {
                if(null!= tableLayout){
                    tableLayout.addView(tr, getTblLayoutColumnParams());
                }else{
                    Log.d(TAG, "showUI: tableLayout is null");
                }
            }catch (Exception e){
                Log.e(TAG, "showUI: "+e.toString());
                e.printStackTrace();
            }

        }
    }

    public static int ROW_START_ID = 100001;
    private int ROW_ID = ROW_START_ID;
    public int getRowId(){
        return ROW_ID++;
    }


    private void testApplication(){
        TableDashBoard dashBoardCreater =
                new TableDashBoard()
                        .withContext(getContext())
                        .withMaxColumn(3)
                        .withData(TableDashBoard.testData())
                        .withTextBackgroundColor(Color.BLUE)
                        .withTextColor(Color.WHITE)
                        //.withTableLayout((TableLayout) findViewById(R.id.table))
                        .withTextSize(12)
                        .withImageSize(60)
                ;
        dashBoardCreater.showUI();

        dashBoardCreater.addListener(new TableDashBoard.OnClickListener() {
            @Override
            public void onClick(View pView, int textId, int imageId, Long serviceId) {
                if(null == pView){
                    Log.d(TAG, "dashBoardCreater.addListener: onClick: view is null ");
                    return;
                }
                int id = pView.getId();
                Log.i("onClick", "Clicked on Items :: " + id);
                LinearLayout layout = null;
                //layout = findViewById(id);
                if (null != layout) {
                    TextView textView = layout.findViewById(textId);
                    if (null != textView) {
                        Log.d(TAG, "onClick: " + id + ", Text :: " + textView.getText());

                        Toast.makeText(getContext(), "Clicked on Items :: " + id + ", Text :: " + textView.getText(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void OnFocusChange(View pView, int textId, int imageId, boolean hasFocus, Long serviceId) {
                if(null == pView){
                    Log.d(TAG, "dashBoardCreater.OnFocusChange: view is null ");
                    return;
                }

                int id = pView.getId();
                Log.i("OnFocusChange", "OnFocusChange on Items :: " + id + "  "+hasFocus);
                LinearLayout layout = null;
                //layout = findViewById(id);
                if(hasFocus){
                    layout.setBackgroundColor(BACKGROUND_FOCCUS);
                    if (null != layout) {
                        TextView textView = layout.findViewById(textId);
                        if (null != textView) {
                            Log.d(TAG, "OnFocusChange: " + id + ", Text :: " + textView.getText());
                        }
                    }
                }else{
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) { //>= API 21
                        layout.setBackgroundColor(mContext.getColor(android.R.color.transparent));
                    } else {
                        layout.setBackgroundColor(ContextCompat.getColor(mContext, android.R.color.transparent));
                    }
                    //layout.setBackgroundColor(getContext().getColor(android.R.color.transparent));

                }
            }
        });

    }

}
