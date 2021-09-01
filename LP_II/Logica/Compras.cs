using System;

namespace Livraria
{
    class Compras
    {
        public int Id {get; set;}
        public int Qtd {get; set;}

        public Livro livro {get; set;}
        public Produtos produtos {get; set;}

        public Compras()
        {
            Id = 0;
            Qtd = 0;
        }

        public Compras (int Id, int Qtd, Livro livro, Produtos produtos)
        {
            this.Id = Id;
            this.Qtd = Qtd;
        }

        public void mostrarDados()
        {
            Console.WriteLine("Id: " + Id + "\nQuantidade: " + Qtd + "\n");
        }
    }
}