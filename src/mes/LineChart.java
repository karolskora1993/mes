package mes;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.ApplicationFrame;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class LineChart extends ApplicationFrame
{
	private Calculations calc;
   public LineChart( String applicationTitle , String chartTitle, Calculations calc)
   {
      super(applicationTitle);
      this.calc=calc;
      JFreeChart lineChart = ChartFactory.createLineChart(
         chartTitle,
         "odległość[m]","temperatura",
         createDataset(),
         PlotOrientation.VERTICAL,
         true,true,false);
         
      ChartPanel chartPanel = new ChartPanel( lineChart );
      chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
      setContentPane( chartPanel );
   }

   private DefaultCategoryDataset createDataset( )
   {
	   FemGrid fg=calc.getFemGrid();
	   Result result=calc.getResult();
	   double[] tg=result.getTg();
	   Node[] nodes=fg.getNodes();
	   
      DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
      for(int i=0; i<tg.length;i++){
    	  dataset.addValue( tg[i], "temperatura" , String.valueOf(nodes[i].getX()) );
      }
      return dataset;
   }
}