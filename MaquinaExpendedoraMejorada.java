public class MaquinaExpendedoraMejorada {
    
    // El precio del billete
    private int precioBillete;
    // La cantidad de dinero que lleva metida el cliente actual
    private int balanceClienteActual;
    // El total de dinero almacenado en la maquina desde su ultimo vaciado
    private int totalDineroAcumulado;
    // El número de billetes vendidos
    private int billetesVendidos;
    // El origen del billete
    private String estacionOrigen;
    // El destino del billete
    private String estacionDestino;
    // El tipo de máquina que creamos (normal o mejorada)
    private boolean tipoDeMaquina;
    
    /**
     * Crea una maquina expendedora de billetes de tren con el 
     * precio del billete y el origen y destino dados. Se asume que el precio
     * del billete que se recibe es mayor que 0.
     */
    public MaquinaExpendedoraMejorada(int precioDelBillete, String origen, String destino, boolean tipoMaquina) {
        precioBillete = precioDelBillete;
        balanceClienteActual = 0;
        totalDineroAcumulado = 0;
        estacionOrigen = origen;
        estacionDestino = destino;
        billetesVendidos = 0;
        tipoDeMaquina = tipoMaquina;
    }
    
    public MaquinaExpendedoraMejorada(boolean tipoMaquina) {
        precioBillete = 20;
        balanceClienteActual = 0;
        totalDineroAcumulado = 0;
        estacionOrigen = "León";
        estacionDestino = "Madrid";
        billetesVendidos = 0;
        tipoDeMaquina = tipoMaquina;
    }

    /**
     * Devuelve el precio del billete
     */
    public int getPrecioBillete() {
        return precioBillete;
    }

    /**
     * Devuelve la cantidad de dinero que el cliente actual lleva introducida
     */
    public int getBalanceClienteActual() {
        return balanceClienteActual;
    }
    
    public int getNumeroBilletesVendidos() {
        return billetesVendidos;
    }
    
    public void imprimirNumeroBilletesVendidos() {
        System.out.println("#########################");
        System.out.println("Se han vendido " + billetesVendidos + " billetes");
        System.out.println("#########################");
    }
    
    /**
     * Simula la introduccion de dinero por parte del cliente actual
     */
    public void introducirDinero(int cantidadIntroducida) {
        if (cantidadIntroducida > 0) {
            balanceClienteActual = balanceClienteActual + cantidadIntroducida;
        }
        else {
            System.out.println(cantidadIntroducida + " no es una cantidad de dinero valida.");
        }        
    }
    
    /** 
     * Vacía la máquina por completo 
    */
    public int vaciarDineroDeLaMaquina() {
        int dineroVaciado;
        
        if (balanceClienteActual <= 0) {
            dineroVaciado = balanceClienteActual + totalDineroAcumulado;
            balanceClienteActual = 0;
            totalDineroAcumulado = 0;
        }
        else {
            System.out.println("####################################################");
            System.out.println("No se puede vaciar la máquina con operación en curso");
            System.out.println("####################################################");
            dineroVaciado = -1;
        }
        return dineroVaciado;
    }

    /**
     * Imprime un billete para el cliente actual
     */
    public void imprimirBillete() {
        int cantidadDeDineroQueFalta = (precioBillete - balanceClienteActual);

        if (balanceClienteActual >= precioBillete) {
            System.out.println("##################");
            System.out.println("# Billete de tren:");
            System.out.println("# De " + estacionOrigen + " a " + estacionDestino);
            System.out.println("# " + precioBillete + " euros.");
            System.out.println("##################");
            System.out.println();
            
            if (tipoDeMaquina == true) {
                int descuento = (precioBillete * 25 / 100);
                System.out.println("# Has conseguido un descuento de " + descuento + " euros!");
            }
            totalDineroAcumulado = totalDineroAcumulado + precioBillete;
            // Reduce el balance del cliente actual dejandole seguir utilizando la maquina
            balanceClienteActual = balanceClienteActual - precioBillete;
            billetesVendidos++;
        }
        else if (balanceClienteActual < precioBillete) {
            System.out.println("Necesitas introducir " + (cantidadDeDineroQueFalta) + " euros mas!");
        }
    }
    
    /**
     * Cancela la operacion de compra del cliente actual y le
     * devuelve al cliente el dinero que ha introducido hasta el momento
     */
    public int cancelarOperacionYDevolverDinero() {
        int cantidadDeDineroADevolver;
        cantidadDeDineroADevolver = balanceClienteActual;
        balanceClienteActual = 0;
        return cantidadDeDineroADevolver;
    } 
}
