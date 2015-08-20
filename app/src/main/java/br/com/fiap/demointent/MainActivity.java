package br.com.fiap.demointent;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btAlterarVersao;
    private TextView tvVersaoAndroid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btAlterarVersao = (Button)findViewById(R.id.btAlterarVersao);
        tvVersaoAndroid = (TextView)findViewById(R.id.tvVersaoAndroid);


        btAlterarVersao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ListaActivity.class);
                startActivityForResult(i, 1);
            }
        });
    }

    public void abrirCadastroPessoaFisica(View view){
        Intent i = new Intent("br.com.fiap.demointentcadastro.action.CADASTRO");
        i.addCategory("br.com.fiap.demointentcadastro.action.PESSOA_FISICA");

        startActivity(i);
    }

    public void abrirCadastroPessoaJuridica(View view){
        Intent i = new Intent("br.com.fiap.demointentcadastro.action.CADASTRO");
        i.addCategory("br.com.fiap.demointentcadastro.action.PESSOA_JURIDICA");

        startActivity(i);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){

        if(resultCode == RESULT_OK &&
                requestCode == 1){

            /* pode dar nullpointer */
            if(data.hasExtra("versaoAndroid")) {
                //tvVersaoAndroid.setTypeface(null, Typeface.BOLD);
                //tvVersaoAndroid.setTextColor(Color.YELLOW);

                tvVersaoAndroid.setText(data.getStringExtra("versaoAndroid"));
                // ou data.getExtras().getString("versaoAndroid"));
            }
        }



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
