package BenchMe.src.main.java;
/*public class PrionCloud{  // TODO: templatize PrionClound
    public int n_nodes;
    public GCounter[] data_nodes;   // thread UNSAFE!!!!
    private static final boolean print_debug_info = false;

    public PrionCloud(int n_nodes_in){
        n_nodes = n_nodes_in;
        data_nodes = new GCounter[n_nodes];
        for (int i_node=0; i_node<n_nodes; ++i_node){
            data_nodes[i_node] = new GCounter(n_nodes);
        }
    }

    public void online(int interval_ms){
        PropagatingThread propagating = new PropagatingThread(this, interval_ms);
        propagating.start();
    }

    public void propagate() {
        data_nodes[1] = data_nodes[1].merge(data_nodes[0]);
        data_nodes[0] = data_nodes[0].merge(data_nodes[1]);
    }


    public GCounter get(int i_node){
        GCounter dd = data_nodes[i_node];
        dd.hosted_node_id = i_node;
        if (print_debug_info) {
            System.out.println(">>>>>>");
        }
        return dd;
    }

    public void put(GCounter dd, int i_node){ // dd: distributed data
        if (print_debug_info) {
            System.out.println("<<<<<<");
        }
        data_nodes[i_node] = data_nodes[i_node].merge(dd);
    }
    public void put(GCounter dd){ // dd: distributed data
        if (print_debug_info) {
            System.out.println("<<<<<<");
        }
        data_nodes[0] = data_nodes[0].merge(dd);
    }
}*/

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;

public class PrionCloud<T extends Replica>{  // TODO: templatize PrionClound
    public T[] data_nodes;      // thread UNSAFE!!!!
    private static final boolean print_debug_info = false;

    public PrionCloud(int n_nodes, Class<T> cls){
        data_nodes = (T[]) Array.newInstance(cls, n_nodes);
        try {
            for(int i=0; i<n_nodes; ++i){
                    data_nodes[i] =  cls.getDeclaredConstructor(int.class).newInstance(n_nodes);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    /// use this construct if you want to manually pass in all replicas
    public PrionCloud(T[] r_array){
        data_nodes = r_array;
    }

    public void online(int interval_ms){
        PropagatingThread propagating = new PropagatingThread(this, interval_ms);
        propagating.start();
    }

    /// only work for two nodes
    public void propagate() {
        data_nodes[1] = data_nodes[1].merge(data_nodes[0]);
        data_nodes[0] = data_nodes[0].merge(data_nodes[1]);
    }


    public T get(int i_node){
        T dd = data_nodes[i_node];
        dd.hosted_node_id = i_node;
        if (print_debug_info) {
            System.out.println(">>>>>>");
        }
        return dd;
    }

    public void put(T dd, int i_node){ // dd: distributed data
        if (print_debug_info) {
            System.out.println("<<<<<<");
        }
        data_nodes[i_node] = data_nodes[i_node].merge(dd);
    }
}
