package server;

import java.util.ArrayList;

public class ClustTemp {
	
	static int count1,count2,count3;
	static int d[];
	static int k[][];
	static int tempk[][];
	static int m[];
	static double diff[];
	static ArrayList<Integer> t = new ArrayList<Integer>() ;
	static int n;	
	final static int p =2;
	static double max = 0;
	static double temp1 = 0;
	static int index1;
	static int index2;
	static double list[][] = new double [4][4];
	
	
	
	public static void clustering(){
		for (int i=0; i<4; ++i){
			for(int j=0;j<4;++j){
				list[i][j]=0;
			}
		}
		list[0][1]= 13;  //0.47697218422252624;
		list[0][2]= 16;  //0.33105335157318744;
		list[0][3]= 25;  //0.37756497948016415;
		list[1][2]= 26; //0.4864608076009501;
		list[1][3]= 30;  //0.5284749034749034;
		list[2][3]= 36;  //0.4551068883610451;		
		
		n = 4;
		d=new int[n];
		
		 //name of the reads		
		for(int i=0;i<n;++i){
			d[i]=i;
		}	
		
		 //Initialising arrays 
		k=new int[p][n];
		tempk=new int[p][n];		
		m=new int [p];
		diff=new double[p];		
		
		for (int i = 0; i < 4; i++) {
			for (int j = i + 1; j < 4; j++) {
				temp1 = list[i][j];
				if(max < temp1){
					max = temp1;
					index1=i;
					index2=j;
				}
			}
		}			
		
		 //Initializing m 
		m[0] = index1;
		m[1] = index2;		
		
		int temp=0;
		int flag=0;
		
		do{
			for(int i=0;i<p;++i){
				for(int j=0;j<n;++j){
					k[i][j]=-1;					
				}
			}
			
			for(int i=0;i<n;++i){
				temp=NewCluster(d[i]);					
				if(temp==0){
					k[temp][count1++]=d[i];					
				}
				else if(temp==1){
					k[temp][count2++]=d[i];					
				}					 
			}
			
			NewMean(); // call to method which will calculate mean at this step.
			flag = VerifyEqual(); // check if terminating condition is satisfied.
			if(flag!=1){
				/*Take backup of k in tempk so that you can check for equivalence in next step*/
				for(int i=0;i<p;++i){
					for(int j=0;j<n;++j){
						tempk[i][j]=k[i][j];
					}
				}				
			}
			
			System.out.println("\nClusters Results:");
			for(int i=0;i<p;++i){
				System.out.print("C"+(i+1)+"{ ");
				for(int j=0;k[i][j]!=-1 && j<n-1;++j)
				System.out.print(k[i][j]+" ");
				System.out.println("}");
			}
			//end of for loop
			
			System.out.println("\nCentroid of the clusters are: ");
			for(int i=0;i<p;++i){
				System.out.print("m"+(i+1)+"="+m[i]+"  ");
			}	
			count1=0;count2=0;count3=0;			
		}
		while(flag==0);
		
		System.out.println("\n\n\nThe Final Clusters By Kmeans are as follows: ");
		for(int i=0;i<p;++i){
			System.out.print("C"+(i+1)+"{ ");
			for(int j=0;k[i][j]!=-1 && j<n-1;++j){
				System.out.print(k[i][j]+" ");
			}
			
			System.out.println("}");
		}		
	}	
	
	public static int NewCluster(int a){ 		
		//int temp1=0;		
		for(int i=0;i<p;++i){
			if(a<m[i]){
				diff[i] = list[a][m[i]];
			}
			else if(a>m[i]){
				diff[i] = list[m[i]][a];
			}
			else{
				diff[i]=0;
			}			
		}
		
		int val=0;
		double temp=diff[0];
		for(int i=0;i<p;++i){
			if(diff[i]<temp){
				temp=diff[i];
				val=i;
			}
			
		}//end of for loop
		
		return val;
	}
	
	
	static void NewMean(){
		
		for(int i=0;i<p;++i){
			m[i]=0; // initializing means to 0			
		}
		
		//int cnt=0;
		for(int i=0;i<p;++i){			
			
			for(int j=0;j<n-1;++j){								
				if(k[i][j]!=-1){
					t.add(k[i][j]);
				}
			}
				
			ArrayList<Double> s = new ArrayList<Double>();				
				
			for(int x1 = 0; x1<t.size();++x1){
				double sum = 0;					
				for(int x2=0;x2<t.size();++x2){
					if(t.get(x1)<t.get(x2)){
						sum = sum+list[t.get(x1)][t.get(x2)];
					}
					else if(t.get(x1)>t.get(x2)){
						sum = sum+list[t.get(x2)][t.get(x1)];
					}
					else{
						sum = sum+0;
					}	
				}
					//System.out.println(sum);
					
					s.add(sum/t.size());					
			}
			//System.out.println(s.size());
			double min=s.get(0);	
			int d2 = 0;
			for(int x3=1;x3<s.size();++x3){					
				if(min>s.get(x3)){
					min = s.get(x3);
					d2  = x3;
				}					
			}	
				
			
			m[i]=t.get(d2);
			s.clear();
			t.clear();
			
		}
	}
	
	// This checks if previous k ie. tempk and current k are same.Used as terminating case.
	static int VerifyEqual(){	
		for(int i=0;i<p;++i){
			for(int j=0;j<n;++j){
				if(tempk[i][j]!=k[i][j]){
					return 0;
				}
			}				
		}		
		return 1;
	}	

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		clustering();		
	}

}
