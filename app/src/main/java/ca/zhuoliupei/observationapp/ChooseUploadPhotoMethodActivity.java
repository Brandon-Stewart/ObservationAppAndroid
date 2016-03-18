package ca.zhuoliupei.observationapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;


/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class ChooseUploadPhotoMethodActivity extends Activity {

    public static final int CHOOSE_PHOTO_FROM_CAMERA =1;
    public static final int CHOOSE_PHOTO_FROM_GALARY =2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_upload_method);
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        addOnClickListeners();
    }

    private void addOnClickListeners(){
        addLinearLayoutOnClick();
        addUploadFromGallaryOnClick();
        addTakePhotoOnClick();
    }
    private void addLinearLayoutOnClick(){
        findViewById(R.id.root_LL_ChooseUploadPhotoMethodActivity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                setResult(RESULT_CANCELED, intent);
                finish();
            }
        });
    }
    private void addTakePhotoOnClick(){
        findViewById(R.id.imgTakeAPhoto_ChooseUploadMethodActivity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.putExtra("result",CHOOSE_PHOTO_FROM_CAMERA);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
    private void addUploadFromGallaryOnClick(){
        findViewById(R.id.imgUploadFromGallary_ChooseUploadMethodActivity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.putExtra("result",CHOOSE_PHOTO_FROM_GALARY);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

}