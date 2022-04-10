import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Produto } from '../modelo/Produto';

@Injectable({
  providedIn: 'root'
})

export class ProdutosService {

  constructor(private http: HttpClient) {
  }

  listar(): Observable<Produto[]> {
    return this.http.get<Produto[]>('http://localhost:3000/produtos');
  }

  cadastrar(produto: Produto): Observable<Produto> {
    return this.http.post<Produto>('http://localhost:3000/produtos', produto)
  }

  alterar(id: number, produto: Produto): Observable<Produto> {
    return this.http.put<Produto>('http://localhost:3000/produtos/' + id, produto)
  }

  remover(id: number): Observable<void> {
    return this.http.delete<void>('http://localhost:3000/produtos/' + id)
  }
}
