package facitec.edu.py.op2francisco_amaral;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class MainActivity extends ActionBarActivity {
  private ListView servicioListView;
  private ServicioAdapter adapter;
  private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        servicioListView = (ListView)findViewById(R.id.listViewServicio);
        progressBar=(ProgressBar)findViewById(R.id.progressBar);

    }

    @Override
    protected void onResume() {
        super.onResume();

        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint("http://servidor-monkydevs.rhcloud.com").build();
        ServicioService servicio = restAdapter.create(ServicioService.class);
        servicio.getServicio(new Callback<List<Servicio>>() {


            @Override
            public void success(List<Servicio> servicios, Response response) {

                    adapter = new ServicioAdapter(servicios, getApplicationContext());
                    servicioListView.setAdapter(adapter);
                    progressBar.setVisibility(View.GONE);
                    servicioListView.setVisibility(View.VISIBLE);

            }

            @Override
            public void failure(RetrofitError retrofitError) {

                Toast.makeText(getApplicationContext(),"Algo fallo"+retrofitError.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
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
