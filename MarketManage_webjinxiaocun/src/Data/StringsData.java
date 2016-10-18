package Data;

import java.util.ArrayList;

public class StringsData {
	
	private int choose;
	private ArrayList<String> data;
	
	public StringsData()
	{
		data= new ArrayList<String>();
	}
	public void loadData(String[] strings)
	{
		data.clear();
		int i=0;
		for(i=0;i<strings.length;i++)
			data.add(strings[i]);
	}
	public String getStringData()
	{
		String stringData=new String();
		int i=0;
		for(i=0;i<data.size();i++)
		{
			stringData+=(data.get(i)+";");
		}
		return stringData;
	}
	public void loadData(String string)
	{
		String []tempdata=string.split(";");
		data.clear();
		for(int i=0;i<tempdata.length;i++)
			data.add(tempdata[i]);
	}
	public void add(String string)
	{
		data.add(string);
	}
	public String[] getArrayStringData()
	{
		String []tempdata=new String[data.size()];
		for(int i=0;i<tempdata.length;i++)
			tempdata[i]=data.get(i);
		return tempdata;
	}
	public int getChoose()
	{
		return choose;
	}
	public void setChoose(int newChoose)
	{
		choose=newChoose;
	}
}
