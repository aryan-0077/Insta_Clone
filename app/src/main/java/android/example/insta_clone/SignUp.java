package android.example.insta_clone;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
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

        edtPasswordSignUp.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent KeyEvent) {
                if(i == KeyEvent.KEYCODE_ENTER && KeyEvent.getAction()
                == KeyEvent.ACTION_DOWN){

                    //onclick(btnSignUp2);
                }
                return false;
            }
         });

        if (ParseUser.getCurrentUser() != null){
            transitionToSocialMediaActivity();
        }

        btnSignUp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(edtUserNameSignUp.getText().toString().equals("") || edtPasswordSignUp.getText().toString().equals("")){
                    FancyToast.makeText(SignUp.this,
                            "Empty Fields not Allowed ",FancyToast.LENGTH_LONG,
                            FancyToast.INFO,true).show();
                }else{
                    final ParseUser appUser = new ParseUser();
                    appUser.setUsername(edtUserNameSignUp.getText().toString());
                    appUser.setPassword(edtPasswordSignUp.getText().toString());

                    final ProgressDialog progressDialog = new ProgressDialog(SignUp.this);
                    progressDialog.setMessage("Signing Up  " + edtUserNameSignUp.getText().toString());
                    progressDialog.show();

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
                                transitionToSocialMediaActivity();

                            }else{
                                FancyToast.makeText(SignUp.this,
                                        e.getMessage(),FancyToast.LENGTH_LONG,
                                        FancyToast.ERROR,true).show();
                            }

                            progressDialog.dismiss();
                        }
                    });
                }

            }
        });
    }

    public void rootSignUpTapped(View view){

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
        Intent intent = new Intent(SignUp.this,
                SocialMediaActivity.class);
        startActivity(intent);
    }
}
