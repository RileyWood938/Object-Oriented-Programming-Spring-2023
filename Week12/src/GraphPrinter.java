import org.knowm.xchart.*;

import java.io.IOException;

/**
 * @author Riley Wood
 * @version April 29th, 2023
 * This file Graphs Data using the xChart library
 */
public class GraphPrinter {
    /**
     * This method displays and saves a graph of given data on a logarithmic scale. It takes multiple series' of data and plots
     * them on a single chart.
     * @param seriesNames takes a list of strings: the names of each series on the graph.
     * @param xData takes an array of doubles. These act as the x-coordinates of each graph. It is assumed they will be
     *             shared between all series since all tests are run on the same benchmarks.
     *              TODO: allow for different X-data inputs per series (change this to take double[][])
     * @param yData takes a matrix of doubles which represent the input data for each series. The rows represent which
     *              series the data relates to, and the columns represent which test the given time is related to.
     * @throws IOException if saving or displaying the image fails, an IO exception will be thrown
     */
    public void createMultiSeriesGraph(String[] seriesNames, double[] xData, double[][] yData) throws IOException {

        // Create Chart
        XYChart chart = new XYChartBuilder().width(600).height(400).title("Sorting Methods Speed Comparison").xAxisTitle("Sorting Set Size").yAxisTitle("Sorting Time").build();

        for(int i=0; i<seriesNames.length; i++){ //add all input series to the chart
            chart.addSeries(seriesNames[i], xData, yData[i]);
        }

        //set it to be logarithmic
//        chart.getStyler().setXAxisLogarithmic(true);
//        chart.getStyler().setYAxisLogarithmic(true);

        //display and save it
        new SwingWrapper(chart).displayChart();
        BitmapEncoder.saveBitmapWithDPI(chart, "./SortingMethodsSpeedChart", BitmapEncoder.BitmapFormat.PNG, 300);
    }

}
