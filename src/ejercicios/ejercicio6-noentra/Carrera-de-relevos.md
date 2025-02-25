# **Ejercicio: Carrera de relevos con hilos en Java**

## **Objetivo**
Implementar un programa en Java que simule una carrera de relevos utilizando **hilos**. Cuatro corredores competirán, pero solo uno correrá a la vez, y cada uno deberá esperar a que el anterior termine antes de comenzar.

## **Requisitos**
- Habrá **cuatro corredores**, cada uno representado por un hilo (`Thread`).
- Solo un corredor podrá **correr** a la vez. El resto esperará su turno.
- Una vez que un corredor termina, **da paso al siguiente** y finaliza su ejecución.
- Cuando el último corredor termine, el **hilo principal** (`main`) imprimirá un mensaje indicando que la carrera ha finalizado.

## **Restricciones**
- Cada corredor deberá simular el tiempo de carrera usando `Thread.sleep()` con un tiempo aleatorio.

## **Ejemplo de ejecución**
```text
Todos los hilos creados.
¡Doy la salida!
Soy el corredor 1, corriendo...
Terminé.
Soy el corredor 2, corriendo...
Terminé.
Soy el corredor 3, corriendo...
Terminé.
Soy el corredor 4, corriendo...
Terminé.
Todos los hilos terminaron.
```

## **Pautas para la implementación**
1. Crear una clase `Corredor` que extienda `Thread`. Cada corredor debe:
    - Esperar a que el corredor anterior termine antes de iniciar su ejecución.
    - Imprimir mensajes de estado antes y después de correr.
    - Simular el tiempo de carrera con `Thread.sleep()`.

2. En la clase `Relevos` (clase principal):
    - Crear y lanzar los cuatro hilos.
    - Asegurar que corran en orden utilizando `join()`.
    - Imprimir los mensajes correspondientes en `main`.



