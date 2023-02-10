package Utilitarios;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Utils {
    static NumberFormat formatandoValores= new DecimalFormat("R$ #,##0.0"); //usando funcoes
    public static String doubleToString (Double valor){
        return formatandoValores.format(valor);
    }


}
