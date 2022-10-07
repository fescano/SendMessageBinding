package com.example.sendmessagebinding;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.sendmessagebinding.data.User;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

public class SendMessageApplication extends Application {
    // Usuario que ha iniciado sesion. DATO GLOBAL porque siempre se va a poder acceder a él
    // mediante el método getApplication().getUser()
    private User user;
    @Override
    public void onCreate() {
        super.onCreate();
        Logger.addLogAdapter(new AndroidLogAdapter());
        Logger.d("Se ha inicializado el objeto Application");
        user = new User("fescano", "al.fernando.escano.martin@iesportada.org");
    }
    public User getUser() {
        return user;
    }
}
