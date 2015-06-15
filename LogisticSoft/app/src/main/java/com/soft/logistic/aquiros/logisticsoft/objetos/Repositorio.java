package com.soft.logistic.aquiros.logisticsoft.objetos;

import java.util.ArrayList;
import java.util.Arrays;


public class Repositorio {

    public static ArrayList<ArrayList> clientes = new ArrayList<ArrayList>();
    static ArrayList C0 = new ArrayList(Arrays.asList(0,"Luis",1.5,7.0,10.0));
    static ArrayList C1 = new ArrayList(Arrays.asList(1,"Ricar",2.0,8.0,15.0));
    static ArrayList C2 = new ArrayList(Arrays.asList(2,"Maria",1.0,7.0,11.0));
    static ArrayList C3 = new ArrayList(Arrays.asList(3,"Ana",2.0,10.0,14.0));
    static ArrayList C4 = new ArrayList(Arrays.asList(4,"Juan",3.5,10.0,17.0));
    static ArrayList C5 = new ArrayList(Arrays.asList(5,"Ramon",2.5,8.0,13.0));
    static ArrayList C6 = new ArrayList(Arrays.asList(6,"Vera",3.0,13.0,18.0));
    static ArrayList C7 = new ArrayList(Arrays.asList(7,"Jaime",0.5,13.0,18.0));

    public static ArrayList<ArrayList> pedidos = new ArrayList<ArrayList>();
    static ArrayList p0 = new ArrayList(Arrays.asList(0,"Ana",8.0,2.0,0.0,-1));
    static ArrayList p1 = new ArrayList(Arrays.asList(1,"Ricar",10.0,2.0,0.0,-1));
    static ArrayList p2= new ArrayList(Arrays.asList(2,"Ana",15.0,2.0,0.0,-1));
    static ArrayList p3 = new ArrayList(Arrays.asList(3,"Maria",6.0,1.0,0.0,-1));
    static ArrayList p4 = new ArrayList(Arrays.asList(4,"Luis",11.0,1.5,0.0,-1));
    static ArrayList p5 = new ArrayList(Arrays.asList(5,"Juan",12.0,3.5,0.0,-1));
    static ArrayList p6 = new ArrayList(Arrays.asList(6,"Vera",20.0,3.0,0.0,-1));
    static ArrayList p7 = new ArrayList(Arrays.asList(7,"Jaime",11.0,0.5,0.0,-1));
    static ArrayList p8 = new ArrayList(Arrays.asList(8,"Ramon",19.0,2.5,0.0,-1));
    static ArrayList p9 = new ArrayList(Arrays.asList(9,"Maria",14.0,1.0,0.0,-1));
    static ArrayList p10 = new ArrayList(Arrays.asList(10,"Luis",7.0,1.5,0.0,-1));
    static ArrayList p11 = new ArrayList(Arrays.asList(11,"Jaime",9.0,0.5,0.0,-1));
    static ArrayList<ArrayList> pedidosCamion1 = new ArrayList<ArrayList>();
    static ArrayList<ArrayList> pedidosCamion2 = new ArrayList<ArrayList>();
    static ArrayList<ArrayList> pedidosCamion3 = new ArrayList<ArrayList>();
    static ArrayList<ArrayList> pedidosCamion0 = new ArrayList<ArrayList>();

    static ArrayList<ArrayList> camiones = new ArrayList<ArrayList>();
    static ArrayList c0 = new ArrayList(Arrays.asList(0,"camion0",80.0,0.0));
    static ArrayList c1 = new ArrayList(Arrays.asList(1,"camion1",60.0,0.0));
    static ArrayList c2 = new ArrayList(Arrays.asList(2,"camion2",50.0,0.0));
    static ArrayList c3 = new ArrayList(Arrays.asList(3,"camion3",40.0,0.0));

    static int [] camions = {110,80,50,40};
    static int [] volPorCamion = {0,0,0,0};

    static int [] camionsMin;

    public static void cargarDatos(){
        clientes.add(C1);
        clientes.add(C2);
        clientes.add(C3);
        clientes.add(C4);
        clientes.add(C5);
        clientes.add(C6);
        clientes.add(C7);
        clientes.add(C0);
        pedidos.add(p1);
        pedidos.add(p2);
        pedidos.add(p3);
        pedidos.add(p4);
        pedidos.add(p5);
        pedidos.add(p6);
        pedidos.add(p7);
        pedidos.add(p8);
        pedidos.add(p9);
        pedidos.add(p10);
        pedidos.add(p11);
        pedidos.add(p0);
        camiones.add(c0);
        camiones.add(c1);
        camiones.add(c2);
        camiones.add(c3);
    }
}
