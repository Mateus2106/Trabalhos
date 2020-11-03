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
import trabalho_javafx.Trabalho_JavaFX;

/**
 *
 * @author Mateus
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Button btnAdicionar;

    @FXML
    private TableView<Anime> tbListaAnimes;

    @FXML
    private TableColumn<?, ?> tlId;

    @FXML
    private TableColumn<?, ?> tlDescricao;

    @FXML
    private TableColumn<?, ?> tlStatus;

    @FXML
    private TableColumn<?, ?> tlProgresso;

    @FXML
    private Label label;

    @FXML
    private Button btnExcluir;

    @FXML
    private TableColumn<?, ?> tlAno;

    @FXML
    private Button btnEditar;

    @FXML
    private TableColumn<?, ?> tlTitulo;

    @FXML
    private TableColumn<?, ?> tlNota;
    
    @FXML
    private TextField txtAno;
    
    @FXML
    private TextField txtProgresso;
    
    @FXML
    private Button btnSalvar;

    @FXML
    private ComboBox<?> cbNota;

    @FXML
    private ComboBox<?> cbStatus;

    @FXML
    private Button btnCancelar;

    @FXML
    private TextArea txtDescricao;

    @FXML
    private TextField txtTitulo;
    
    @FXML
    private AnchorPane painelPrincipal;
    
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
    
    
    public void atualizaTabela(){
        ObservableList<Anime> listaAnimes = FXCollections.observableArrayList();
        Database db = new Database();
        db.startConnection();
        Anime anime = new Anime(db.getConnection());
        try{
            ResultSet listaResult = anime.getListaAnimes();
            while(listaResult.next()){
                Anime animeAux = new Anime();
                animeAux.setId(listaResult.getInt("id"));
                animeAux.setTitulo(listaResult.getString("titulo"));
                animeAux.setStatus(listaResult.getString("status"));
                animeAux.setAnoLancamento(listaResult.getInt("anoLancamento"));
                animeAux.setProgresso(listaResult.getInt("progresso"));
                animeAux.setDescricao(listaResult.getString("descricao"));
                animeAux.setNota(listaResult.getDouble("nota"));
                listaAnimes.add(animeAux);
            }
            db.endConnection();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        tbListaAnimes.setItems(listaAnimes);
    }
    
    public void cliqueBotaoAdicionar(MouseEvent event){
        Node node = (Node) event.getSource();

        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/view/FXMLView2.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    void cliqueBotaoExcluir(MouseEvent event) {
        if(tbListaAnimes.getSelectionModel().getSelectedItem() != null){
            Database db = new Database();
            db.startConnection();
            Anime animeExclui = tbListaAnimes.getSelectionModel().getSelectedItem();
            animeExclui.setConnection(db.getConnection());
            if(mostrarMensagemConfirmacao("Excluir Anime?", "Deseja mesmo excluir este anime? "+animeExclui.getTitulo()));
            try{
                animeExclui.deleteAnime(animeExclui.getId());
                atualizaTabela();
            }
            catch(SQLException ex){
                mostrarMensagemErro("Erro ao Excluir", "Não foi possivel excluir o registro!", "");
            }
            db.endConnection();
        }
        else{
            mostrarMensagemErro("Erro", "Selecione uma linha", "excluir");
        }
    }

    @FXML
    void cliqueBotaoEditar(MouseEvent event){
        if(tbListaAnimes.getSelectionModel().getSelectedItem() != null){
            Anime livroAux = tbListaAnimes.getSelectionModel().getSelectedItem();
            
            Node node = (Node) event.getSource();

            Stage stage = (Stage) node.getScene().getWindow();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("/view/FXMLView2.fxml"));
            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            
        }
        else{
            mostrarMensagemErro("Erro", "Selecione uma linha", "alterar");
        }
    }
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Image imagemAdicionar = new Image(getClass().getResourceAsStream("/images/iconeNovo.png"));
        Image imagemEditar = new Image(getClass().getResourceAsStream("/images/iconeAlterar.png"));
        Image imagemExcluir = new Image(getClass().getResourceAsStream("/images/iconeDeletar.png"));
        
        btnAdicionar.setGraphic(new ImageView(imagemAdicionar));    
        btnEditar.setGraphic(new ImageView(imagemEditar));     
        btnExcluir.setGraphic(new ImageView(imagemExcluir));       
        
        tlId.setCellValueFactory(new PropertyValueFactory("id"));
        tlTitulo.setCellValueFactory(new PropertyValueFactory("titulo"));
        tlStatus.setCellValueFactory(new PropertyValueFactory("status"));
        tlAno.setCellValueFactory(new PropertyValueFactory("anoLancamento"));
        tlProgresso.setCellValueFactory(new PropertyValueFactory("progresso"));
        tlDescricao.setCellValueFactory(new PropertyValueFactory("descricao"));
        tlNota.setCellValueFactory(new PropertyValueFactory("nota"));
        
        //atualizaTabela();
    }      
}
