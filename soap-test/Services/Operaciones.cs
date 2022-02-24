using System;
using WSDL.mensajes;

namespace WSDL.operaciones{
    public class Operaciones : Mensajes {
        public String Saludar(string nombre){
            String msj = "HOLA "+nombre+"Te saluda Angel";
            return msj;
        }
        public String Mostrar(int d){
            return "x";
        }
    }
}
