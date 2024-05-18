class Cuenta {
    constructor() {
        this._saldo = 0.0;
    }

    acreditar(monto) {
        this._saldo += monto;
    }

    debitar(monto) {
        this._saldo -= monto;
        if (this._saldo < 0) {
            this._saldo = 0;
        }
    }

    saldoSuficiente(monto) {
        return this._saldo >= monto;
    }

    montoValido(monto) {
        return monto > 0;
    }

    mostrarSaldo() {
        console.log("El saldo actual es de: $" + this._saldo);
    }

    getSaldo() {
        return this._saldo;
    }

    depositarDinero(montoADepositar) {
        if (this.montoValido(montoADepositar)) {
            this.acreditar(montoADepositar);
            return true;
        } else {
            return false;
        }
    }

    retirarDinero(montoARetirar) {
        if (this.montoValido(montoARetirar) && this.saldoSuficiente(montoARetirar)) {
            this.debitar(montoARetirar);
            return true;
        } else {
            return false;
        }
    }

    transferir(montoATransferir, otraCuenta) {
        if (this.montoValido(montoATransferir) && this.saldoSuficiente(montoATransferir)) {
            this.debitar(montoATransferir);
            otraCuenta.acreditar(montoATransferir);
            return true;
        } else {
            return false;
        }
    }
}

class CuentaCorriente extends Cuenta{
    constructor(montoEnDescubierto){
        super();
        this._saldoEnDescubierto=montoEnDescubierto;
    }

    getSaldoDescubierto(){
        return this._saldoEnDescubierto;
    }

    saldoSuficiente(monto){
        return this._saldo+this._saldoEnDescubierto;
    }
}

class CuentaDeAhorros extends Cuenta{
    constructor(saldoAReservar)
    {
        super();
        this_saldoReservado=0;
    }

    acreditarReservado(monto)
    {
        this._saldoReservado+=monto;
    }

    getSaldoReservado()
    {
        return this.this_saldoReservado;
    }

    reservarSaldo(cantidadAReservar){
        if(this.montoValido(cantidadAReservar)&&this.saldoSuficiente(cantidadAReservar))
            {
                this.debitar(cantidadAReservar);
                this.acreditarReservado(cantidadAReservar);
                return true;
            }else{
                return false;
            }
    }

    reintegrarSaldo(){
        this.acreditar(this._saldoReservado);
        this._saldoReservado=0.0;
    }
}