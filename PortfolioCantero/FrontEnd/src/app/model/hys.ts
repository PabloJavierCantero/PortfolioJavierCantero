export class Hys {

    id: number;
    gestion: number;
    equipo: number;
    resolucion: number;
    ingles: number;
    habilidades: number;
    fullstack: number;

    constructor(gestion: number, equipo: number, resolucion: number, ingles: number, habilidades: number, fullstack: number){
        this.equipo = equipo;
        this.gestion = gestion;
        this.resolucion = resolucion;
        this.ingles = ingles;
        this.habilidades = habilidades;
        this.fullstack = fullstack;
    }

}
