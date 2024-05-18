package edu.unlam.paradigmas.herencia.ej01;

public class CuentaCorriente extends Cuenta {

	private double saldoEnDescubierto;

	public CuentaCorriente(double montoEnDescubierto) {
		super();
		this.saldoEnDescubierto = montoEnDescubierto;
	}

	public double getSaldoDescubierto() {
		return this.saldoEnDescubierto;
	}
	
	@Override
	protected boolean saldoSuficiente(double monto)
	{
		return this.saldo+this.saldoEnDescubierto>=monto;
	}

//	@Override
//	public boolean retirarDinero(double cantidadARetirar) {
//
//		double retirarDescubierto;
//
//		if (cantidadARetirar > 0) {
//			if (cantidadARetirar <= this.saldo + this.saldoEnDescubierto) {
//
//				if ((retirarDescubierto = this.saldo - cantidadARetirar) < 0) { // aca tengo lo que me falta, me
//																				// quedaria en negativo
//					this.saldo -= cantidadARetirar + retirarDescubierto;
//					this.saldoEnDescubierto -= retirarDescubierto * -1;
//					this.transacciones[this.contador].setMontoyMotivo(cantidadARetirar, "Retiro de dinero");
//					this.contador++;
//					return true;
//
//				} else {
//					super.retirarDinero(cantidadARetirar);
//					return true;
//				}
//			} else {
//				return false;
//			}
//		} else {
//			return false;
//		}
//	}
//
//	@Override
//	public boolean transferir(double cantATransferir, Cuenta cuentaATransferir) {
//		if (cantATransferir > 0) {
//			if (cantATransferir <= this.saldo + this.saldoEnDescubierto) {
//				this.retirarDinero(cantATransferir);
//				cuentaATransferir.depositarDinero(cantATransferir);
//				return true;
//			} else {
//				return false;
//			}
//		}else
//		{
//			return false;
//		}
//	}
}

//¿Hubo alguna funcionalidad que pudiera reutilizarse?
//si, de hecho las reutilice
//¿Qué método tuvo que rehacerse?
//retirar dinero debido al saldo extra
//¿Cómo se manejan transferencias entre tipos de cuenta diferentes?
//bien? que seyo