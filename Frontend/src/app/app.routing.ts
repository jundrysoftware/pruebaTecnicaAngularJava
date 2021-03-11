import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ClienteComponent } from './Components/cliente/cliente.component';
import { FacturaComponent } from './Components/factura/factura.component';
import { ProductoComponent } from './Components/producto/producto.component';

export const routes: Routes = [
  {
    path: '',
    redirectTo: 'factura',
    pathMatch: 'full',
  },
  {
    path: 'factura',
    component: FacturaComponent,
    data: {
      title: 'Factura'
    }
  },
  {
    path: 'producto',
    component: ProductoComponent,
    data: {
      title: 'Producto'
    }
  },
  {
    path: 'cliente',
    component: ClienteComponent,
    data: {
      title: 'Cliente'
    }
  }
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}
