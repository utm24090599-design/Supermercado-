/* 
Un pequeño supermercado dispone en la salida de tres cajas de pago. En el local hay 25 carritos de compra. Escribir un programa 
que simule el funcionamiento, siguiendo las siguientes reglas:
    a. SI cuando llega un cliente no hay ningún carrito disponible, espera a que lo haya.
    b. Ningún cliente se impaciente y abandona el supermercado sin pasar por alguna de las colas de las cajas.
    c. Cuando un cliente finaliza su compra, se coloca en la cola de la caja que hay menos gente, y no se cambia de cola.
    d. En el momento en que un cliente paga en la caja, su carrito de compra queda disponible. 
*/

import java.util.Random;
import java.util.LinkedList;
import java.util.Queue;

public class Martkarts {

    public static void main(String[] args) throws InterruptedException {

        Random random = new Random();

        int carritos = 25; // maximo de carros
        int people = 0; // gente en el super
        int people_in = 0;
        int carritosDisponibles = carritos;

        // Cajas
        Queue<Integer> caja1 = new LinkedList<>();
        Queue<Integer> caja2 = new LinkedList<>();
        Queue<Integer> caja3 = new LinkedList<>();

        int time_to_close = 20000;
        long tiempoInicio = System.currentTimeMillis();

        while (System.currentTimeMillis() - tiempoInicio < time_to_close) {

            int max_clientes_gi = random.nextInt(5) + 1;// maximo de personas que pueden llegar

            System.out.println("--- Nueva ronda ---");
            System.out.println("Clientes que llegan: " + max_clientes_gi);
            System.out.println("Carritos disponibles: " + carritosDisponibles);

            if (carritosDisponibles >= max_clientes_gi) {

                for (int i = 0; i < max_clientes_gi; i++) {

                    // Tomar un carrito
                    carritosDisponibles--;

                    // PUNTO c: Colocar en la cola con menos gente
                    Queue<Integer> colaElegida = elegirColaMenosGente(caja1, caja2, caja3);
                    colaElegida.add(1); // Agregar cliente a la cola

                    String nombreCaja = "";
                    if (colaElegida == caja1)
                        nombreCaja = "Caja 1";
                    else if (colaElegida == caja2)
                        nombreCaja = "Caja 2";
                    else
                        nombreCaja = "Caja 3";

                    System.out.println("  Cliente " + (people + i + 1) +
                            " tomó carrito y se formó en " + nombreCaja);
                }

                people_in += caja1.size() + caja2.size() + caja3.size();
                people += max_clientes_gi;

            } else {
                System.out.println("No hay carritos, aguanta.. (" + carritosDisponibles +
                        " disponibles, necesitan " + max_clientes_gi + ")");
                System.out.println("Clientes esperando...");

                Thread.sleep(2000);

                boolean seLiberoCarrito = false;

                if (!caja1.isEmpty()) {
                    caja1.poll();
                    carritosDisponibles++;
                    people_in--;
                    seLiberoCarrito = true;
                    System.out.println("Cliente de la caja 1 termino de pagar.");
                } else if (!caja2.isEmpty()) {
                    caja2.poll();
                    carritosDisponibles++;
                    people_in--;
                    seLiberoCarrito = true;
                    System.out.println("Cliente de la caja 1 termino de pagar.");
                } else if (!caja3.isEmpty()) {
                    caja3.poll();
                    carritosDisponibles++;
                    people_in--;
                    seLiberoCarrito = true;
                    System.out.println("Cliente de la caja 1 termino de pagar.");
                }
                if (seLiberoCarrito) {
                    System.out.println(" Carritos ahora disponibles: " + carritosDisponibles);
                } else {
                    System.out.println(" No hay clientes esperando para pagar.");
                }
            }
        }

        System.out.println("Supermercado Cerrado. Los " + people_in + " clientes han sido evacuados educadamente");

    }

    private static Queue<Integer> elegirColaMenosGente(Queue<Integer> c1, Queue<Integer> c2, Queue<Integer> c3) {
        if (c1.size() <= c2.size() && c1.size() <= c3.size()) {
            return c1;
        } else if (c2.size() <= c1.size() && c2.size() <= c3.size()) {
            return c2;
        } else {
            return c3;
        }
    }

}