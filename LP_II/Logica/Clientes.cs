using System;

namespace Livraria
{
    class Clientes
    {
        public string Nome {get; set;}
        public int CpfCnpj {get; set;}
        public int Telefone {get; set;}

        public Clientes()
        {
            Nome = "";
            CpfCnpj = 0;
            Telefone = 0;
        }

        public Clientes(String Nome, int CpfCnpj, int Telefone)
        {
            this.Nome = Nome;
            this.CpfCnpj = CpfCnpj;
            this.Telefone = Telefone;
        }
        public void mostrarDados()
        {
            Console.WriteLine("Nome: " + Nome + "\nCPF: " + CpfCnpj + "\nTelefone: " + Telefone + "\n");
        }
    }
}