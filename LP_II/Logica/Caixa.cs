using System;

namespace Livraria
{
    class Caixa
    {
        public string DataFechamento {get; set;}
        public double TotalDiario {get; set;}

        public Caixa()
        {
            DataFechamento = "";
            TotalDiario = 0.0;
        }

        public Caixa(string DataFechamento, double TotalDiario)
        {
            this.DataFechamento = DataFechamento;
            this.TotalDiario = TotalDiario;
        }

        public void mostrarDados()
        {
            Console.WriteLine("Data do Fechamento: " + DataFechamento + "\nTotal do Dia: " + TotalDiario + "\n");
        }
        
    }
}