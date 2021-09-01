using System;

namespace Livraria
{
    class Editoras
    {
        public  string Nome {get; set;}
        public string dataCadastro {get; set;}

        public Editoras()
        {
            Nome = "";
            dataCadastro = "";
        }

        public Editoras(string Nome, string dataCadastro)
        {
            this.Nome = Nome;
            this.dataCadastro = dataCadastro;
        }

        public void mostrarDados()
        {
            Console.WriteLine("Nome: " + Nome + "\nData cadastro: " + dataCadastro + "\n");
        }
        
    }
}