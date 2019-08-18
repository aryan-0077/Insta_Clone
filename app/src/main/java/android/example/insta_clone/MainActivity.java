package android.example.insta_clone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;

import com.parse.ParseUser;

public class MainActivity extends AppCompatActivity {

    private Button btnSignUp;
    private Button btnLogin;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSignUp = findViewById(R.id.btnSignUp2);
        btnLogin = findViewById(R.id.btnLogin);


        try {
            findViewById(R.id.btnLogout).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ParseUser.logOut();
                    finish();
                }
            });
        }catch(Exception e){
            e.printStackTrace();
        }

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,
                        SignUp.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,
                        Login.class);
                startActivity(intent);
            }
        });
    }

//    public void HelloWorldTapped(View view){
//
//        ParseObject boxer = new ParseObject("Boxer");
//        boxer.put("punch_speed",200);
//        boxer.saveInBackground(new SaveCallback() {
//            @Override
//            public void done(ParseException e) {
//                if(e == null){
//                    FancyToast.makeText(MainActivity.this,
//                            "Hello World !",FancyToast.LENGTH_LONG,
//                            FancyToast.SUCCESS,true).show();
//                }
//            }
//        });
//    }

    public void rootTapped(View view){

        try{
            InputMethodManager inputMethodManager =
                    (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus()
                    .getWindowToken(), 0);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    private void transitionToSocialMediaActivity(){
        Intent intent = new Intent(MainActivity.this,
                SocialMediaActivity.class);
        startActivity(intent);
    }

}
