import { Component, OnInit } from '@angular/core';
import { MethodApiRestServiceService } from '../../services/method-api-rest-service.service';
import swal from 'sweetalert2';
@Component({
  selector: 'app-factura',
  templateUrl: './factura.component.html',
  styleUrls: ['./factura.component.css']
})
export class FacturaComponent implements OnInit {

  constructor(private rest: MethodApiRestServiceService) { }

  ngOnInit(): void {
    this.getProductos();
    this.getClientes();
  }

  productos: any[] = [];
  clientes: any[] = [];

  precio:string;
  producto:number;
  cliente:number;
  cant:number;

  getProductos() {
    this.rest.GetMethod('/producto')
      .subscribe(response => {
        if (response == null || response == undefined || response == "") {
          swal.fire("Ups!", "Productos no encontrados", "error");
        } else {
          for (let x in response) {
            this.productos.push(response[x]);
          }
        }
      },
        error => {
          if (!error.ok) {
            swal.fire("Ups!", "Error en Petición", "error");
          }
        }
      );
  }


  getClientes() {
    this.rest.GetMethod('/cliente')
      .subscribe(response => {
        if (response == null || response == undefined || response == "") {
          swal.fire("Ups!", "Clientes no encontrados", "error");
        } else {
          for (let x in response) {
            this.clientes.push(response[x]);
          }
        }
      },
        error => {
          if (!error.ok) {
            swal.fire("Ups!", "Error en Petición", "error");
          }
        }
      );
  }

  Guardar() {
    
    let date: Date = new Date();
    var fechahoy = date.getDay() + '-' + date.getMonth() +'-'+date.getFullYear();
    let datos={
      "num_factura":null,
      "id_cliente": {
        "id_cliente" : this.cliente
      },
      "fecha":fechahoy
    }
    this.rest.PostMethod('/factura',datos)
      .subscribe(response => {
        if (response == null || response == undefined || response == "") {
          swal.fire("Ups!", "No se pudo facturar", "error");
        } else {
          let num_fact= response['num_factura'];
          this.crearDetalle(num_fact)
        }
      },
        error => {
          if (!error.ok) {
            swal.fire("Ups!", "Error en Petición", "error");
          }
        }
      );
  }

  crearDetalle(fact) {
    let datos={
      "num_detalle":null,
      "num_factura": {
        "num_factura": fact
      },
      "id_producto": {
        "id_producto": this.producto
      },
      "cantidad":this.cant,
      "precio":this.precio
    }
    this.rest.PostMethod('/detalle',datos)
      .subscribe(response => {
        if (response == null || response == undefined || response == "") {
          swal.fire("Ups!", "No se pudo facturar", "error");
        } else {
          swal.fire("Producto Facturado", "", "success");
        }
      },
        error => {
          if (!error.ok) {
            swal.fire("Ups!", "Error en Petición", "error");
          }
        }
      );
  }
}

