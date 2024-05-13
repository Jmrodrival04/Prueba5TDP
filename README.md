Este es mi repositorio de github:https://github.com/Jmrodrival04/Prueba5TDP.git

El programa es un sistema de gestión de restaurantes que permite a los usuarios interactuar con diferentes tipos de restaurantes, realizar reservas y seleccionar estrategias de servicio. Aquí está una explicación detallada del funcionamiento del programa:

Inicio del Programa:

El usuario inicia el programa desde la clase Main.
Se muestra un menú con varias opciones, incluyendo la selección del tipo de restaurante, la visualización de reservas y la salida del programa.
Selección del Tipo de Restaurante:

El usuario elige el tipo de restaurante que desea visitar: comida rápida, alta cocina o restaurante temático.
Según la selección, se instancia el restaurante correspondiente utilizando la clase RestaurantManager.
Reservación de Mesa:

El usuario proporciona su nombre y selecciona el número de mesa que desea reservar.
Se utiliza un adaptador de reservaciones (ReservationAdapter) para realizar la reserva de mesa, interactuando con un sistema externo de reservas (ExternalReservationSystem).
La reserva se almacena en una lista de reservas para su posterior visualización.
Selección de Estrategia de Servicio:

El usuario elige la estrategia de servicio que desea experimentar durante su visita al restaurante: casual, alta cocina o temático.
Se configura la estrategia de servicio seleccionada en el restaurante mediante el método setServiceStrategy().
Interacción con el Restaurante:

Se crea un cliente de restaurante (RestaurantClient) asociado con el nombre proporcionado por el usuario.
El cliente se registra como observador en el sistema de actualizaciones del menú (MenuUpdates).
Se muestra un mensaje de bienvenida al cliente, indicando el tipo de restaurante y la estrategia de servicio seleccionados.
El restaurante sirve a los clientes según la estrategia de servicio configurada.
Visualización de Reservas:

Si el usuario elige la opción de ver reservas en el menú, se muestra una lista de todas las reservas realizadas hasta el momento.
Cada reserva incluye el tipo de restaurante, el número de mesa y el nombre del cliente.
Finalización del Programa:

El usuario puede repetir las operaciones anteriores o elegir salir del programa, lo que termina la ejecución.
