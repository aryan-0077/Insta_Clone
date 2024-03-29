package android.example.insta_clone;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.shashank.sony.fancytoastlib.FancyToast;

public class Login extends AppCompatActivity {

    private EditText  edtUserNameLogin ,
            edtPasswordLogin;
    private Button btnLogin2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        edtUserNameLogin = findViewById(R.id.edtUsernameLogin);
        edtPasswordLogin = findViewById(R.id.edtPasswordLogin);
        btnLogin2 = findViewById(R.id.btnLogin);

        final ProgressDialog progressDialog = new ProgressDialog(Login.this);

        if (ParseUser.getCurrentUser() != null){
            transitionToSocialMediaActivity();
        }

        btnLogin2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ParseUser.logInInBackground(edtUserNameLogin.getText().toString(),
                        edtPasswordLogin.getText().toString(),
                        new LogInCallback() {
                            @Override
                            public void done(ParseUser user, ParseException e) {
                                if(user != null && e == null){
                                    FancyToast.makeText(Login.this,
                                             user.get("username") + " Logged in successfully",
                                            FancyToast.LENGTH_LONG,FancyToast.SUCCESS,
                                            true).show();


                                    progressDialog.setMessage("Loging Up  " + edtUserNameLogin.getText().toString());
                                    progressDialog.show();

                                    Intent intent = new Intent(Login.this,
                                            WelcomeActivity.class);
                                    startActivity(intent);
                                    transitionToSocialMediaActivity();

                                }else{
                                    FancyToast.makeText(Login.this,
                                            e.getMessage(),FancyToast.LENGTH_LONG,
                                            FancyToast.ERROR,true).show();
                                }
                                progressDialog.dismiss();
                            }
                        });


            }
        });
    }

    private void transitionToSocialMediaActivity(){
        Intent intent = new Intent(Login.this,
                SocialMediaActivity.class);
        startActivity(intent);
    }
}
