package org.alda.dsm.utl.examenmongonube;

public class Alumno{
    private int idAlumno;
    private String matricula;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private String carrera;

    public Alumno(int idAlumno, String matricula, String nombre, String primerApellido, String segundoApellido, String carrera){
        this.idAlumno=idAlumno;
        this.matricula=matricula;
        this.nombre=nombre;
        this.primerApellido=primerApellido;
        this.segundoApellido=segundoApellido;
        this.carrera=carrera;
    }

    public Alumno(){
    }

    public int getIdAlumno(){
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno){
        this.idAlumno=idAlumno;
    }

    public String getMatricula(){
        return matricula;
    }

    public void setMatricula(String matricula){
        this.matricula=matricula;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public String getPrimerApellido(){
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido){
        this.primerApellido=primerApellido;
    }

    public String getSegundoApellido(){
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido){
        this.segundoApellido=segundoApellido;
    }

    public String getCarrera(){
        return carrera;
    }

    public void setCarrera(String carrera){
        this.carrera=carrera;
    }
}
