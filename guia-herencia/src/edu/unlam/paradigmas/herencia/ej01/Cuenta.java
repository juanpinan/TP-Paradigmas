
package edu.unlam.paradigmas.herencia.ej01;

public class Cuenta {

	protected double saldo;
	
	//date

	public Cuenta() {
		this.saldo = 0.0;
	}
	
	protected boolean saldoSuficiente(double monto)
	{
		return this.saldo>=monto;
	}
	
	protected boolean montoValido(double monto)
	{
		return monto>0;
	}
	
	private void acreditar(double monto) {
		this.saldo+=monto;
	}
	
	private void debitar(double monto)
	{
		this.saldo-=monto;
		if(this.saldo < 0)
		{
			this.saldo=0;
		}
	}
	
	public void mostrarSaldo() {
		System.out.println(this.saldo);
	}
	
	public double getSaldo() {
		return this.saldo;
	} //lo usaria si mi tipo de dato fuese private

	public boolean depositarDinero(double dinero) {
		if (this.montoValido(dinero)) {
			this.acreditar(dinero);

			return true;
		} else {
			return false;
		}

	}

	public boolean retirarDinero(double cantARetirar) {
		if (this.montoValido(cantARetirar) && this.saldoSuficiente(cantARetirar)) 
		{
				this.debitar(cantARetirar);
				return true;
			} else {
				return false;
			}
		} 
	

	public boolean transferir(double cantATransferir, Cuenta cuentaATransferir) { //if(this.retirarDinero(cantATransferir)&&cuentaATransferir.depositarDinero(cantATransferir)) probar con esta tambien
		if (this.montoValido(cantATransferir) && this.saldoSuficiente(cantATransferir)) { // al preguntar si puedo depositar la cantATransferir, 
																						//estoy preguntando si ese monto es valido, ya que no me va a dejar depositar dinero negativo o 0, podria hacer la consulta de nuevo
			this.debitar(cantATransferir);;
			cuentaATransferir.acreditar(cantATransferir);
			return true;
		} else {
			return false;
		}

	}

}

//Parte 1
//¿Qué tipo de dato se utilizó para el saldo? ¿Es el más apropiado?
//Utilice double, no es el mas apropiado, el mas apropiado es BigDecimal cuando se esta hablando de dinero.
//¿Qué visibilidad tiene el atributo saldo de la Cuenta? ¿Es correcto?
//Tiene private, es correcto debido a que no quiero que cualquier cosa pueda ver el saldo, preciso que solamente la cuenta pueda ver su saldo.
//Si extraigo más dinero del disponible en saldo, seguramente pueda hacerlo. ¿Está bien que así sea?
//No, no esta bien que asi sea, ya que asi no funciona en la realidad. Implemente una forma de evitar esto.

//Parte 2
//¿Qué ventaja representó la incorporación del Encapsulamiento en el problema?
// La incorporacion de encapsulamiento en el problema nos permite que el dato saldo este protegido de otras funciones o metodos, no quiero que lo toquen cosas que no sean Cuentas
//¿Qué desventaja podríamos encontrar?
// Siempre que querramos hacer una modificacion en el saldo, o preguntar el mismo, tendremos que pasar por un metodo y no podemos usar directamente la variable, lo cual lo hace un poco incomodo a la hora de usar.
//¿Es realmente Programación Orientada a Objetos? ¿Cómo puedo saberlo?
// Si, el encapsulamiento y los metodos forman parte de la POO, son cosas que en otros lenguajes que no sean orientados a objetos, son mucho mas complicadas de hacer
//¿Qué acciones se utilizaron para prevenir la realización de operaciones no válidas?
//Se hicieron validaciones de los datos que son ingresados desde afuera.

//Parte3
//Al interactuar con objetos del mismo tipo, es importante distinguir entre parámetros y atributos. ¿Cómo puede hacerse para evitar confusiones?
//con el this.(atributo)
//¿Es correcto el orden de los parámetros para el método transferir? ¿Qué cambiarías?
//Si, me parece correcto, a lo sumo se podrian invertir, pero mientras se use de la manera correcta internamente los parametros, daria igual.
//Dentro del código de transferir, ¿utilizaste los métodos preexistentes o repetiste lógica que ya existía? ¿Cuál es la ventaja de cada una de las aproximaciones?
//Lo hice de las dos formas, a medida que me fui dando cuenta que podia hacer un retirar de la cuenta que va a transferir y un depositar de la cuenta que va a recibir la transferencia, lo deje asi, pero me falto
//probarlo mas a fondo, la unica desventaja que veo es que tengo mensajes por depositos exitosos y por retiros exitoso o que fallaron, y se puede llegar a hacer confuso a la hora de leer la consola.
//¿Qué pasaría si la operación de transferir se ve interrumpida a la mitad de su ejecución? ¿Cómo se podría prevenir esto?
//Si la operacion transferir se viera interrumpida a la mitad de su ejecucion, probablemente una cuenta quede con el saldo disminuido y la otra sin haber recibido la transferencia, para solucionar esto
//habria que hacer las dos cosas al mismo tiempo, restar el saldo y sumar el saldo.