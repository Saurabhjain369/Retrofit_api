package com.example.retrofit_api;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {




    Recycleadapter  adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Endpoint service = Retrofitclass.getRetrofitInstance().create(Endpoint.class);



        //ArrayList
/*
        Call<List<Pokemon>> call = service.getPokemon();

        call.enqueue(new Callback<List<Pokemon>>() {
            @Override
            public void onResponse(Call<List<Pokemon>> call, Response<List<Pokemon>> response) {


                generateData(response.body());


            }

            @Override
            public void onFailure(Call<List<Pokemon>> call, Throwable t) {


                Toast.makeText(getApplicationContext(),"Something we nrt wrong",Toast.LENGTH_SHORT).show();


            }
        });
*/


// Starting from Json object


        Call<Pokemonpojo> call =service.getPokemonobj();


        call.enqueue(new Callback<Pokemonpojo>() {
            @Override
            public void onResponse(Call<Pokemonpojo> call, Response<Pokemonpojo> response) {

                ArrayList<Pokemon> pokarray =new ArrayList<>();

                Pokemonpojo pokobj= response.body();


                try
                {

                    pokarray = new ArrayList<>(pokobj.getPokemon());

                    generateData(pokarray);

                }
                catch(NullPointerException e)
                {





                }

            }

            @Override
            public void onFailure(Call<Pokemonpojo> call, Throwable t) {



                Toast.makeText(getApplicationContext(),"Something went wrong in json object code",Toast.LENGTH_SHORT).show();
            }
        });






       }



       public void generateData(ArrayList<Pokemon> pokes  /*ist<Pokemon> poklist*/)

       {

/*
           ArrayList<Pokemon> poke = (ArrayList<Pokemon>) poklist;
*/

           adapter = new Recycleadapter(pokes,getApplicationContext());



           @SuppressLint("WrongConstant") LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
           RecyclerView recyclerView = findViewById(R.id.recycle_poke);
           recyclerView.setLayoutManager(manager);
           recyclerView.setAdapter(adapter);


       }


}
