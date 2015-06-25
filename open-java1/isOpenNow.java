import java.io.FileReader;
import java.util.Calendar;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;


public class isOpenNow {
	public static void main(String args[]){
		String inputFileName="storetime.txt";
		int []Time=new int[28];
		Time= removeZero(readFile(inputFileName));
		int size=getSize(Time);
		int timeNow[]=new int[2];
		timeNow=whatTimeIsIt();
		int preparedTime=prepare(timeNow);
		System.out.println(isOpenNow(Time,preparedTime,size));
	}
	public static int[] readFile(String inputFileName){
		String openTime[]=new String[20];
		String day[]=new String[7];
		String hour1[]=new String[2];
		String hour2[]=new String[2];
		String open_close1[]=new String[14];
		String open_close2[]=new String[14];
		String tmp1[]=new String[2];
		String tmp2[]=new String[2];
		int Time[]=new int[28];
		String day_week[]=new String[7];
		day_week[0]="SUNDAY";day_week[1]="MONDAY";day_week[2]="TUESDAY"; 
		day_week[3]="WEDNESDAY";day_week[4]="THURSDAY";day_week[5]="FRIDAY";
		day_week[6]="SATURDAY";
		try{
		BufferedReader br=new BufferedReader(new FileReader(inputFileName));
		String str;
			int i=0;int j=0;
			while((str=br.readLine())!=null){
			openTime=str.split("\t");
			day[i]=openTime[0];
			hour1=openTime[1].split("~");
			open_close1[i]=hour1[0];
			open_close1[i+1]=hour1[1];
			hour2=openTime[2].split("~");
			open_close2[i]=hour2[0];
			open_close2[i+1]=hour2[1];
				if(day[i].equals(day_week[i])){
					if((open_close1[i].compareTo("閉店中"))!=0){
						tmp1=open_close1[i].split(":");
						tmp2=open_close1[i+1].split(":");
						Time[j]=Integer.parseInt(tmp1[0])+24*i;
						Time[j+1]=Integer.parseInt(tmp2[0])+24*i;
					}
					if((open_close2[i].compareTo("閉店中"))!=0){
						tmp1=open_close2[i].split(":");
						tmp2=open_close2[i+1].split(":");
						Time[j+2]=Integer.parseInt(tmp1[0])+24*i;
						Time[j+3]=Integer.parseInt(tmp2[0])+24*i;
					}
				}
				i++;j+=4;
			}
			br.close();
		}catch(FileNotFoundException e){
			System.out.println(e);
		}catch(IOException e){
			System.out.println(e);
		}
		
		return Time;
	}
	public static void print(int Time[]){
		for(int i=0;i<28;i++){
			System.out.println(Time[i]);
		}
	}
	public static int[] removeZero(int Time[]){
		for(int i=0;i<24;i++){
			if(Time[i]==0&&Time[i+1]==0){
				if(Time[i+2]!=0){
					for(int j=0;j<26-i;j++){
						Time[i+j]=Time[i+j+2];	
					}
				}else if(Time[i+3]==0){
					for(int j=0;j<24-i;j++){
						Time[i+j]=Time[i+j+4];
					}
				}
			}
		}
		return Time;
	}
	public static int getSize(int Time[]){
		int size=0;
		for(int i=0;i<28;i++){
			if(Time[i+1]<=Time[i]){
				size=i+1;
				break;
			}
		}
		return size;		
	}
	public static int[] whatTimeIsIt(){
		int []timeNow=new int[3];
		Calendar calendar=Calendar.getInstance();
		timeNow[0]=calendar.get(Calendar.DAY_OF_WEEK);
		timeNow[1]=calendar.get(Calendar.HOUR_OF_DAY);
		return timeNow;
	}
	public static int prepare(int timeNow[]){
		int preparedTime=(timeNow[0]-1)*24+timeNow[1];
		return preparedTime;
	}
	
	public static boolean isOpenNow(int Time[],int preparedTime,int size){
		for(int i=0;i<size-1;i+=2){
			if(Time[i]<=preparedTime&&preparedTime<=Time[i+1]){
				return true;
			}
		}
		return false;
	}
}