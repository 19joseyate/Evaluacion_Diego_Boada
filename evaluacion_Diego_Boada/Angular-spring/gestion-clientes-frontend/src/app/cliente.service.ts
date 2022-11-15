import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Cliente } from './cliente';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {
  
  //esta url obtiene el listado de todos los clientes en el backend
  private baseURL = "http://localhost:8080/api/v1/clientes";
  
  constructor(private httpClient : HttpClient) { }

  //este metodo me sirve para obtener los clientes
  obtenerListaDeClientes():Observable<Cliente[]>{
    return this.httpClient.get<Cliente[]>(`${this.baseURL}`); 
  }

  //este metodo sirve para registrar un cliente
  registrarCliente(cliente:Cliente) : Observable<Object>{
    return this.httpClient.post(`${this.baseURL}`,cliente);
  }

  //este metodo sirve para actualizar el cliente
  actualizarCliente(id:number,cliente:Cliente) : Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/${id}`,cliente);
  }

  //este metodo sirve para obtener o buscar un cliente
  optenerClientePorId(id:number):Observable<Cliente>{
    return this.httpClient.get<Cliente>(`${this.baseURL}/${id}`);
  }

  eliminarCliente(id:number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/${id}`);
  }

}
