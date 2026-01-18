# Aplicación web «Come&Go»
## Aplicación web para el restaurante simulado «Come&Go».
## Este proyecto conforma el *trabajo final* para la asignatura **Patrones Software**, asignatura optativa del cuarto curso del *Grado en Ingeniería Informática* de la ***Universidad de Alcalá***.

## Caso de uso 1 (PERSONALIZAR HAMBURGUESA):

~~~Java
Plato miHamburguesa = builderSmash.getHamburguesa(); 
// Precio: 10.00€ | Desc: "Hamburguesa Smash..."

miHamburguesa = new ExtraQueso(miHamburguesa);
// Precio: 11.25€ | Desc: "Hamburguesa Smash..., con Extra de Queso"

miHamburguesa = new ExtraBacon(miHamburguesa);
// Precio: 12.75€ | Desc: "Hamburguesa Smash..., con Extra de Queso, con Extra de Bacon"
~~~

## Integración de descuentos en pedidos:

~~~Java
// Ejemplo de uso en la clase Pedido
public class Pedido {
    private IEstrategiaDescuento estrategiaDescuento;
    private double totalBruto;

    // El sistema puede cambiar la estrategia en tiempo de ejecución
    public void setEstrategiaDescuento(IEstrategiaDescuento estrategia) {
        this.estrategiaDescuento = estrategia;
    }

    public double calcularTotalFinal() {
        double descuento = 0;
        if (estrategiaDescuento != null) {
            descuento = estrategiaDescuento.calcularDescuento(totalBruto);
        }
        return totalBruto - descuento;
    }
}
~~~

## Integración arranque aplicación:

~~~Java
// 1. Inicializar DB
InicializadorDB.inicializarTablas();

// 2. Configurar el sistema de notificaciones (Observer)
GestorPedidos gestorNotificaciones = new GestorPedidos();
gestorNotificaciones.suscribir(new NotificacionCocina());
gestorNotificaciones.suscribir(new NotificacionCliente());
gestorNotificaciones.suscribir(new ObservadorCamarero());

// 3. Crear los controladores con el gestor compartido
CocinaController cocinaCtrl = new CocinaController(gestorNotificaciones);
PedidoController pedidoCtrl = new PedidoController(gestorNotificaciones);
~~~
