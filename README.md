# DefendTheFortVer1


**********************************************************************************************************************************************************************
10/18/22
**********************************************************************************************************************************************************************


                                                                         !!Metas del Dia de hoy!!

-Hacer el diagrama de clases UML
-Implementar el mover de un objeto
-Implementar el atacar 




                                                                                 --Ideas--

Sebas -> buscar una forma de generar zombies aleatoriamente en los bordes de la grid de tiles, luego de eso, programar el movimiento de los zombies al centro del grid.
         La idea prinicipal es la de utilizar el campo generado aleatoriamente en la función anteriormente mencionada para calcular hacia dónde tienen que moverse. 
         Dudas: pensaba en que la función move() solo mueva al zombie una casilla, y que en el thread del mismo zombie haya un ciclo que lo haga activar la función move()
         cada segundo, utilizando sleep(1). En este thread del zombie, entonces habría un ciclo que se acabe cuando la vida del zombie == 0, en el cual haga lo siguiente:
         1. Ciclo de movimiento:
            a. Se mueve
            b. Escanea
            c. Cuando encuentre un objetivo, se rompe este ciclo
         2. Ataca:
            a. Si muere, desaparece del grid, y termina el thread y el ciclo
            b. Si no muere, sigue el ciclo de movimiento
           
 Emanuel -> determinar si la funcion atacar debe estar programada para la clase personaje, hacer el estudio de casos para los ataques de los diferentes tipos de defensas/zombies. Se podria crear un override para los que atacan multiple y para los que vuelan. La idea principal es que por cada segundo se haga un escaneo de las casillas en un rango determinado(posible valor de entrada de la funcion atacar) y que de encontrar un objetivo se retorne esa casilla. Luego aplicar la funcion atacar que reste el poder de ataque a la vida.
 
 determineObjective()
         1. Ciclo de accion:
                  a. Recorre la matriz de tiles en un rango cuadrado buscando posibles objetivos
                  b. si encuentra uno, retorna la casilla
                  c. si no lo encuentra, retorna null;
attack(Tile tileObjective)
         1. Ciclo de ataque:
                  a. comprueba si es posible atacar al objetivo
                  b. modifica la vida del objetivo si es posible atacarlo
                  c. registra el ataque propiciado
                  d. registrar el ataque recibido en la clase;
                  
Duda: tenemos que determinar de que manera logear los ataques recibidos y propiciados.
                  

**********************************************************************************************************************************************************************



-ToDo:


