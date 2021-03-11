import { INavData } from '@coreui/angular';

export const navItems: INavData[] = [
  {
    name: 'Inicio',
    url: '/theme',
    icon: 'icon-speedometer',
  },
  {
    title: true,
    name: 'Reportes'
  },
  {
    name: 'Icfes Colegio',
    url: '/dashboard',
    icon: 'icon-puzzle',
  },
  {
    name: 'Resultado icfes areas',
    url: '/base',
    icon: 'icon-puzzle',
  },
  {
    name: 'Desempeño por area',
    url: '/buttons',
    icon: 'icon-cursor',
  },
  {
    name: 'Desempeño por Grados',
    url: '/charts',
    icon: 'icon-pie-chart'
  },
  {
    name: 'Recurso Docente',
    url: '/icons',
    icon: 'icon-star',
  },
  {
    name: 'Matriculas',
    url: '/notifications',
    icon: 'icon-bell',
  },
  {
    name: 'Resumen indicadores operativos',
    url: '/widgets',
    icon: 'icon-calculator',
    
  },
  {
    divider: true
  },
  {
    name: 'Administracion',
    url: 'http://jundry.tech/maestro',
    icon: 'icon-star'
  },
  {
    name: 'Usuarios',
    url: '/register',
    icon: 'icon-star'
  },
  {
    name: 'Cerrar Sesion',
    url: '/theme/typography',
    icon: 'icon-star'
  }
];
