# language: es
Característica: Que desarrollador trabajo sobre un producto

  Escenario: Ver que personas trabajaron en un proyecto
    Dado que "Juan" trabajo en el proyecto "CRM-1.1" y "Pedro" en el proyecto "CRM-1.0"
    Cuando quiero saber quien trabajo en el producto "CRM"
    Entonces en el producto trabajo "Juan" y "Pedro"

    Escenario: Ver las asignaciones de horas de un proyecto
    Dado que "Juan" trabajo "5" horas para la tarea "Implementar logout" del requerimiento no funcional "Login" del hito "1" del proyecto "CRM-1.1"
    Cuando pido quien trabajo en el requerimiento "Login" del hito "1" del proyecto "CRM-1.1"
    Entonces el que trabajo fue "Juan"
