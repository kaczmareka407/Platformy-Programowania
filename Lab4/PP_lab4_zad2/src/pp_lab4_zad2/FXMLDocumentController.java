/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pp_lab4_zad2;

import java.awt.Color;
import java.awt.Rectangle;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BubbleChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;

/**
 *
 * @author user
 */
public class FXMLDocumentController implements Initializable
{

    Integer a = new Integer(0);
    Integer b = new Integer(0);
    Integer c = new Integer(0);

    @FXML
    private Label label;
    @FXML
    private Button OK;
    @FXML
    private TextField A, B, C;

    @FXML
    private ComboBox Select;


    @FXML
    CategoryAxis xAxisChart;
    @FXML
    NumberAxis yAxisChart;

    @FXML
    CategoryAxis xAxisLine;
    @FXML
    NumberAxis yAxisLine;

    @FXML
    CategoryAxis xAxisArea;
    @FXML
    NumberAxis yAxisArea;

    //@FXML
    @FXML
    private ScatterChart<?, ?> sc;
    @FXML
    private LineChart<?, ?> lc;
    @FXML
    private AreaChart<?, ?> ac;



    @FXML
    private void handleTextField(ActionEvent event)
    {

    }

    @FXML
    private GridPane grid;

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        label.setText("f(x)=A*x^2+B*x+C");

        this.OK.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent e)
            {

                try
                {
                    Integer a = Integer.valueOf(A.getText());
                    Integer b = Integer.valueOf(B.getText());
                    Integer c = Integer.valueOf(C.getText());
                    System.out.println("OK");
                    //System.out.println(A.getText() + "  " + B.getText() + "  " + C.getText());
                    //System.out.println(a + "  " + b + "  " + c);

                    final NumberAxis xAxis = new NumberAxis();
                    xAxis.setSide(Side.BOTTOM);
                    final NumberAxis yAxis = new NumberAxis();
                    yAxis.setSide(Side.LEFT);


                    XYChart.Series series_sc = new XYChart.Series();
                    XYChart.Series series_lc = new XYChart.Series();
                    XYChart.Series series_ac = new XYChart.Series();

                    for (int x = -30; x <= 30; x++)
                    {
                        series_sc.getData().add(new XYChart.Data(Integer.toString(x), ((a * x * x + b * x + c))));
                        series_lc.getData().add(new XYChart.Data(Integer.toString(x), ((a * x * x + b * x + c))));
                        series_ac.getData().add(new XYChart.Data(Integer.toString(x), ((a * x * x + b * x + c))));
                    }
                    sc.getData().addAll(series_sc);
                    lc.getData().addAll(series_lc);
                    ac.getData().addAll(series_ac);

                    switch (Select.getValue().toString())
                    {
                        case "Scatter":
                        {
                            sc.setVisible(true);
                            lc.setVisible(false);
                            ac.setVisible(false);
                            break;
                        }
                        case "Line":
                        {
                            sc.setVisible(false);
                            lc.setVisible(true);
                            ac.setVisible(false);
                            break;
                        }
                        case "Area":
                        {
                            sc.setVisible(false);
                            lc.setVisible(false);
                            ac.setVisible(true);
                            break;
                        }
                        default:
                        {
                            break;
                        }
                    }

                   
                } catch (Exception e2)
                {

                }
            }
        });

    }
}
