package net.macdidi.note;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ItemActivity extends AppCompatActivity {

    private EditText title_text, content_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        processViews();
        Intent intent = getIntent();
        String action = intent.getAction();
        if (action.equals("net.macdidi.note.EDIT_ITEM")){    //<--- here should be the mistake
            String titleText =intent.getStringExtra("titleText");
            title_text.setText(titleText);
        }
    }

    private void processViews(){
        title_text = (EditText)findViewById(R.id.title_text);
        content_text = (EditText)findViewById(R.id.enter_content);
    }

    public void onSubmit(View view){
        //ok or cancel button
        if (view.getId() == R.id.ok_teim){
            //read input title and content
            String titleText = title_text.getText().toString(); //read entered title info
            String contentText = content_text.getText().toString(); //read entered content info
            Intent result = getIntent(); //take info
            result.putExtra("titleText", titleText); //set title and content
            result.putExtra("contentText", contentText);

            setResult(Activity.RESULT_OK, result); //set reply result to ok
        }
        finish();
    }

    public  void clickFunction(View view){
        int id = view.getId();

        switch (id){
            case R.id.take_picture:
                break;
            case R.id.record_sound:
                break;
            case R.id.set_location:
                break;
            case R.id.set_alarm:
                break;
            case R.id.select_color:
                break;
        }
    }


}
