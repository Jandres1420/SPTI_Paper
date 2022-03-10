/**
package edu.eci.spti.logs.model;
import pgp.utils.PGPFileProcessor;
public class desencriptar {

        public void prccesar(){
            PGPFileProcessor p = new PGPFileProcessor();
            try {
                //Ruta del certificado publico para cifrar
                p.setKeyFile("D:\\pgp\\certificado-llave\\CertificadoPublico.asc");
                //Ruta del Archivo que se va a cifrar
                p.setInputFile("D:\\pgp\\texto-prueba.txt");
                //Ruta del Archivo de salida cifrado
                p.setOutputFile("D:\\pgp\\salida\\final.txt.gpg");
                p.encrypt();
                System.out.println("El archivo se encripto-->"
                        + "D:\\pgp\\salida\\final.txt.gpg");
            } catch (Exception e) {
            }
        }

    }
}
 **/