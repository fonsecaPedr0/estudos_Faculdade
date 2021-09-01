using System;

namespace Livraria
{
    class Assuntos 
    {
         public string Nome {get; set;}

        public Assuntos()
        {
            Nome = "";
        }

        public Assuntos(string Nome)
        {
            this.Nome = Nome;
        }

        public void mostrarDados()
        {
            Console.WriteLine("Nome: " + Nome + "\n");
        }
    
    }
}