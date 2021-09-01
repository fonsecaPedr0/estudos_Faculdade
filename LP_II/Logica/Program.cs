using System;

namespace Livraria
{
    class Program
    {
        static void Main(string[] args)
        {
            Clientes cliente = new Clientes();
            Produtos produto = new Produtos();
            Livro livro = new Livro();
            Autores autores = new Autores();
            Assuntos assunto = new Assuntos();
            Editoras editoras = new Editoras();
            Funcionarios funcionarios = new Funcionarios();
            Fornecedores fornecedores = new Fornecedores();
            Compras compras = new Compras();
            Caixa caixa = new Caixa();

            cliente.Nome = "Pedro";
            cliente.CpfCnpj = 00000000098;
            cliente.Telefone = 991829191;

            produto.Descricao = "Mochila";
            produto.Quatidade = 50;
            produto.Valor = 150.50;

            livro.Descricao = "The Power";
            livro.Isbn = 145585;
            livro.DataPubli = "01/03/2018";
            livro.Valor = 45.00;

            autores.Nome = "Monteiro Lobato";

            assunto.Nome = "Ficção cientifica";

            editoras.Nome = "Editora Brasil";
            editoras.dataCadastro = "04/08/2018";

            funcionarios.Nome = "João";
            funcionarios.Setor = "Comercial";
            funcionarios.Cargo = "Vendedor";

            fornecedores.Nome = "Mochilas SHIN";
            fornecedores.dataCadastro = "15/06/2017";

            compras.Id = 1;
            compras.Qtd = 5;

            caixa.DataFechamento = "01/08/2021";
            caixa.TotalDiario = 0.10;

            Console.WriteLine("Dados do Cliente: ");
            cliente.mostrarDados();
            
            Console.WriteLine("Dados do Produto: ");
            produto.mostrarDados();

            Console.WriteLine("Dados do Livro: ");
            livro.mostrarDados();

            Console.WriteLine("Dados do Autor: ");
            autores.mostrarDados();

            Console.WriteLine("Dados do Assunto: ");
            assunto.mostrarDados();

            Console.WriteLine("Dados da Editora: ");
            editoras.mostrarDados();
            
            Console.WriteLine("Dados dos Funcionarios: ");
            funcionarios.mostrarDados();

            Console.WriteLine("Dados dos Fornecedores: ");
            fornecedores.mostrarDados();

            Console.WriteLine("Dados da Compra: ");
            compras.mostrarDados();

            Console.WriteLine("Dados do caixa: ");
            caixa.mostrarDados();
        }
    }
}
