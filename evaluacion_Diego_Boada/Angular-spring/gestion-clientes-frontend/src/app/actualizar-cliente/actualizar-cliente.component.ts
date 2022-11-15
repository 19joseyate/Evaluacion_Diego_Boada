import 'sweetalert2/src/sweetalert2';
import swal from 'sweetalert2';
import { ClienteService } from './../cliente.service';
import { Cliente } from './../cliente';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';


@Component({
  selector: 'app-actualizar-cliente',
  templateUrl: './actualizar-cliente.component.html',
  styleUrls: ['./actualizar-cliente.component.css']
})
export class ActualizarClienteComponent implements OnInit {

  id:number;
  cliente:Cliente = new Cliente();
  constructor(private clienteService:ClienteService,private router:Router,private route:ActivatedRoute) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.clienteService.optenerClientePorId(this.id).subscribe(dato =>{
      this.cliente = dato;
    },error => console.log(error));
  }
  irAlaListaDeClientes(){
    this.router.navigate(['/clientes']);
    swal('Cliente actualizado',`El cliente ${this.cliente.nombre} ha sido actualizado con exito`,`success`);
  }

  onSubmit(){
    this.clienteService.actualizarCliente(this.id,this.cliente).subscribe(dato => {
      this.irAlaListaDeClientes();
    },error => console.log(error));
  }



}
