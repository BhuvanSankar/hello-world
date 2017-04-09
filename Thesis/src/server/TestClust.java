package server;

public class TestClust {
	
	static int count1,count2,count3;
	static int d[];
	static int k[][];
	static int tempk[][];
	static int m[];
	static double diff[];
	static int n;	
	final static int p =2;
	static double max = 0;
	static double temp1 = 0;
	static int index1;
	static int index2;
	static double list[][] = new double [4][4];
	
	
	
	
	public static int cal_diff(int a , double dst[][]){ 		
		//int temp1=0;		
		for(int i=0;i<p;++i){
			if(a<m[i]){
				diff[i] = dst[a][m[i]];
			}
			else if(a>m[i]){
				diff[i] = dst[m[i]][a];
			}
			else{
				diff[i]=0;
			}
			//System.out.println("hello  "+ diff[i]);
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
	
	static void cal_mean(double dst[][]){ 
		
		for(int i=0;i<p;++i){
			m[i]=0; // initializing means to 0
		}		
		int cnt=0;
		for(int i=0;i<p;++i){
			cnt=0;
			for(int j=0;j<n-1;++j){
				if(k[i][j]!=-1){
					m[i]+=k[i][j];
					++cnt;
				}
			}
			m[i]=m[i]/cnt;
		}
	}
	
	
	static int check1(){	
		for(int i=0;i<p;++i){
			for(int j=0;j<n;++j)
				if(tempk[i][j]!=k[i][j]){
					return 0;
				}
		}		
		return 1;
	}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for (int i=0; i<4; ++i){
			for(int j=0;j<4;++j){
				list[i][j]=0;
			}
		}
		list[0][1]= 0.47697218422252624;
		list[0][2]= 0.33105335157318744;
		list[0][3]= 0.37756497948016415;
		list[1][2]= 0.4864608076009501;
		list[1][3]= 0.5284749034749034;
		list[2][3]= 0.4551068883610451;
		
		/*System.out.println(list[1][1]);
		System.out.println(list[1][3]);*/
		
		
		n = 4;
		d=new int[n];
		
		 //Accepting elements 	
		
		for(int i=0;i<n;++i){
			d[i]=i;
			//System.out.println(d[i]);
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
		
		/*System.out.println(max);
		System.out.println(index1);
		System.out.println(index2);*/
		
		 //Initializing m 
		m[0] = index1;
		m[1] = index2;
			
		int temp=0;
		int flag=0;
		do
		{
			for(int i=0;i<p;++i){
				for(int j=0;j<n;++j){
					k[i][j]=-1;
				}
			}
			
			//System.out.println(k[1][3]);
			
			
			// for loop will cal cal_diff(int) for every element.
			for(int i=0;i<n;++i){
				temp=cal_diff(d[i], list);	
				System.out.println(temp);
				if(temp==0){
					k[temp][count1++]=d[i];
					//System.out.println(k[temp][count1++]);
				}
				else if(temp==1){
					k[temp][count2++]=d[i];
					//System.out.println(k[temp][count2++]);
				}
				/*else if(temp==2){
					k[temp][count3++]=d[i];
					//System.out.println(k[temp][count3++]);
				}*/
					 
			}
			
			/*cal_mean(list); // call to method which will calculate mean at this step.
			flag=check1(); // check if terminating condition is satisfied.
			if(flag!=1){
				//Take backup of k in tempk so that you can check for equivalence in next step
				for(int i=0;i<p;++i){
					for(int j=0;j<n;++j){
						tempk[i][j]=k[i][j];
					}
				}				
			}
			
		
			//System.out.println("\n\nAt this step");
			//System.out.println("\nValue of clusters");
			
			for(int i=0;i<p;++i){
				System.out.print("K"+(i+1)+"{ ");
				for(int j=0;k[i][j]!=-1 && j<n-1;++j){
					System.out.print(k[i][j]+" ");
				}					
				System.out.println("}");
			}
			//end of for loop
			
			
			//System.out.println("\nValue of m ");
			for(int i=0;i<p;++i){
				//System.out.print("m"+(i+1)+"="+m[i]+"  ");
			}	*/
			count1=0;count2=0;count3=0;
		}
		while(flag==0);
	
		System.out.println("\n\n\nThe Final Clusters By Kmeans are as follows: ");
		for(int i=0;i<p;++i){
			System.out.print("K"+(i+1)+"{ ");
			for(int j=0;k[i][j]!=-1 && j<n-1;++j){
				System.out.print(k[i][j]+" ");
			}
			
			System.out.println("}");
		}
	
		

		
		
		// C:\Users\buvan.suji\workspace\Distance\SampleData\results\TR_Fasta\OutputReads\chr11119005_1121390.fasta
		// C:\Users\buvan.suji\workspace\Distance\SampleData\results\TR_Fasta\OutputReads\chr1842862036_42864557.fasta
		//C:/Users/Subashchandran/Marseclipse/workspace/Data/TrResults/chr11119005_1121390.fasta
	}

	

}
