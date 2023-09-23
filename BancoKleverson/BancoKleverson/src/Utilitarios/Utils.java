package Utilitarios;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Utils {
    static NumberFormat formatarValores=new DecimalFormat("R$ #,##0.0"); //usando funcoes
        public static String doubleToString(Double valor){
            return formatarValores.format(valor);
    }
}
