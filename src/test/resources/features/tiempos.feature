# language: es
Característica: Estimaciones en tiempo

  Escenario: Proyecto que cumple con tiempos estimados
    Dado que mi proyecto tiene una fecha de finalizacion estimada para el "2017-09-22"
    Cuando la fecha de finalizacion del proyecto es hoy
    Entonces el proyecto fue estimado correctamente y "no hay desvio".

  Escenario: Proyecto que no cumple con tiempos estimados
    Dado que mi proyecto tiene una fecha de finalizacion estimada para el "2017-06-01"
    Cuando la fecha de finalizacion del proyecto es hoy
    Entonces el proyecto fue estimado correctamente y "hay desvio" de mas de "7" dias.