class Empleado{

    private String nombre;
    private String apellidopa;
    private String apellidoma;
    private int edad;
    private String empresa;
    private int clave;

    public void setNombre( String nombre ){
      this.nombre = nombre;
    }
    public void setApellidoPa( String apellidopa ){
      this.apellidopa = apellidopa;
    }
    public void setApellidoMa( String apellidoma){
      this.apellidoma = apellidoma;
    }
    public void setEdad( int edad ){
      this.edad = edad;
    }
    public void setEmpresa( String empresa ){
      this.empresa = empresa;
    }
    public void setClave( int clave ){
      this.clave = clave;
    }

    public String getNombre(){
      return this.nombre;
    }
    public String getApellidoPa(){
      return this.apellidopa;
    }
    public String getApellidoMa(){
      return this.apellidoma;
    }
    public int getEdad(){
      return this.edad;
    }
    public String getEmpresa(){
      return this.empresa;
    }
    public int getClave(){
      return this.clave;
    }
    public String toString(){
      return this.nombre + " - " + this.apellidopa + " - " + this.apellidoma + " - " + this.edad + " - " + this.empresa + " - " + this.clave;
    }
}