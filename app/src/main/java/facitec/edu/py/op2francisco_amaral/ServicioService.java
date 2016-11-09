package facitec.edu.py.op2francisco_amaral;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

public interface ServicioService {
    @GET("/servicio/posts.json")
    void getServicio(Callback<List<Servicio>> callback);

}