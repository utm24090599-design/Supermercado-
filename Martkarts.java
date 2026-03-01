/* 
Un pequeño supermercado dispone en la salida de tres cajas de pago. En el local hay 25 carritos de compra. Escribir un programa 
que simule el funcionamiento, siguiendo las siguientes reglas:
    a. SI cuando llega un cliente no hay ningún carrito disponible, espera a que lo haya.
    b. Ningún cliente se impaciente y abandona el supermercado sin pasar por alguna de las colas de las cajas.
    c. Cuando un cliente finaliza su compra, se coloca en la cola de la caja que hay menos gente, y no se cambia de cola.
    d. En el momento en que un cliente paga en la caja, su carrito de compra queda disponible. 
*/

import java.util.Random;

public class Martkarts {

    public static void main(String[] args) throws InterruptedException {

        Random random = new Random();

        int carritos = 25; // maximo de carros
        int people = 0; // gente en el super
        int max_people = 29; // maximo de gente
        int max_clientes_gi = random.nextInt(5) + 1;// maximo de personas que pueden llegar

        // Cajas
        int c1 = 0;
        int c2 = 0;
        int c3 = 0;

        while (people < max_people) {

            max_clientes_gi = random.nextInt(4) + 1;  

            if (carritos >= max_clientes_gi) {

                people += max_clientes_gi;
                carritos -= max_clientes_gi;

                System.out.println("Gente en el market: " + people);
                System.out.println("Carritos restantes: " + carritos);

                for (int i = 0; i < max_clientes_gi; i++) {

                    if (c1 <= c2 && c1 <= c3) {
                        c1++;
                        System.out.println("Cliente se formó en Caja 1");
                    } else if (c2 <= c1 && c2 <= c3) {
                        c2++;
                        System.out.println("Cliente se formó en Caja 2");
                    } else {
                        c3++;
                        System.out.println("Cliente se formó en Caja 3");
                    }
                }

                System.out.println("Colas -> C1: " + c1 + " C2: " + c2 + " C3: " + c3);

            } else {

                System.out.println("No hay carritos, aguanta..");

                Thread.sleep(3000);

                // Simulamos que alguien paga y libera carrito
                if (c1 > 0) {
                    c1--;
                } else if (c2 > 0) {
                    c2--;
                } else if (c3 > 0) {
                    c3--;
                }

                carritos++;
                people--;

                System.out.println("Un cliente pagó y liberó carrito.");
                System.out.println("Carritos disponibles: " + carritos);
            }

            Thread.sleep(1500);
        }

        System.out.println("Supermercado lleno.");
    }
}
=======

    c1 -> 7
    c2 -> 7
    c3 -> 2

    carritos = 25
    max_clientes_gi = 5
    max_people = 30

                                            /--yes-> carritos -1.
    a. cliente -> arrive -> <Hay carritos?>|                        /César
                                            \--no-> esperar carrito.
    
    b. cliente -> arrive_cola -> espera_cola. /Juan

                    /--1-> move.
    c. <who_hless?>| --2-> move. /Yo
                    \--3-> move.

    d. clente -> left -> carrtios + 1. /Jose luis
*/
import java.util.Random;;
public class Martkarts {



  



    public static void main(String[] args) throws InterruptedException {

    Random random = new Random();

    int carritos = 25; // maximo de carros
    int people = 0; //gente en el super
    int max_people = 29; // maximo de gente
    int max_clientes_gi = random.nextInt(5) + 1;// maximo de personas que pueden llegar

    while (people < max_people) {

    max_clientes_gi = random.nextInt(4) + 1;  

    if (carritos >= max_clientes_gi) {

        people += max_clientes_gi;
        carritos -= max_clientes_gi;

        System.out.println("Gente en el market: " + people);
        System.out.println("Carritos restantes: " + carritos);

    } else {

        System.out.println("No hay  carritos, aguanta..");

        Thread.sleep(3000);  

        carritos++; 
        System.out.println("Un cliente termino su compra y se fue alv, 1 Carrito libre .");
    }
}










        
    }

    
}
>>>>>>> da34df2ed64a1b59a40651528be78f0c7e1a3c82
