package edu.unlam.paradigmas.herencia.ej01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CuentaTests {

	@Test
	void testCrearCuenta() {
		
		Cuenta cuenta1 = new Cuenta ();
		
		cuenta1.mostrarSaldo();
		cuenta1.depositarDinero(-100000);
		cuenta1.depositarDinero(1000);
		assertEquals(1000,cuenta1.getSaldo());
		
	}
	
	@Test
	void testRetirarDinero() {
		
		Cuenta cuenta1 = new Cuenta ();
		
		cuenta1.mostrarSaldo();
		cuenta1.depositarDinero(1000);
		cuenta1.retirarDinero(-500);
		cuenta1.retirarDinero(0);
		cuenta1.retirarDinero(3000);
		cuenta1.retirarDinero(500);
		assertEquals(500,cuenta1.getSaldo());
		
	}
	
	@Test
	void testTransferir() {
		
		Cuenta cuenta1 = new Cuenta ();
		Cuenta cuenta2 = new Cuenta ();
		
		cuenta1.depositarDinero(1000);
		cuenta2.depositarDinero(20000);
		
		cuenta2.transferir(1200, cuenta1);
		assertEquals(2200,cuenta1.getSaldo(),0.01);
		assertEquals(18800,cuenta2.getSaldo(),0.01);
		
	}
	
	@Test
	void testCuentaDeAhorrosReservar() {
		
		CuentaDeAhorros cuenta1 = new CuentaDeAhorros ();
		
		cuenta1.depositarDinero(-500);
		cuenta1.depositarDinero(9500);
		
		
		cuenta1.reservarSaldo(-1000);
		cuenta1.reservarSaldo(0);
		cuenta1.reservarSaldo(3250.22);
		
		assertEquals(9500-3250.22,cuenta1.getSaldo());
		assertEquals(3250.22,cuenta1.getSaldoReservado());
		
	}
	
	@Test
	void testCuentaDeAhorrosReintegrar() {
		
		CuentaDeAhorros cuenta1 = new CuentaDeAhorros ();
		

		cuenta1.depositarDinero(9500);
		cuenta1.reservarSaldo(3250.22);
		assertEquals(9500-3250.22,cuenta1.getSaldo());
		cuenta1.reintegrarSaldo();
		assertEquals(9500,cuenta1.getSaldo());
		
	}
	
	@Test
	void testCuentaCorrienteRetirar() {
		
		CuentaCorriente cuenta1 = new CuentaCorriente (2500);
		

		cuenta1.depositarDinero(5000);
		cuenta1.retirarDinero(6500);
		assertEquals(0,cuenta1.getSaldo());

		
	}
	
	@Test
	void testCuentaCorrienteRetirarBien() {
		
		CuentaCorriente cuenta1 = new CuentaCorriente (2500);
		

		cuenta1.depositarDinero(5000);
		cuenta1.retirarDinero(-1000);
		cuenta1.retirarDinero(0);
		cuenta1.retirarDinero(100000000);
		cuenta1.retirarDinero(4500);
		assertEquals(500,cuenta1.getSaldo());
		assertEquals(2500,cuenta1.getSaldoDescubierto());
		
	}
	
	@Test
	void testCuentaCorrienteTransferir() {
		
		CuentaCorriente cuenta1 = new CuentaCorriente (2500); // 2500 de saldo en descubierto
		Cuenta cuenta2 = new Cuenta();
		
		cuenta1.depositarDinero(2000);
		cuenta1.transferir(-10000, cuenta2);
		cuenta1.transferir(0, cuenta2);
		cuenta1.transferir(1111111111, cuenta2);
		cuenta1.transferir(3000, cuenta2);
		
		assertEquals(0,cuenta1.getSaldo());
		assertEquals(3000, cuenta2.getSaldo());
		
	}
	
	


}
