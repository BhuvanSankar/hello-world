/**
 * 
 */
package dist;


import java.io.IOException;

import dist.ExtractTrPeriods.TrPeriods;

/**
 * @author buvan.suji
 *
 */
public class InputLimit {

	/**
	 * @param args
	 * @throws IOException 
	 */
	
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		TrPeriods trpds = ExtractTrPeriods.TrLimits();
		System.out.println(trpds.GetNewTrLimits());
		

	}

}
