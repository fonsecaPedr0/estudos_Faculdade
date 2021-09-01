using System;

namespace Livraria
{
    class Livro 
    {
        public string Descricao {get; set;}
        public int Isbn {get; set;}
        public string DataPubli {get; set;}
        public double Valor {get; set;}

        public Livro()
        {
            Descricao = "";
            Isbn = 0;
            DataPubli = "";
            Valor = 0.00;
        }

        public Livro(string Descricao, int Isbn, string DataPubli, double Valor)
        {
            this.Descricao = Descricao;
            this.Isbn = Isbn;
            this.DataPubli = DataPubli;
            this.Valor = Valor;
        }

        public void mostrarDados()
        {
            Console.WriteLine("Descrição: " + Descricao + "\nISBN: " + Isbn + "\nData de Publicação: " + DataPubli + "\nValor: " + Valor + "\n");
        }
    }
}