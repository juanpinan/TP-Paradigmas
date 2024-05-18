package edu.unlam.paradigmas.herencia.ej01;

public class CuentaDeAhorros extends Cuenta {
	private double saldoReservado;

	public CuentaDeAhorros() {
		super();
		this.saldoReservado = 0;
	}
	
	public double getSaldoReservado() {
		return this.saldoReservado;
	}

	public boolean reservarSaldo(double cantidadAReservar) {
		if (super.retirarDinero(cantidadAReservar)){
			this.saldoReservado+=cantidadAReservar;
			System.out.println("Se reservo: $"+ cantidadAReservar);
			return true;
		}else {
			System.out.println("No se pudo reservar: $" + cantidadAReservar);
			return false;
		}
	}
	
	public void reintegrarSaldo() //si lo valido a la entrada y todo entra bien, no lo tengo que validar a la salida :)
	{
//		super.depositarDinero(this.saldoReservado);
//		this.saldoReservado=0;
		this.saldo+=this.saldoReservado;
		this.saldoReservado=0;
		System.out.println("El saldo reservado fue reintegrado. Saldo actual: $"+this.saldo);
	}
}
