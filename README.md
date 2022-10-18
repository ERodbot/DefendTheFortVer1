# DefendTheFortVer1

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
