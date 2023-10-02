package com.example.tp1laboratorio3;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import model.Usuario;
import request.ApiClient;

public class MainActivityViewModel extends AndroidViewModel {

    private Context context;
    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        context=application;
    }
    public void registrarse(){
        Intent intent= new Intent(context, RegistroActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        context.startActivity(intent);
    }
    public void loggin(String mail, String pass){
        Usuario usuario=ApiClient.login(context, mail, pass);
        if(usuario==null){
            Toast.makeText(context, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
        }else{
            Intent intent= new Intent(context, RegistroActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra("Usuario", usuario);
            context.startActivity(intent);
        }

    }
}
