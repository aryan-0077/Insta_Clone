package android.example.insta_clone;

import android.app.Application;

import com.parse.Parse;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("mm3jvz49LdIsTaLsRUNciKo8b08gwlPpWPgu2Zsu")
                // if defined
                .clientKey("yMTqgEBLbKbL9EnvJatBQYbenvflI8yeEfJZLFIl")
                .server("https://parseapi.back4app.com/")
                .build()
        );
    }
}
