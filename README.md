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
