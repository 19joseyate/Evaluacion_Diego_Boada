import { ClienteService } from '../cliente.service';
import { Cliente } from '../cliente';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import 'sweetalert2/src/sweetalert2'
import swal from 'sweetalert2';

@Component({
  selector: 'app-registrar-cliente',
  templateUrl: './registrar-cliente.component.html',
  styleUrls: ['./registrar-cliente.component.css']
})
export class RegistrarClienteComponent implements OnInit {

  cliente : Cliente = new Cliente();
  constructor(private clienteServicio:ClienteService,private router:Router) { }

  ngOnInit(): void {
  }

  guardarCliente(){
    this.clienteServicio.registrarCliente(this.cliente).subscribe(dato =>{
      console.log(dato);
      this.irAlaListaDeClientes();
    },error => console.log(error));
  }

  irAlaListaDeClientes(){
    this.router.navigate(['/clientes']);
    swal('Cliente registrado',`El cliente ${this.cliente.cedula} ha sido registrado con exito`,`success`);
  }

  onSubmit(){
    this.guardarCliente();
  }
}
