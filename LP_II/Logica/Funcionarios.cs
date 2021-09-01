using System;

namespace Livraria
{
    class Funcionarios
    {
        public string Nome {get; set;}
        public string Setor {get; set;}
        public string Cargo {get; set;}

        public Funcionarios()
        {
            Nome = "";
            Setor = "";
            Cargo = "";
        }

        public Funcionarios(string Nome, string Setor, string Cargo)
        {
            this.Nome = Nome;
            this.Setor = Setor;
            this.Cargo = Cargo;
        }

        public void mostrarDados()
        {
            Console.WriteLine("Nome: " + Nome + "\nSetor: " + Setor + "\nCargo: " + Cargo + "\n");
        }
    }
}