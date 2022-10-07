package com.example.sendmessagebinding.UI;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.sendmessagebinding.R;
import com.example.sendmessagebinding.SendMessageApplication;
import com.example.sendmessagebinding.data.Message;
import com.example.sendmessagebinding.databinding.ActivitySendMessageBinding;

/**
 * <h1>Proyecto SendMessage</h1>
 * En este proyecto aprenderemos a realizar las siguientes operaciones
 * <ol>
 *     <li>Crear un evento en un componente Button en código XML</li>
 *     <li>Crear un escuchador/listener del evento OnClick()</li>
 *     <li>Crear un Intent y un elemento Bundle para pasar información entre Activity</li>
 *     <li>El ciclo de vida de una Activity</li>
 *     <li>Manejar la pila de Actividades</li>
 * </ol>
 * @author Fernando Escaño Martín
 * @version 1.0
 * @see android.widget.Button
 * @see android.app.Activity
 * @see android.content.Intent
 * @see android.os.Bundle
 */
public class SendMessageActivity extends AppCompatActivity {

    private static final String TAG = "SendMessageActivity";
    private ActivitySendMessageBinding binding;
    //private SendMessageOnClickListener delegate;

    @Override
    /*
    * Método que se ejecuta cuando se crea la Activity
    */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySendMessageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Se inicializa el delegado
        //delegate = new SendMessageOnClickListener();
        //Se establece el vínculo entre el Botón y su delegado
        //btSend.setOnClickListener(delegate);

        // Establecer el Listener OnClickListener al botón mediante una clase anónima que implementa
        //la interfaz View.OnClickListener
        binding.setMessage(new Message(((SendMessageApplication)getApplication()).getUser()));
        binding.btSend.setOnClickListener(view -> sendMessage());
                //view -> Toast.makeText(SendMessageActivity.this, "Esto es un evento", Toast.LENGTH_SHORT).show());
        Log.d(TAG, "SendMessageActivity -> onCreate()");
    }

    /**
     *  Este método callback crea el menú de opciones en la vista. Se devuelve true para indicar al
     *  SO que se ha realizado la opcion de modificar el menú.
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /**
     * Este método callback se llama cuando se pulsa sobre una dee las opciones del menú de la
     * aplicación
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.action_aboutus:
                //Toast.makeText(this, "Se ha pulsado sobre About Us", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, AboutUsActivity.class);
                startActivity(intent);
                break;
        }
        return true;
    }

    //region CICLO DE VIDA DE LA ACTIVIDAD
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "SendMessageActivity -> onStart()");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "SendMessageActivity -> onResume()");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "SendMessageActivity -> onPause()");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "SendMessageActivity -> onStop()");
    }
    /*
     * Este método se ejecuta cuando se destruye la Activity
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
        Log.d(TAG, "SendMessageActivity -> onDestroy()");
    }
    //endregion

    /*/**
     * Este método es el que se llama cuando se pulsa sobre el botón btSend definido en el XML
     * android:onClick="sendMessage"
     * @param view

    public void sendMessage(View view) {
        sendMessage();
    }*/

    public void sendMessage() {
        //TODO Se modificará este ejercicio para estudiar ViewBinding
        //Toast.makeText(this, "Hemos pulsado el botón", Toast.LENGTH_SHORT).show();
        //1º Crear el contenedor para añadir los datos
        Bundle bundle = new Bundle();
        //1.1 Pasar campo a campo
        //bundle.putString("user", binding.getMessage().getUser().getName());
        //bundle.putString("message", binding.getMessage().getContent());
        //1.2 Crear un objeto Message
        //Message message = new Message(binding.etUser.getText().toString(), binding.etMessage.getText().toString());
        bundle.putParcelable("message", binding.getMessage());
        //2º Vamos a crear el objeto Intent explícito porque se conoce la Actividad destino
        Intent intent = new Intent(this, ViewMessageActivity.class);
        intent.putExtras(bundle);
        //3º Inicia la transicion de una vista a otra mediante StartActivity
        startActivity(intent);
    }
/*
    /**
     * Esta clase NO es anónima e implementa el listener que responde siempre al evento
     * onClick

    class SendMessageOnClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Toast.makeText(SendMessageActivity.this, "Esto es un evento", Toast.LENGTH_SHORT).show();
        }
    }*/
}

