/**
 * 
 */
package server;


import java.io.IOException;

import server.ExtractTrPeriodsServer.TrPeriodsServer;

/**
 * @author buvan.suji
 *
 */
public class InputLimitServer {

	/**
	 * @param args
	 * @throws IOException 
	 */
	
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		TrPeriodsServer trpds = ExtractTrPeriodsServer.TrLimits();
		System.out.println(trpds.GetNewTrLimits());
		

	}

}
