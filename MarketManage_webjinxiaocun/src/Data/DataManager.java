package Data;

import java.util.LinkedList;

public class DataManager {

	private LinkedList<StringsData> data;
	
	public DataManager()
	{
		data=new LinkedList<StringsData>();
	}
	
	public int getSize()
	{
		return data.size();
	}
	
	public void add(int choose,String []strings)
	{
		StringsData temp=new StringsData();
		temp.setChoose(choose);
		temp.loadData(strings);
		data.add(temp);
	}
	public void add(int choose,String string)
	{
		StringsData temp=new StringsData();
		temp.setChoose(choose);
		temp.loadData(string);
		data.add(temp);
	}
	public StringsData get(int i)
	{
		return data.get(i);
	}
	public void send()
	{
		
	}
	public void receive()
	{
		
	}
}
