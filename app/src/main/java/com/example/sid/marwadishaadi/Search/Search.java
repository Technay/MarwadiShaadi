package com.example.sid.marwadishaadi.Search;

import android.animation.ObjectAnimator;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarChangeListener;
import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarFinalValueListener;
import com.crystal.crystalrangeseekbar.widgets.CrystalRangeSeekbar;
import com.example.sid.marwadishaadi.R;

public class Search extends AppCompatActivity {

    EditText spinnerCastSearch;
    Button mOpenIDSearchButton;
    private static int casebreak;
    TextView statetextView,tvCollapse;
    CardView advCV;
    Button addButton;
    private static final String TAG = "Search";
    ListView castList;
    EditText autoCompleteState;
    static String  addTextState,addPrevious="";
    public SQLiteDatabase db;
    boolean tvCollapsestate=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        tvCollapse=(TextView)findViewById(R.id.collapse);
        addButton=(Button)findViewById(R.id.search_add_state);
        statetextView=(TextView)findViewById(R.id.text_view_search_add_state);
        spinnerCastSearch=(EditText) findViewById(R.id.search_user_caste);
        autoCompleteState=(EditText)findViewById(R.id.search_state);
        advCV=(CardView)findViewById(R.id.advanced_search);
        final CrystalRangeSeekbar rangeSeekbar = (CrystalRangeSeekbar) findViewById(R.id.rangeSeekbar);
// get min and max text view
        final TextView tvMin = (TextView) findViewById(R.id.textMin);
        final TextView tvMax = (TextView) findViewById(R.id.textMax);
        rangeSeekbar.setMinValue(18);
        rangeSeekbar.setMaxValue(71);
        advCV.setVisibility(View.GONE);
        tvCollapsestate=false;


// set listener
        tvCollapse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tvCollapsestate)
                {
                    advCV.setVisibility(View.GONE);
                    tvCollapsestate=false;
                }
                else if(!tvCollapsestate)
                {
                    advCV.setVisibility(View.VISIBLE);
                    advCV.setFocusable(true);
                    tvCollapsestate=true;
                }

            }
        });

        rangeSeekbar.setOnRangeSeekbarChangeListener(new OnRangeSeekbarChangeListener() {
            @Override
            public void valueChanged(Number minValue, Number maxValue) {
                tvMin.setText(String.valueOf(minValue));
                tvMax.setText(String.valueOf(maxValue));
            }
        });


        // set final value listener
        rangeSeekbar.setOnRangeSeekbarFinalValueListener(new OnRangeSeekbarFinalValueListener() {
            @Override
            public void finalValue(Number minValue, Number maxValue) {
                Log.d("CRS=>", String.valueOf(minValue) + " : " + String.valueOf(maxValue));
            }
        });
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addTextState = autoCompleteState.getText().toString();
                if(addTextState.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Please click + button after state selection ",Toast.LENGTH_SHORT).show();
                }
                else {

                    statetextView.setTextSize(TypedValue.COMPLEX_UNIT_SP,18);
                    statetextView.setText(addPrevious+"\n"+addTextState);
                    addPrevious=statetextView.getText().toString();
                    autoCompleteState.setText("");
                    Toast.makeText(getApplicationContext(),"Added successfully ", Toast.LENGTH_SHORT).show();
                }
            }
        });
        mOpenIDSearchButton = (Button) findViewById(R.id.search_by_id_name_open);
        mOpenIDSearchButton.setFocusable(true);
        spinnerCastSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                casebreak=1;
                BottomSheetDialogFragment btm= new BottomSheet();
                btm.show(getSupportFragmentManager(),btm.getTag());

            }
        });

        mOpenIDSearchButton = (Button) findViewById(R.id.search_by_id_name_open);
        mOpenIDSearchButton.setFocusable(true);
        mOpenIDSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                casebreak=2;
                //  Toast.makeText(getApplicationContext(),Integer.toString(getCasebreak())+" does this worked or not", Toast.LENGTH_LONG).show();
                BottomSheetDialogFragment bottomSheetDialogFragment = new BottomSheet();
                bottomSheetDialogFragment.show(getSupportFragmentManager(), bottomSheetDialogFragment.getTag());

            }
        });
        Button search=(Button)findViewById(R.id.search_Submit);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(dataChecker())
                {

                }
                else{
                    Toast.makeText(getApplicationContext(),"Please fill all search details correct",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public int getCasebreak()
    {
        return this.casebreak;
    }
    boolean dataChecker()
    {
        return false;
    }
}
