package com.aditya;

//import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.*;
import java.util.*;
import java.io.*;
import java.lang.*;
public class App
{   
	public static final Logger logg=LogManager.getLogger(App.class);
	public static void main(String[] args)throws IOException
	{
		BasicConfigurator.configure();  
        	logg.debug("\nEnter 1 for Interest Calculation,2 for House Construction Estimate :");
        	Scanner sc=new Scanner(System.in);
        	int choice=sc.nextInt();
		Interest obj=new Interest();
		Construction estimate=new Construction();
        	if (choice==1)
			obj.execute();
		else
			estimate.execute();
        
    	}
}
class Interest
{
	static final Logger logg=LogManager.getLogger(Interest.class);
	double time,rate,principal;
	void execute()throws IOException
	{
		//BasicConfigurator.configure();
		logg.debug("\nEnter 1 for Simple Interest,2 for Compound Interest(compd annualy):");
		Scanner sc=new Scanner(System.in);
        	int choice=sc.nextInt();
		read();
		double ans;
		if(choice==1)
			ans=SI();
		else
			ans=CI();
		String Ans=String.format("%.2f",ans);
		
		logg.debug("\nInterest=Rs "+Ans);
	}
	void read()throws IOException
	{
		//BasicConfigurator.configure();
		Scanner sc=new Scanner(System.in);
		logg.debug("\nEnter Principal=");
		principal=sc.nextDouble();
		logg.debug("\nEnter time(years)=");
		time=sc.nextDouble();
		logg.debug("\nEnter annual interest rate(%)=");
		rate=sc.nextDouble();
	}
	double SI()
	{
		return(principal*(rate/100)*time);
	}
	double CI()
	{
		return(principal*(Math.pow((1+rate/100),time)-1));
	}
}

class Construction
{
	static final Logger logg=LogManager.getLogger(Construction.class);
	double area;int material,automated;
	void execute()throws IOException
	{
		//BasicConfigurator.configure();
		read();
		String Ans=String.format("%.2f",calculate());
		logg.debug("\nTotal cost estimate=Rs "+Ans);
	}
	void read()throws IOException
	{
		//BasicConfigurator.configure();
		Scanner sc=new Scanner(System.in);
		logg.debug("\nEnter area(sq.ft)=");
		area=sc.nextDouble();
		logg.debug("\nEnter 1 for standard material,2 for above standard,3 for High standard:");
		material=sc.nextInt();
		if(material==3)
		{
			logg.debug("\nPress 1 for automated,0 for ordinary:");
			automated=sc.nextInt();
		}
	}
	double calculate()
	{
		if(material==1)
			return(area*1200.00);
		else 
			if(material==2)
				return(area*1500.00);
			else 
				if(material==3 && automated==1)
					return(area*2500.00);
				else
					return(area*1800.00);
				
	}
}

		
		
		
		