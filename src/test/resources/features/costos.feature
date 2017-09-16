# language: es
Característica: Costo de un proyecto

  Escenario: Proyecto con costos dentro de lo estimado
    Dado que mi proyecto tiene 3 hitos con costos estimados de "6000" pesos "10000" pesos y "4000" pesos
    Cuando cuado el costo real de los hitos es "3000" pesos, "10000" pesos y "4000" pesos respectivamente
    Entonces el proyecto es rentable y produce una ganancia extraordinaria de "3000" pesos


  Escenario: Proyecto con costos fuera de lo estimado
    Dado que mi proyecto tiene 3 hitos con costos estimados de "3000" pesos "1000" pesos y "4000" pesos
    Cuando cuado el costo real de los hitos es "3000" pesos, "10000" pesos y "4000" pesos respectivamente
    Entonces el proyecto no es rentable y produce una variacion de lo estipulado dee "9000" pesos