using System;

namespace Livraria
{
    class Autores
    {
        public string Nome {get; set;}

        public Autores()
        {
            Nome = "";
        }

        public Autores(string Nome)
        {
            this.Nome = Nome;
        }

        public void mostrarDados()
        {
            Console.WriteLine("Nome: " + Nome + "\n");
        }
    }
}