import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Hys } from 'src/app/model/hys';
import { HysService } from 'src/app/service/hys.service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-habilidades',
  templateUrl: './habilidades.component.html',
  styleUrls: ['./habilidades.component.css']
})
export class HabilidadesComponent implements OnInit {

  hys: Hys[] = [];  
  gestion: number;
  equipo: number;
  resolucion: number;
  ingles: number;
  habilidades: number;
  fullstack: number;

  constructor(private sHys: HysService, private tokenService: TokenService, private router: Router) { }

  isLogged = false;

  ngOnInit(): void {
    this.cargarHys();
    if(this.tokenService.getToken()){
      this.isLogged = true;      
    } else {
      this.isLogged = false;
    }
  }


  cargarHys(): void{
    this.sHys.lista().subscribe(data =>{this.hys = data});
  }

  delete(id: number){
    if(id != undefined){
      this.sHys.delete(id).subscribe(data => {this.cargarHys()},
      err =>{
        alert("No se pudo borrar HyS");
      }
        )
    }
  }

  onCreate(): void{
    const hys = new Hys(this.gestion, this.equipo, this.resolucion, this.ingles, this.fullstack, this.habilidades);
    this.sHys.save(hys).subscribe(data => {
     alert("HyS creado correctamente");
     this.router.navigate(['']);
  }, err => {
    alert("Fallo la creacion de HyS");
    this.router.navigate(['']);
  })
  }
  

}
