package com.soft.logistic.aquiros.logisticsoft.objetos;

import java.util.ArrayList;

public class OrdenadorPedidos {

    /**
     * Ordena una matriz de pedidos
     * @param matriz
     * @param col
     * @return una lista con la matriz ordenada
     */
    public static ArrayList<ArrayList> ordenarMatriz(ArrayList<ArrayList> matriz, int col)
    {
        for(int i = 0; i < matriz.size(); i++)
        {
            for(int j = i; j < matriz.size(); j++)
            {
                if (Double.parseDouble(matriz.get(i).get(col).toString()) > Double.parseDouble(matriz.get(j).get(col).toString()))
                {
                    ArrayList elem1 = matriz.get(i);
                    ArrayList elem2 = matriz.get(j);
                    matriz.set(i,elem2);
                    matriz.set(j,elem1);
                }
            }
        }
        return matriz;
    }

    /**
     * sacar el volumen total de los pedidos
     * @return
     */
    public static double volTotalPedidos()
    {
        double total = 0;
        for(int i = 0; i < Repositorio.pedidos.size(); i++)
        {
            total = total + Double.parseDouble(Repositorio.pedidos.get(i).get(2).toString());
        }
        return total;
    }

    /**
     * Mete el pedido en el camion
     * @param pedido
     * @param camion
     * @return true si logra meter el pedido
     */
    public static boolean meterEnCamion(int pedido, int camion)
    {
        double vol = Double.parseDouble(Repositorio.pedidos.get(pedido).get(2).toString());
        double volOcup = Double.parseDouble(Repositorio.camiones.get(camion).get(3).toString());
        if((vol+volOcup)<= Double.parseDouble(Repositorio.camiones.get(camion).get(2).toString()))
        {
            Repositorio.camiones.get(camion).set(3, volOcup+vol);
            return true;
        }
        return false;
    }

    /**
     * Llena el camion de paquetes
     */
    public static void llenarCamiones()
    {
        Repositorio.pedidos = ordenarMatriz(Repositorio.pedidos, 3);
        for(int i = 0; i < Repositorio.pedidos.size(); i++)
        {
            if(meterEnCamion(i, 0)) {
                Repositorio.pedidos.get(i).set(5, 0);
            }
            else if (meterEnCamion(i, 1)) {
                Repositorio.pedidos.get(i).set(5, 1);
            }
            else if (meterEnCamion(i, 2)) {
                Repositorio.pedidos.get(i).set(5, 2);
            }
            else if (meterEnCamion(i, 3)) {
                Repositorio.pedidos.get(i).set(5, 3);
            }
        }
    }

    public static int pedidosEntregados()
    {
        int total = 0;
        for(int i = 0; i < Repositorio.pedidos.size(); i++)
        {
            if(Double.parseDouble(Repositorio.pedidos.get(i).get(4).toString())<=0.0) {
            } else {
                total++;
            }
        }
        return total;
    }

    /**
     * Realiza la entrega de un pedido
     * @param pedido
     * @param hora
     */
    public static void entregarPedido(int pedido, double hora)
    {
        String cliente = Repositorio.pedidos.get(pedido).get(1).toString();
        int i=0;
        while (i<Repositorio.clientes.size())
        {
            if(cliente == Repositorio.clientes.get(i).get(1))
            {
                if(Double.parseDouble(Repositorio.pedidos.get(pedido).get(4).toString())==0){
                    if(hora>=Double.parseDouble(Repositorio.clientes.get(i).get(3).toString()) &&
                            hora<=Double.parseDouble(Repositorio.clientes.get(i).get(4).toString()))
                    {
                        Repositorio.pedidos.get(pedido).set(4, hora);
                    }
                }
            }
            i++;
        }
    }

    /**
     * Busca la forma de
     * @param Pedidos
     */
    public static void entregarPedidos(ArrayList<ArrayList> Pedidos)
    {
        Pedidos = ordenarMatriz(Pedidos, 3);
        int i=0;
        double t = 7.0+Double.parseDouble(Pedidos.get(0).get(3).toString());
        while(pedidosEntregados()< Pedidos.size())
        {
            while (i<Pedidos.size())
            {
                entregarPedido(i, t);
                i++;
                if(i<Pedidos.size()) {
                    t=t+ Double.parseDouble(Pedidos.get(i).get(3).toString() )- Double.parseDouble(Pedidos.get(i-1).get(3).toString());
                }
            }
            t = t+Double.parseDouble(Pedidos.get(Pedidos.size()-1).get(3).toString())-Double.parseDouble(Pedidos.get(Pedidos.size()-2).get(3).toString());
            int j = Pedidos.size()-1;

            while (j>=0)
            {
                entregarPedido(j, t);
                if (j>0){
                    t = t+ Double.parseDouble(Pedidos.get(j).get(3).toString())-Double.parseDouble(Pedidos.get(j-1).get(3).toString());
                }
                j--;
            }
        }
    }

    /**
     * Imprime una matriz
     * @param m
     */
    public static void imprimirMatriz(ArrayList<ArrayList> m)
    {
        for(int i = 0; i < m.size(); i++)
        {
            System.out.println(m.get(i));
        }
    }
}
