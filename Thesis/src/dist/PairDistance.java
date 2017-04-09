/**
 * 
 */
package dist;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import dist.DistTwoSeq.EditDistanceResult;

/**
 * @author buvan.suji
 *
 */
public class PairDistance {	

	/**
	 * @param args
	 */
	
	static ArrayList<String> descript = new ArrayList<String>();
	static ArrayList<String> reads = new ArrayList<String>();
	static int Nreads;
	static String FileName;
	static int NumberElements;
	private static double [][] temps;
	
	public static double[][] Distance() throws Exception{

		// TODO Auto-generated method stub		
		
    	TreadsDescriptionFromFasta.DestReads();
    	descript = TreadsDescriptionFromFasta.GetRname();
    	reads= TreadsDescriptionFromFasta.GetTReads();
    	Nreads = TreadsDescriptionFromFasta.NumberReads();
    	FileName = TreadsDescriptionFromFasta.GetFileName();
    	NumberElements = TreadsDescriptionFromFasta.SeqLength();
    	
    	double[][] table = new double[Nreads][Nreads];	
		
		for (int i=0; i<Nreads; ++i){
			for(int j=0;j<Nreads;++j){
				table[i][j]=0;
			}
		}
    	
    	File file = new File("C:/Users/Subashchandran/Marseclipse/workspace/Data/TrResults/OutputDistance/distresult_"+FileName);
    	
        FileWriter fw = new FileWriter(file.getAbsoluteFile());
		
		BufferedWriter bw = new BufferedWriter(fw);
    	
    	for(int i=0; i<reads.size(); i++){
    		for(int j=i+1; j<reads.size(); j++){
    			String x = reads.get(i);
    			String y = reads.get(j);
    			/*String u = descript.get(i);
    			String v = descript.get(j);*/    			
    			EditDistanceResult result = DistTwoSeq.compute(x, y);
    			double normdist = ((double)result.getDistance())/Math.max(x.length(), y.length());
    			table[i][j]=normdist;
    			String content = "d("+i+", "+j+") = "+ normdist;
    			bw.write(content); 
	    		bw.newLine();		
    		    		
    		}
    	}
    	
    	bw.close();   	
    	
    	/*System.out.println(descript.get(0));
    	System.out.println(reads.get(0));
    	System.out.println(Nreads);
    	System.out.println(FileName);*/
    	return table;
	
		
	}
	
	
	public static void main(String[] args) throws Exception {
		temps = Distance();
		
		
		
	}

}
