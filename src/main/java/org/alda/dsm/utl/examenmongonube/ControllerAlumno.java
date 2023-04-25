package org.alda.dsm.utl.examenmongonube;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ControllerAlumno{
    @FXML
    private TextField txtId;

    @FXML
    private TextField txtMatricula;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtPrimerApellido;

    @FXML
    private TextField txtSegundoApellido;

    @FXML
    private TextField txtCarrera;

    @FXML
    private Button btnGuardar;

    @FXML
    private Label lblResultado;

    @FXML
    private Button btnActualizar;

    @FXML
    private Button btnBorrar;

    @FXML
    private Button btnMostrar;

    ConexionMongoNube cmn=new ConexionMongoNube();

    public void guardar(){
        Alumno alumno=new Alumno();
        alumno.setIdAlumno(Integer.parseInt(txtId.getText()));
        alumno.setMatricula(txtMatricula.getText());
        alumno.setNombre(txtNombre.getText());
        alumno.setPrimerApellido(txtPrimerApellido.getText());
        alumno.setSegundoApellido(txtSegundoApellido.getText());
        alumno.setCarrera(txtCarrera.getText());
        if(cmn.insertar(alumno)==true){
            lblResultado.setText("Los datos se guardaron con exito.");
        } else{
            lblResultado.setText("Hubo un error al guardar los datos");
        }
    }

    public void actualizar(){
        Alumno alumnoAnterior = new Alumno();
        Alumno alumnoNuevo = new Alumno();
        if (txtId!=null) {
            alumnoAnterior.setIdAlumno(Integer.parseInt(txtId.getText()));
            alumnoNuevo.setIdAlumno(Integer.parseInt(txtId.getText()));
            alumnoNuevo.setMatricula(txtMatricula.getText());
            alumnoNuevo.setNombre(txtNombre.getText());
            alumnoNuevo.setPrimerApellido(txtPrimerApellido.getText());
            alumnoNuevo.setSegundoApellido(txtSegundoApellido.getText());
            alumnoNuevo.setCarrera(txtCarrera.getText());
            if(cmn.actualizar(alumnoAnterior,alumnoNuevo)==true){
                lblResultado.setText("Los datos se actualizaron con exito.");
            } else{
                lblResultado.setText("Hubo un error al actualizar los datos");
            }
        } else{
            txtId.setText("Asigna un valor al id");
        }
    }

    public void mostrar(){
        if(cmn.mostrar()==true){
            lblResultado.setText("Los datos fueron mostrados en la consola");
            clean();
        } else{
            lblResultado.setText("Hubo un error al mostrar los datos");
            clean();
        }
    }

    public void eliminar(){
        if(txtId!=null) {
            int idAlumno = Integer.parseInt(txtId.getText());
            if (cmn.eliminar(idAlumno) == true) {
                lblResultado.setText("El registro fue eliminado con exito");
                clean();
            } else {
                lblResultado.setText("Error al eliminar el registro");
            }
        } else{
            txtId.setText("Asigna un valor al id");
        }
    }

    public void clean(){
        txtId.setText("");
        txtMatricula.setText("");
        txtNombre.setText("");
        txtPrimerApellido.setText("");
        txtSegundoApellido.setText("");
        txtCarrera.setText("");
    }
}
