/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package chartadvancedscatter;

import javafx.application.Application;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

/**
 * An advanced scatter chart with a variety of controls.
 *
 * @see javafx.scene.chart.ScatterChart
 * @see javafx.scene.chart.Chart
 * @see javafx.scene.chart.Axis
 * @see javafx.scene.chart.NumberAxis
 */
public class ChartAdvancedScatter extends Application
{

    private void init(Stage primaryStage)
    {

        Group root = new Group();
        primaryStage.setScene(new Scene(root));
        root.getChildren().add(createChart());
    }

    protected ScatterChart<Number, Number> createChart()
    {
        final NumberAxis xAxis = new NumberAxis();
        xAxis.setSide(Side.BOTTOM);
        final NumberAxis yAxis = new NumberAxis();
        yAxis.setSide(Side.LEFT);
        final ScatterChart<Number, Number> sc = new ScatterChart<Number, Number>(xAxis, yAxis);
        // setup chart
        xAxis.setLabel("X Axis");
        yAxis.setLabel("Y Axis");

        // add starting data
        XYChart.Series<Number, Number> series1 = new XYChart.Series<Number, Number>();
        XYChart.Series<Number, Number> series2 = new XYChart.Series<Number, Number>();
        XYChart.Series<Number, Number> series3 = new XYChart.Series<Number, Number>();
        series1.setName("Data Series1 ");
        series2.setName("Data Series2 ");
        series3.setName("Data Series3 ");

        for (int x = -30; x <= 30; x += 2)
        {
            //f(x)=0
            series1.getData().add(new XYChart.Data<Number, Number>(x, 0));
            //f(x)=-x^2
            series2.getData().add(new XYChart.Data<Number, Number>(x, x * x * (-1)));
            //f(x)=x^2-x+3
            series3.getData().add(new XYChart.Data<Number, Number>(x, x * x - x + 3));
        }

        sc.getData().addAll(series1, series2, series3);

        return sc;
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        init(primaryStage);
        primaryStage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        launch(args);
    }
}
