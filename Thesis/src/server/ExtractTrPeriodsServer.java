/**
 * 
 */
package server;

import java.io.*;
import java.util.ArrayList;

/**
 * @author buvan.suji
 *
 */
public class ExtractTrPeriodsServer {

	/**
	 * @param args
	 */
	
		// TODO Auto-generated method stub
	
	
	public static final class TrPeriodsServer{
		
		private ArrayList<String> trlimits2;
		private ArrayList<String> newtrlimits2;
		
		TrPeriodsServer(ArrayList<String> trlimits2, ArrayList<String> newtrlimits2 ) {
			this.trlimits2 = trlimits2;
			this.newtrlimits2 = newtrlimits2;
		}
			
		public ArrayList<String> GetTrLimits(){
				return trlimits2;
		}
		
		public ArrayList<String> GetNewTrLimits(){
			return newtrlimits2;
		}
	}
	
	public static TrPeriodsServer TrLimits()throws IOException{
		
		BufferedReader in = null;
		
		try {
	         in = new BufferedReader(new FileReader("hg19_VNTR.xaf"));	         
	         
	         String str;
	         ArrayList<String> list = new ArrayList<String>();
	         ArrayList<String> trlimits = new ArrayList<String>();
	         ArrayList<String> newtrlimits= new ArrayList<String>();
	         
	         
	         String[] num1 = null;
	         String[] num2 = null;
	         
	         int s1;
	         int s2;
	         
	         while ((str = in.readLine()) != null) {	        	 
	        	 list.add(str);       	 
	         }		         
	         
	         for(int i=1;i<list.size();i++){
	        	 String[] columns = list.get(i).split("\t");
	        	 trlimits.add(columns[10]);	        	 
	         }
	         
	         for(int j=0;j<trlimits.size();j++){
	        	 num1 = trlimits.get(j).split(":");
	        	 num2 = num1[1].split("-");
	        	 s1 = (Integer.parseInt(num2[0])-30);
	        	 s2 = (Integer.parseInt(num2[1])+30);
	        	 newtrlimits.add(num1[0]+":"+s1+"-"+s2);
	         }
	         return new TrPeriodsServer(trlimits, newtrlimits);
	      }finally {
	         if (in != null) {
	            in.close();
	         }
	         
	      }
		
	}
		
		
		public static void main(String[] args) throws IOException {
			
			TrPeriodsServer limit = TrLimits();
			limit.GetTrLimits();
			System.out.println(limit.GetTrLimits());
			System.out.println(limit.GetTrLimits().size());
			System.out.println(limit.GetNewTrLimits());
			System.out.println(limit.GetNewTrLimits().size());
			
			
		}


		
}
