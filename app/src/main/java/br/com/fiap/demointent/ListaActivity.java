package br.com.fiap.demointent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListaActivity extends AppCompatActivity {

    private ListView lvVersaoAndroid;
    private String versaoAndroidSelecionada = "";

    /*
     *  android.R --> Acessa bibliotecas nativas do proprio android
     *  R. --> Faz referencia aos xmls do meu projeto
     *
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        lvVersaoAndroid = (ListView)findViewById(R.id.lvVersaoAndroid);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                getResources().getStringArray(R.array.versoesAndroid));

        lvVersaoAndroid.setAdapter(adapter);

        lvVersaoAndroid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                versaoAndroidSelecionada = (String)lvVersaoAndroid.getItemAtPosition(position);

                Intent i = new Intent();
                i.putExtra("versaoAndroid", versaoAndroidSelecionada);

                setResult(RESULT_OK, i);

                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lista, menu);
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
