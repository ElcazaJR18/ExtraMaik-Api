package mx.edu.utez.extramike.model;

import mx.edu.utez.extramike.utils.Response;

import java.util.List;

public interface Repository <T>{

    Response<List> puntoUno();

    Response<List> puntoDos();

    Response<List> puntoTres();

    Response<List> puntoCuatro();

    Response<List> puntoCinco();

    Response<Integer> puntoSeis();

    Response<List> puntoSiete();

    Response<Double> puntoOcho();

    Response<List> puntoNueve();

    Response<String> puntoDiez();

}
