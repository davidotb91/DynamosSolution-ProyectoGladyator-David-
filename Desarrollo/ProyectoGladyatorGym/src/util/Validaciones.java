/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author desarrolloPC
 */
public class Validaciones {
    

    public boolean validarVacios(javax.swing.JTextField txtCampo1,
            javax.swing.JTextField txtCampo2,
            javax.swing.JTextField txtCampo3,
            javax.swing.JTextField txtCampo4,
            javax.swing.JTextField txtCampo5,
            javax.swing.JTextField txtCampo6,
            javax.swing.JTextField txtCampo7,
            javax.swing.JLabel lblCampo1Obligatorio,
            javax.swing.JLabel lblCampo2Obligatorio,
            javax.swing.JLabel lblCampo3Obligatorio,
            javax.swing.JLabel lblCampo4Obligatorio,
            javax.swing.JLabel lblCampo5Obligatorio,
            javax.swing.JLabel lblCampo6Obligatorio,
            javax.swing.JLabel lblCampo7Obligatorio) {
        if (txtCampo1.getText().equals("") || txtCampo2.getText().equals("") || txtCampo3.getText().equals("")
                || txtCampo4.getText().equals("") || txtCampo5.getText().equals("") || txtCampo6.getText().equals("") || txtCampo7.getText().equals("")) {
            if (txtCampo1.getText().equals("")) {
                lblCampo1Obligatorio.setVisible(true);
            } else {
                lblCampo1Obligatorio.setVisible(false);
            }
            if (txtCampo2.getText().equals("")) {
                lblCampo2Obligatorio.setVisible(true);
            } else {
                lblCampo2Obligatorio.setVisible(false);
            }
            if (txtCampo3.getText().equals("")) {
                lblCampo3Obligatorio.setVisible(true);
            } else {
                lblCampo3Obligatorio.setVisible(false);
            }
            if (txtCampo4.getText().equals("")) {
                lblCampo4Obligatorio.setVisible(true);
            } else {
                lblCampo4Obligatorio.setVisible(false);
            }
            if (txtCampo5.getText().equals("")) {
                lblCampo5Obligatorio.setVisible(true);
            } else {
                lblCampo5Obligatorio.setVisible(false);
            }
            if (txtCampo6.getText().equals("")) {
                lblCampo6Obligatorio.setVisible(true);
            } else {
                lblCampo6Obligatorio.setVisible(false);
            }
            if (txtCampo7.getText().equals("")) {
                lblCampo7Obligatorio.setVisible(true);
            } else {
                lblCampo7Obligatorio.setVisible(false);
            }
            return false;
        } else {
            limpiarObligatorios(lblCampo1Obligatorio, lblCampo2Obligatorio, lblCampo3Obligatorio, lblCampo4Obligatorio, lblCampo5Obligatorio, lblCampo6Obligatorio, lblCampo7Obligatorio);

            return true;
        }

    }
    
        public void limpiarObligatorios(javax.swing.JLabel lblCampo1Obligatorio,
            javax.swing.JLabel lblCampo2Obligatorio,
            javax.swing.JLabel lblCampo3Obligatorio,
            javax.swing.JLabel lblCampo4Obligatorio,
            javax.swing.JLabel lblCampo5Obligatorio,
            javax.swing.JLabel lblCampo6Obligatorio,
            javax.swing.JLabel lblCampo7Obligatorio) {
        lblCampo1Obligatorio.setVisible(false);
        lblCampo2Obligatorio.setVisible(false);
        lblCampo3Obligatorio.setVisible(false);
        lblCampo4Obligatorio.setVisible(false);
        lblCampo5Obligatorio.setVisible(false);
        lblCampo6Obligatorio.setVisible(false);
        lblCampo7Obligatorio.setVisible(false);

    }

    public String validarCamposdetxtaDoubles(javax.swing.JTextField txtCampo1, String proper) {
        try {
            Double.parseDouble(txtCampo1.getText());
            return "";
        } catch (Exception e) {
            return proper + "\n";

        }

    }
    public String validarCamposdetxtaDoublesOpcionales(javax.swing.JTextField txtCampo1, String proper) {
        if (txtCampo1.getText().equals("")) {
            txtCampo1.setText("0");
            return "";
        } else {
            try {
                Double.parseDouble(txtCampo1.getText());
                return "";
            } catch (Exception e) {
                return proper + "\n";
            }
    }
}
        //Validación campos vacíos REGISTRO DATOS PERSONALES
     public boolean validarVacios(javax.swing.JTextField txtCampo1,
            javax.swing.JTextField txtCampo2,
            javax.swing.JTextField txtCampo3,
            javax.swing.JTextField txtCampo4,
            javax.swing.JTextField txtCampo5,
            javax.swing.JTextField txtCampo6,
            javax.swing.JTextField txtCampo7,
            javax.swing.JTextField txtCampo8,
            javax.swing.JLabel lblCampo1Obligatorio,
            javax.swing.JLabel lblCampo2Obligatorio,
            javax.swing.JLabel lblCampo3Obligatorio,
            javax.swing.JLabel lblCampo4Obligatorio,
            javax.swing.JLabel lblCampo5Obligatorio,
            javax.swing.JLabel lblCampo6Obligatorio,
            javax.swing.JLabel lblCampo7Obligatorio,
            javax.swing.JLabel lblCampo8Obligatorio) {
         
        if (txtCampo1.getText().equals("") || txtCampo2.getText().equals("") || txtCampo3.getText().equals("")
                || txtCampo4.getText().equals("") || txtCampo5.getText().equals("") || txtCampo6.getText().equals("") || txtCampo7.getText().equals("")|| txtCampo8.getText().equals("")) {
            
            if (txtCampo1.getText().equals("")) {
                lblCampo1Obligatorio.setVisible(true);
            } else {
                lblCampo1Obligatorio.setVisible(false);
            }
            if (txtCampo2.getText().equals("")) {
                lblCampo2Obligatorio.setVisible(true);
            } else {
                lblCampo2Obligatorio.setVisible(false);
            }
            if (txtCampo3.getText().equals("")) {
                lblCampo3Obligatorio.setVisible(true);
            } else {
                lblCampo3Obligatorio.setVisible(false);
            }
            if (txtCampo4.getText().equals("")) {
                lblCampo4Obligatorio.setVisible(true);
            } else {
                lblCampo4Obligatorio.setVisible(false);
            }
            if (txtCampo5.getText().equals("")) {
                lblCampo5Obligatorio.setVisible(true);
            } else {
                lblCampo5Obligatorio.setVisible(false);
            }
            if (txtCampo6.getText().equals("")) {
                lblCampo6Obligatorio.setVisible(true);
            } else {
                lblCampo6Obligatorio.setVisible(false);
            }
            if (txtCampo7.getText().equals("")) {
                lblCampo7Obligatorio.setVisible(true);
            } else {
                lblCampo7Obligatorio.setVisible(false);
            }
             if (txtCampo8.getText().equals("")) {
                lblCampo8Obligatorio.setVisible(true);
            } else {
                lblCampo8Obligatorio.setVisible(false);
            }
            return false;
        } else {
            limpiarObligatorios(lblCampo1Obligatorio, lblCampo2Obligatorio, lblCampo3Obligatorio, lblCampo4Obligatorio, lblCampo5Obligatorio, lblCampo6Obligatorio, lblCampo7Obligatorio,lblCampo8Obligatorio);

            return true;
        }

    }
   
     public void limpiarObligatorios(javax.swing.JLabel lblCampo1Obligatorio,
            javax.swing.JLabel lblCampo2Obligatorio,
            javax.swing.JLabel lblCampo3Obligatorio,
            javax.swing.JLabel lblCampo4Obligatorio,
            javax.swing.JLabel lblCampo5Obligatorio,
            javax.swing.JLabel lblCampo6Obligatorio,
            javax.swing.JLabel lblCampo7Obligatorio,
            javax.swing.JLabel lblCampo8Obligatorio) {
        lblCampo1Obligatorio.setVisible(false);
        lblCampo2Obligatorio.setVisible(false);
        lblCampo3Obligatorio.setVisible(false);
        lblCampo4Obligatorio.setVisible(false);
        lblCampo5Obligatorio.setVisible(false);
        lblCampo6Obligatorio.setVisible(false);
        lblCampo7Obligatorio.setVisible(false);
        lblCampo8Obligatorio.setVisible(false);

    }
    public void validarSoloLetras(String cadena, String campo){
     Pattern pat1 = Pattern.compile("[0-9]");
     Matcher mat1 = pat1.matcher(cadena);
     if (mat1.find()) {
            System.out.println("La cadena TIENE dígitos");
            JOptionPane.showMessageDialog(null, "EL CAMPO " + campo+" NO DEBE CONTENER DÍGITOS");
     }         
    }
    
    public void validarCorreo(String correo, String campo){
       Pattern pat = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
       Matcher mat = pat.matcher(correo);
       if(mat.find()){
          System.out.println("Correo Válido");
       }else{
          JOptionPane.showMessageDialog(null, "EL CAMPO " + campo +"ES INCORRECTO");
        }        
    }
    
    public void validarSoloNumeros(String cadena, String campo){
     Pattern pat = Pattern.compile("[a-zA-Z]");
     Matcher mat = pat.matcher(cadena);
     if (mat.find()) {
         JOptionPane.showMessageDialog(null, "EL CAMPO " + campo +" NO PUEDE CONTENER LETRAS");
     } 
    }
}
