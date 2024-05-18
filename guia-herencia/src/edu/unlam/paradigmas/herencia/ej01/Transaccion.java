package edu.unlam.paradigmas.herencia.ej01;

public class Transaccion {
	private double monto;
	private String motivo;
	//de quererse añadir la fecha habria que importar java.util.date, pero no pude hacerlo :(

	public Transaccion() {
		this.monto = 0;
		this.motivo = null;
	}

	public void setMontoyMotivo(double monto, String motivo) {
		this.monto = monto;
		this.motivo = motivo;
	}

	public double getMonto() {
		return monto;
	}

	public String getMotivo() {
		return motivo;
	}

}
