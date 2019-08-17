package android.example.insta_clone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

public class SignUp extends AppCompatActivity {

    private EditText edtUserNameSignUp ,
            edtPasswordSignUp;
    private Button btnSignUp2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        edtUserNameSignUp = findViewById(R.id.edtUsernameSignUp);
        edtPasswordSignUp = findViewById(R.id.edtPasswordSignUp);
        btnSignUp2 = findViewById(R.id.btnSignUp2);

        btnSignUp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final ParseUser appUser = new ParseUser();
                appUser.setUsername(edtUserNameSignUp.getText().toString());
                appUser.setPassword(edtPasswordSignUp.getText().toString());

                appUser.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if(e == null){
                            FancyToast.makeText(SignUp.this,
                                    appUser.get("username") + " is signed up successfully",
                                    FancyToast.LENGTH_LONG,FancyToast.SUCCESS,
                                    true).show();

                            Intent intent = new Intent(SignUp.this,
                                    WelcomeActivity.class);
                            startActivity(intent);

                        }else{
                            FancyToast.makeText(SignUp.this,
                                    e.getMessage(),FancyToast.LENGTH_LONG,
                                    FancyToast.ERROR,true).show();
                        }
                    }
                });
            }
        });
    }
}
