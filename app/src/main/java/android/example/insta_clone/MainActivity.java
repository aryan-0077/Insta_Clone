package android.example.insta_clone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

public class MainActivity extends AppCompatActivity {

    private Button btnSignUp;
    private Button btnLogin;

    private EditText edtUserNameSignUp , getEdtUserNameLogin ,
        edtPasswordSignUp,edtPasswordLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSignUp = findViewById(R.id.btnSignUp);
        btnLogin = findViewById(R.id.btnLogin);

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
}
