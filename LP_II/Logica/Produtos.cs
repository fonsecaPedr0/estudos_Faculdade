using System;

namespace Livraria
{
    class Produtos 
    {
        public string Descricao {get; set;}
        public int Quatidade {get; set;}
        public double Valor {get; set;}

        public Produtos()
        {
            Descricao = "";
            Quatidade = 0;
            Valor = 0.00;
        }

        public Produtos(string Descricao, int Quantidade, double Valor)
        {
            this.Descricao = Descricao;
            this.Quatidade = Quantidade;
            this.Valor = Valor;
        }

        public void mostrarDados()
        {
            Console.WriteLine("Descrição: " + Descricao + "\nQuantidade: " + Quatidade + "\n Valor: " + Valor  + "\n");
        }
    }
}