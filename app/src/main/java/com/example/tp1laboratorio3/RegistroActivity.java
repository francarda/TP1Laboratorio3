package com.example.tp1laboratorio3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.tp1laboratorio3.databinding.ActivityRegistroBinding;

import model.Usuario;

public class RegistroActivity extends AppCompatActivity {
private ActivityRegistroBinding binding;
private RegistroActivityViewModel vm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityRegistroBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        vm= ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(RegistroActivityViewModel.class);
        vm.getUsuarioM().observe(this, new Observer<Usuario>() {
            @Override
            public void onChanged(Usuario usuario) {
                binding.etApellido.setText(usuario.getApellido());
                binding.etDni.setText(usuario.getDni());
                binding.etMailRegistro.setText(usuario.getMail());
                binding.etNombre.setText(usuario.getNombre());
                binding.etpassRegistro.setText(usuario.getPassword());
            }
        });

    }
}