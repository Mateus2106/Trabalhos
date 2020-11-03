/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import database.Database;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Anime;
import controller.FXMLDocumentController;
import static javax.xml.bind.JAXBIntrospector.getValue;

/**
 *
 * @author Mateus
 */
public class FXMLDocumentControllerView3 implements Initializable {
    
    @FXML
    private Button btnAdicionar;

    @FXML
    private TableView<Anime> tbListaAnimes;
    
    
    @FXML
    private TableView<Anime> idTable;

    @FXML
    private TableColumn<Anime, Integer> tlId;

    @FXML
    private TableColumn<Anime, String> tlDescricao;

    @FXML
    private TableColumn<Anime, String> tlStatus;

    @FXML
    private TableColumn<Anime, Integer> tlProgresso;
    
    @FXML
    private TableColumn<Anime, Integer> tblId;

    @FXML
    private Label label;

    @FXML
    private Button btnExcluir;

    @FXML
    private TableColumn<Anime, Integer> tlAno;

    @FXML
    private Button btnEditar;

    @FXML
    private TableColumn<Anime, String> tlTitulo;

    @FXML
    private TableColumn<Anime, Double> tlNota;
    
    @FXML
    private TextField txtAno;
    
    @FXML
    private TextField txtProgresso;
    
    @FXML
    private Button btnSalvar;

    @FXML
    private ComboBox<String> cbNota;

    @FXML
    private ComboBox<String> cbStatus;

    @FXML
    private Button btnCancelar;

    @FXML
    private TextArea txtDescricao;

    @FXML
    private TextField txtTitulo;
    
    @FXML
    private AnchorPane painelPrincipal;
      
    @FXML
    private TextField txtId;
    
    private Anime editar;
    
    public void setAtributo(Anime atributo){
        this.editar = atributo;
        txtTitulo.setText(editar.getTitulo());
        cbStatus.setValue(editar.getStatus());
        txtAno.setText(Integer.toString(editar.getAnoLancamento()));
        txtProgresso.setText(Integer.toString(editar.getProgresso()));
        txtDescricao.setText(editar.getDescricao());
        int nota2 = (int) editar.getNota();
        cbNota.setValue(Integer.toString(nota2));
    }
    
    public void mostrarMensagemErro(String titulo, String mensagem, String acao) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(mensagem);
        alert.setContentText("Selecione uma linha antes de "+acao+" um registro.");
        alert.showAndWait();
    }
    public void mostraMensagemInformacao(String titulo, String mensagem){
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(mensagem);
        alert.showAndWait();
    }
    
    public boolean mostrarMensagemConfirmacao(String titulo, String mensagem){
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(mensagem);
        alert.getButtonTypes().clear();
        alert.getButtonTypes().add(ButtonType.YES);
        alert.getButtonTypes().add(ButtonType.NO);
        Optional<ButtonType> option = alert.showAndWait();

        return option.get() == ButtonType.YES; 
    }
    
    @FXML
    void cliqueBotaoSalvar(MouseEvent event) throws SQLException {
        Database db = new Database();
        db.startConnection();
        editar.setConnection(db.getConnection());
        Anime animeSalvar = new Anime(db.getConnection());
         
        animeSalvar.setId(editar.getId());
        animeSalvar.setTitulo(txtTitulo.getText());
        animeSalvar.setStatus((String) cbStatus.getValue());
        animeSalvar.setAnoLancamento(Integer.parseInt(txtAno.getText()));
        animeSalvar.setProgresso(Integer.parseInt(txtProgresso.getText()));
        animeSalvar.setDescricao(txtDescricao.getText());
        animeSalvar.setNota(Integer.parseInt((String) cbNota.getValue()));
        try{
            animeSalvar.updateAnime();
        }catch (SQLException ex){
            mostrarMensagemErro("Erro", "Não foi possível adicionar o anime!","");
        }
        
        Node node = (Node) event.getSource();

        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/view/FXMLView1.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    void cliqueBotaoCancelar(MouseEvent event){
        if(mostrarMensagemConfirmacao("Cancelar?", "Deseja mesmo cancelar e voltar a tela inicial")){
            Node node = (Node) event.getSource();

            Stage stage = (Stage) node.getScene().getWindow();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("/view/FXMLView1.fxml"));
            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } 
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> status = FXCollections.observableArrayList(
            "Completo",
            "Assistindo",
            "Pausado",
            "Dropado",
            "Plano de assistir"
        );
        cbStatus.setItems(status);
        
        ObservableList<String> nota = FXCollections.observableArrayList(
            "1",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "9",
            "10"
        );
        cbNota.setItems(nota);
        
        Image imagemSalvar = new Image(getClass().getResourceAsStream("/images/iconeSalvar.png"));
        Image imagemCancelar = new Image(getClass().getResourceAsStream("/images/iconeCancelar.png"));
        
        btnSalvar.setGraphic(new ImageView(imagemSalvar));
        btnCancelar.setGraphic(new ImageView(imagemCancelar));
    }    
    
}
