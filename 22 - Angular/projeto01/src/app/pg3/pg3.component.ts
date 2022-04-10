import { Component, OnInit } from '@angular/core';
import { NgModel } from '@angular/forms';
import { Produto } from '../modelo/Produto';
import { ProdutosService } from '../servicos/produtos.service';

@Component({
  selector: 'app-pg3',
  templateUrl: './pg3.component.html',
  styleUrls: ['./pg3.component.css']
})
export class Pg3Component implements OnInit {
  inputProduto: string = ''
  inputMarca: string = ''
  inputValor: number = 0

  produtos: Produto[] = [];
  objProduto: Produto = new Produto();
  btnVisivel: boolean = true;
  indiceUsuarioSelecionado :number = -1;

  constructor(private servico: ProdutosService) { }

  //Executa após carregar toda a estrutura do componente
  ngOnInit(): void {
    this.getProdutos();
  }

  //Obter os produtos
  getProdutos = () => {
    this.servico.listar()
      .subscribe(retorno => this.produtos = retorno);
  }

  cancelar = () => {
    this.btnVisivel = true;
    this.inputProduto = ''
    this.inputMarca = ''
    this.inputValor = 0
    this.indiceUsuarioSelecionado = -1;
  }

  cadastrar = () => {
    this.objProduto.produto = this.inputProduto;
    this.objProduto.marca = this.inputMarca;
    this.objProduto.valor = this.inputValor;

    this.servico.cadastrar(this.objProduto)
      .subscribe(retorno => this.produtos.push(retorno));
  }

  alterar = () => {
    this.objProduto.produto = this.inputProduto;
    this.objProduto.marca = this.inputMarca;
    this.objProduto.valor = this.inputValor;

    this.servico.alterar(this.objProduto.id, this.objProduto)
    .subscribe(retorno => this.produtos[this.indiceUsuarioSelecionado] = this.objProduto)
  }

  selecionarProduto = (indice: number) => {
    this.btnVisivel = false;

    this.objProduto = this.produtos.find(obj => obj.id === indice)!;

    this.inputProduto = this.objProduto.produto;
    this.inputMarca = this.objProduto.marca;
    this.inputValor = this.objProduto.valor;

    this.indiceUsuarioSelecionado = this.produtos.findIndex(obj => obj.id === indice);
  }

  remover = () => {
    this.servico.remover(this.objProduto.id)
    .subscribe(retorno => this.produtos.splice(this.indiceUsuarioSelecionado, 1))
  }
}
