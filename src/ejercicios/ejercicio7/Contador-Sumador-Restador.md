# Implementación de un contador con hilos en Java

## Objetivo
Se debe desarrollar una aplicación en Java que maneje un contador compartido entre dos tipos de hilos: un sumador y un restador. Cada uno de estos hilos modificará el valor del contador de manera concurrente.

## Primera parte
### Requisitos

#### 1. Clase `Contador`
Esta clase representa un contador con las siguientes características:
- Tiene un atributo privado `c` que almacena el valor del contador.
- Un constructor que recibe un valor inicial para `c`.
- Métodos:
  - `incrementa()`: Aumenta en 1 el valor del contador.
  - `decrementa()`: Disminuye en 1 el valor del contador.
  - `valor()`: Devuelve el valor actual del contador.

#### 2. Clase `Sumador` (Extiende `Thread`)
- Representa un hilo que incrementa el valor del contador.
- Recibe un objeto `Contador` en el constructor.
- En el método `run()`, incrementa el valor del contador.

#### 3. Clase `Restador` (Implementa `Runnable`)
- Representa un hilo que decrementa el valor del contador.
- Recibe un objeto `Contador` en el constructor.
- En el método `run()`, decrementa el valor del contador y asigna el nombre "Restador" al hilo.

#### 4. Método `main`
En la función principal del programa se deben realizar las siguientes acciones:

1. Crear un objeto `Contador` con un valor inicial de 0.
2. Crear un número determinado de hilos `Sumador` y `Restador` (por ejemplo, 1000 de cada uno).
3. Iniciar todos los hilos en paralelo, de manera que operen sobre el mismo `Contador`.
4. Esperar a que todos los hilos terminen antes de mostrar el valor final del contador.
5. Observar que el resultado final puede variar debido a las condiciones de carrera.

#### Ejemplo de Ejecución Esperada
```
Valor inicial del contador: 0
Valor final del contador: -12
```
o
```
Valor final del contador: 24
```
> **Nota:** Debido a la concurrencia, la ejecución de los hilos puede dar resultados no deterministas si no se maneja correctamente la sincronización de los accesos al contador. Esto ilustra la necesidad de aplicar técnicas de sincronización en entornos multi-hilo.

Haz un commit de lo realizado en la primera parte.

## Segunda parte
Dado que se trata de un problema de memoria compartida (hilos distintos accediendo y modificando a la vez los valores del mismo objeto), ¿Qué habría que hacer para que no accedan a la vez ambos hilos a la vez al objeto compartido?

Haz un commit cuando completes esta parte.

Utiliza git checkout para moverte de un commit a otro y ver la diferencia entre el antes y el después.
