import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-pg1',
  templateUrl: './pg1.component.html',
  styleUrls: ['./pg1.component.css']
})
export class Pg1Component implements OnInit {

  texto: string = 'Aprendendo Angular';

  nomes: string[] = ['Ciro', 'Neto', 'Amanda'];

  visivel: boolean = false;

  constructor() { }

  acao = () => {
    this.visivel = !this.visivel;
  }

  ngOnInit(): void {
  }

}
