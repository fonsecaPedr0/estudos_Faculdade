using System;

namespace Livraria
{
    class Fornecedores
    {
        public string Nome {get; set;}
        public string dataCadastro {get; set;}

        public Fornecedores()
        {
            Nome = "";
            dataCadastro = "";
        }

        public Fornecedores(string Nome, string dataCadastro)
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