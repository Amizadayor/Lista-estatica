import java.util.*; //java.util: Contiene el marco de recopilación, las clases de recopilación heredadas, el modelo de evento, las instalaciones de fecha y hora, la internacionalización y las clases de utilidad varias (un tokenizador de cadenas, un generador de números aleatorios y una matriz de bits).//
import java.util.Scanner; //java.util.Scanner: La clase Scanner facilita la lectura de datos.//
import javax.swing.JOptionPane;

class ListaS{ //creamos la clase lista//
  public static int pos = -1;
  private int max = 6; // Definimos el rango maximo//
  private Empleado[] lista = new Empleado[max];
  Scanner t = new Scanner (System.in); //esto nos sirve para obtener todos lo datos de entrada  como int, double, etc.
    private Empleado LeerA(){ // Pedimos lo datos que se van a agregar.
      Empleado a = new Empleado();
      mensaje ("  ______________________________ ");   //Pedimos los datos a ingresar//
      mensaje (" |     INGRESE SU NOMBRE:       |");
      mensaje (" |______________________________|");
      a.setNombre (t.next());
      mensaje ("  ______________________________ ");
      mensaje (" | INGRESE SU APELLIDO PATERNO: |");
      mensaje (" |______________________________|");
      a.setApellidoPa (t.next());
      mensaje ("  ______________________________ ");
      mensaje (" | INGRESE SU APELLIDO MATERNO: |");
      mensaje (" |______________________________|");
      a.setApellidoMa (t.next());
      mensaje ("  ______________________________ ");
      mensaje (" |      INGRESE SU EDAD:        |");
      mensaje (" |______________________________|");
      a.setEdad (t.nextInt());
      mensaje ("  ______________________________ ");
      mensaje (" |     NOMBRE DE SU EMPRESA:    |");
      mensaje (" |______________________________|");
      a.setEmpresa (t.next());
      mensaje ("  ______________________________ ");
      mensaje (" |         INGRESE SU CLAVE:    |");
      mensaje (" |______________________________|");
      a.setClave (t.nextInt());
      return a;
    }
    private void mensaje (String cad){
      System.out.println (cad);
    }
    private boolean hayEspacio(){
      return pos < (max-1);
    }
    private boolean existenElementos(){
      return pos!=-1;
    }
    private int Leer (){
      return t.nextInt();
    }
    private void insertar(){ // Pedimos los elementos a insertar en la lista
      int v; // v: validacion//
        do{  // Aqui va la validacion en la que solo se admitira numeros enteros y en caso de no ser así, se lanzara un mensaje de error.
            try{
                v=0;
                if (hayEspacio()){
                  pos++;
                  mensaje ("  INGRESE DATO "+ pos +" A INSERTAR :  ");
                  lista[pos]= LeerA();
                }else    //Si los lugares de nuestra lista se terminan, se lanzara un mensaje de error en donde nos indique que los jugares se han terminado.
              JOptionPane.showMessageDialog(null,"  NO HAY MAS POSICIONES PARA INGRESAR DATOS ", " ERROR ", JOptionPane.ERROR_MESSAGE);
            }catch (Exception e){
              JOptionPane.showMessageDialog(null, " INGRESE SOLO NUMEROS ENTEROS.", " ERROR ", JOptionPane.ERROR_MESSAGE);  // mensaje de error de la validacion
              v=0;
              t.nextLine();
              pos--;
            }
        }while (v != 0); // Final de la validacion.
    }
    private void editar(){ // en esta parte se hacen la funciones para editar los elementos de la lista
      int posE;
      boolean v = true; //v: primera validacion //
      int sv; //sv: segunda validacion//
        do{     // Aqui va la validacion en la que solo se admitira numeros enteros y en caso de no ser así, se lanzara un mensaje de error.
            try{
                sv=0;
                if (existenElementos()){
                  listar();
                    do{        // en esta parte pedimos la posicion del dato que vayamos a editar.//
                      mensaje ("  ________________________________________________ ");
                      mensaje (" |  INGRESE LA POSICION A EDITAR (0..."+pos+"):   |");
                      mensaje (" |________________________________________________|");
                      posE = Leer();
                        if ((posE >= 0) && (posE<=pos)){
                          mensaje ("  ______________________________________ ");  // Pedimos el valor del nuevo elemento a ingresar
                          mensaje (" |  INGRESE VALOR DEL NUEVO ELEMENTO :  |");
                          mensaje (" |______________________________________|");
                          lista[posE] = LeerA();
                          JOptionPane.showMessageDialog(null," DATO EDITADO "); // mensaje de que se ha editado correctamente.
                          v = false;
                          listar();
                        }else
                      JOptionPane.showMessageDialog(null,"  NUMERO NO ENCONTRADO ", " ERROR ", JOptionPane.ERROR_MESSAGE); // mensaje de error en la que no se encontro el numero a editar
                    }while (v);
                }else
              JOptionPane.showMessageDialog(null,"  NO EXISTEN ELEMENTOS EN LA LISTA ", " ERROR ", JOptionPane.ERROR_MESSAGE); // mensaje de error en la que nos dice que no hay ningun elemento agregado en la lista.
            }catch (Exception e){
              JOptionPane.showMessageDialog(null, " INGRESE SOLO NUMEROS ENTEROS.", " ERROR ", JOptionPane.ERROR_MESSAGE); // mensaje de error de la validacion
              sv=1;
              t.nextLine();
            }
        }while (sv!=0); // Final de la validacion.
    }
    private void eliminar() { // en esta parte se hace la funcion para eliminar los datos de la lista
      int posE;
      boolean v = true; // V: validacion.
        if (existenElementos()){
          listar();
            do{        // Aqui va la validacion en la que solo se admitira numeros enteros y en caso de no ser así, se lanzara un mensaje de error.
                try{           // pedimos la posicion del dato que se desea a eliminar
                  mensaje ("  __________________________________________________________ ");
                  mensaje (" |  INGRESE LA POSICION DEL DATO A ELIMINAR (0..."+pos+") : |");
                  mensaje (" |__________________________________________________________|");
                  posE = Leer();
                    if ((posE>=0) && (posE<=pos)){
                      for (int i=posE; i<pos; i++)
                      lista[i] = lista[i+1];
                      pos--;
                      JOptionPane.showMessageDialog(null," DATO ELIMINADO. "); // mensaje de que el dato ha sido eliminado correctamente.
                      v = false;
                      listar();
                    }else
                  JOptionPane.showMessageDialog(null," NUMERO NO ENCONTRADO ", " ERROR ", JOptionPane.ERROR_MESSAGE); // mensaje de error en la que no se encontro el numero a eliminar
                }catch (Exception e){
                  JOptionPane.showMessageDialog(null," INGRESE SOLO NUMEROS ENTEROS ", " ERROR ", JOptionPane.ERROR_MESSAGE); // mensaje de errror de la validacion.
                  v=true;
                  t.nextLine();
                }
            }while (v!= true); // final de la validacion
        }else
      JOptionPane.showMessageDialog(null," NO HAY ELEMENTOS EN LA LISTA. ", " ERROR ", JOptionPane.ERROR_MESSAGE); // mensaje de error cuando no tenga ningun elemento nuestra lista
    }

    private void consultar(){ // en esta parte se hace la funcion que nos servira para consultar un dato en especifico, en la que nos mostrara la posicion en la que se encuentra
      int posE;
      int v; // v: primera validacion //
      boolean sv = true; // sv: segunda validacion//
        do{    // Aqui va la validacion en la que solo se admitira numeros enteros y en caso de no ser así, se lanzara un mensaje de error.
            try{
                v= 0;
                    if(existenElementos()){
                      listar();
                        do{               // pedimos la posicion del dato que se desee consultar o encontrar.
                          mensaje ("  ________________________________________________________ ");
                          mensaje (" |  INGRESE POSICION DEL DATO A CONSULTAR (0..."+pos+") : |");
                          mensaje (" |________________________________________________________|");
                          posE = Leer();
                            if((posE >= 0) && (posE<=pos)){
                              mensaje (" POSICION [" +posE+ "]= " + lista[posE]);
                              JOptionPane.showMessageDialog(null," DATO CONSULTADO CORRECTAMENTE "); // mensaje de que el dato se a encontrado correctamente
                              sv = false;
                              listar();
                            }else
                          JOptionPane.showMessageDialog(null,"  NUMERO NO ENCONTRADO ", " ERROR ", JOptionPane.ERROR_MESSAGE); // mensaje de error cuando el dato a consultar no se encuentre en nuestra lista.
                        }while(sv);
                    }else
                 JOptionPane.showMessageDialog(null,"  NO EXISTEN ELEMENTOS EN LA LISTA ", " ERROR ", JOptionPane.ERROR_MESSAGE); // mensaje de error cuando se quiera consultar y la lista este vacia
            }catch (Exception e){
              JOptionPane.showMessageDialog(null, " INGRESE SOLO NUMEROS ENTEROS.", " ERROR ", JOptionPane.ERROR_MESSAGE); // mensaje de error de la validacion
              v=1;
              t.nextLine();
            }
        }while (v != 0); // final de la validacion
    }
    private void listar(){ // esta parte nos servira para mostrar en forma de lista todos los elementos disponibles en nuestra lista.
        if (existenElementos()){
          mensaje ("  ____________________");
          mensaje (" |   LISTADO GENERAL  |");  // mensaje de cuando se muestre el listado general de los datos en la lista
          mensaje (" |____________________|");
          for(int i=0;i<=pos; i++)
          mensaje (" POSICION [" +i+ "]= " + lista[i].toString());
          mensaje ("  ______________________");
          mensaje (" |   LISTADO TERMINADO  |");  // mensaje de cuando la accion de listar sea finalizado.
          mensaje (" |______________________|");
        }else{
          JOptionPane.showMessageDialog(null,"  NO SE ENCONTRO NINGUN ELEMENTO INSERTADO EN LA LISTA ", " ERROR ", JOptionPane.ERROR_MESSAGE); // mensaje de error cuando no exista ningun elemento en la lista
        }
    }
    public void menu(){ // En esta parte va el menu de opciones , en donde podras elegir alguna accion que quieras realizar.
      int op;
      int v; //v: validacion//
        do{    // Aqui va la validacion en la que solo se admitira numeros enteros y en caso de no ser así, se lanzara un mensaje de error.
            try{
              v=0;
                do{      // se muestra el menu con las opciones que se mostrata al iniciar el programa
                  mensaje (" _____________________");
                  mensaje ("|   MENU DE OPCIONES  |");
                  mensaje ("|                     |");
                  mensaje ("|   1. INSERTAR       |");
                  mensaje ("|   2. EDITAR         |");
                  mensaje ("|   3. ELIMINAR       |");
                  mensaje ("|   4. COSULTAR       |");
                  mensaje ("|   5. LISTAR         |");
                  mensaje ("|   6. SALIR          |");
                  mensaje ("|_____________________|");
                  mensaje ("|  INGRESE SU OPCION: |");
                  mensaje ("|_____________________|");
                  op = t.nextInt();
                    switch (op) { // funcion de cada opcion
                      case 1: insertar();
                      break;
                      case 2: editar();
                      break;
                      case 3: eliminar();
                      break;
                      case 4: consultar();
                      break;
                      case 5: listar();
                      break;
                      case 6:
                      break;
                      default: JOptionPane.showMessageDialog(null, " NO EXISTE ESTA OPCION ", " ERROR ", JOptionPane.ERROR_MESSAGE); // mensaje de error cuando la opcion ingresada no se encuentre en el menu de opciones
                      break;
                    }
                }while(op != 6);
            }catch (Exception e){
              JOptionPane.showMessageDialog(null, " INGRESE SOLO NUMEROS ENTEROS.", " ERROR ", JOptionPane.ERROR_MESSAGE); // mensaje de error de la validacion
              v=1;
              t.nextLine();
            }
        }while(v != 0); // final de la validacion
    }
    public static void main (String[] args){
      ListaS l = new ListaS();
      l.menu();
    }
}