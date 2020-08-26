
package com.cesarbarragan.petgram.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cesarbarragan.petgram.Adaptadores.ContactoAdaptador;
import com.cesarbarragan.petgram.POJO.ContactoPerritos;
import com.cesarbarragan.petgram.Presentador.FragmentPerritosPresenter;
import com.cesarbarragan.petgram.Presentador.IFragmentPerritosPresenter;
import com.cesarbarragan.petgram.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentPerritos#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentPerritos extends Fragment  implements IFrafmentPerritosView{

    //ArrayList<ContactoPerritos> contactoPerritos;
    private RecyclerView ListadeContactos;
    private IFragmentPerritosPresenter presenter;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentPerritos() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentPerritos.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentPerritos newInstance(String param1, String param2) {
        FragmentPerritos fragment = new FragmentPerritos();
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
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_perritos, container, false);

        //InicializarContactos();

        ListadeContactos = (RecyclerView) v.findViewById(R.id.rvContactos);

        presenter = new FragmentPerritosPresenter(this,getContext());

        return v;
    }

/*
    public void InicializarContactos(){
        contactoPerritos = new ArrayList<>();

        contactoPerritos.add(new ContactoPerritos("Spike", R.drawable.perrito1,0));
        contactoPerritos.add(new ContactoPerritos("Nina", R.drawable.perrito2,1));
        contactoPerritos.add(new ContactoPerritos("Huesito", R.drawable.perrito3,2));
        contactoPerritos.add(new ContactoPerritos("Oso", R.drawable.perrito4,3));
        contactoPerritos.add(new ContactoPerritos("Precioso", R.drawable.perrito5,4));
        contactoPerritos.add(new ContactoPerritos("Comelon", R.drawable.perrito6,5));
        contactoPerritos.add(new ContactoPerritos("Blastois", R.drawable.perrito7,6));
        contactoPerritos.add(new ContactoPerritos("Rino", R.drawable.perrito8,7));
    }
*/

    @Override
    public void genearLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        ListadeContactos.setLayoutManager(llm);
    }

    @Override
    public ContactoAdaptador CrearContactoAdaptador(ArrayList<ContactoPerritos> contactoPerritos) {
        ContactoAdaptador contactoAdaptador = new ContactoAdaptador(contactoPerritos,getActivity());
        return contactoAdaptador;
    }

    @Override
    public void inicializarAdaptadorRV(ContactoAdaptador adaptador) {
        ListadeContactos.setAdapter(adaptador);
    }
}