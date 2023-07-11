package pdm.pratica09;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;


public class MainActivity extends AppCompatActivity {

    /*private static final String [] cities = {
            "Recife", "João Pessoa", "Natal", "Fortaleza", "Rio de Janeiro",
            "São Paulo", "Salvador", "Vitória", "Florianópolis", "Porto Alegre",
            "São Luiz","Teresina", "Belém", "Manaus"};*/

   /* public static final City [] cities = {
            new City("Maceió", "Capital de Alagoas"),
            new City("Recife", "Capital de Pernambuco"),
            new City("João Pessoa", "Capital da Paraíba"),
            new City("Natal", "Capital do Rio Grande do Norte"),
            new City("Fortaleza", "Capital do Ceará"),
            new City("Salvador","Capital da Bahia"),
            new City("São Luiz","Capital do Maranhão"),
            new City("Teresina","Capital do Piauí"),
            new City("Rio de Janeiro", "Capital do Rio de Janeiro"),
            new City("São Paulo","Capital de São Paulo"),
            new City("Vitória","Capital do Espirito Santo"),
            new City("Belo Horizonte","Capital do Minas Gerais"),
            new City("Florianópolis","Capital de Santa Catarina"),
            new City("Curitiba","Capital do Paraná"),
            new City("Porto Alegre","Capital do Rio Grande do Sul"),
            new City("Macapá","Capital do Amapá"),
            new City("Porto Velho","Capital de Rondônia"),
            new City("Palmas","Capital do Tocantins"),
            new City("Boa Vista","Capital do Roraima"),
            new City("Belém","Capital do Pará"),
            new City("Rio Branco","Capital do Acre"),
            new City("Manaus","Capital do Amazonas"),
            new City("Goiania","Capital do Goias"),
            new City("Cuiabá","Capital do Mato Grosso"),
            new City("Campo Grande","Capital do Mato Grosso do Sul") };*/

    public static final City [] cities = {
            new City("Maceió"),
            new City("Recife"),
            new City("João Pessoa"),
            new City("Natal"),
            new City("Fortaleza"),
            new City("Salvador"),
            new City("São Luiz"),
            new City("Teresina"),
            new City("Rio de Janeiro"),
            new City("São Paulo"),
            new City("Vitória"),
            new City("Belo Horizonte"),
            new City("Florianópolis"),
            new City("Curitiba"),
            new City("Porto Alegre"),
            new City("Macapá"),
            new City("Porto Velho"),
            new City("Palmas"),
            new City("Boa Vista"),
            new City("Belém"),
            new City("Rio Branco"),
            new City("Manaus"),
            new City("Goiania"),
            new City("Cuiabá"),
            new City("Campo Grande") };

    private RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.queue = Volley.newRequestQueue(this);

        ListView listView = (ListView)findViewById(R.id.list_view);
        /*listView.setAdapter(new ArrayAdapter<>(this,
                R.layout.city_listitem,
                R.id.city_name, cities ) );*/
        listView.setAdapter(new CityAdapter(this, R.layout.city_listitem, queue, cities ));

        listView.setOnItemClickListener((
                parent, view, position, id) ->

                /*Toast.makeText(parent.getContext(),
                "Cidade selecionada: " + cities[position], Toast.LENGTH_SHORT).show());*/
                Toast.makeText(parent.getContext(),
                        "Cidade selecionada: " + cities[position].getName(), Toast.LENGTH_SHORT).show());


    }

    @Override
    public void onStop() {
        super.onStop();
        queue.cancelAll(this);
    }
}