package com.danielvelastegui.deberpetagram.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.danielvelastegui.deberpetagram.R;
import com.danielvelastegui.deberpetagram.adapter.MascotasAdapter;
import com.danielvelastegui.deberpetagram.contenedor.Mascota;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    ArrayList<Mascota> misMascotas = new ArrayList<>();
    ArrayList<Mascota> mascotasGustadas = new ArrayList<>();
    MascotasAdapter adaptador;
    private RecyclerView rvMascotas;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        rvMascotas = v.findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        rvMascotas.setLayoutManager(llm);

        crearMascotas();
        inicializarRV();
        return v;
    }

    private void crearMascotas(){
        misMascotas.add(new Mascota(R.drawable.ic_mascota01, "Bruno"));
        misMascotas.add(new Mascota(R.drawable.ic_mascota02, "Jack"));
        misMascotas.add(new Mascota(R.drawable.ic_mascota3, "Paco"));
        misMascotas.add((new Mascota(R.drawable.ic_mascota4, "Hercules")));
    }

    private void inicializarRV(){
        adaptador = new MascotasAdapter(misMascotas, getActivity(), mascotasGustadas);
        rvMascotas.setAdapter(adaptador);
    }
}