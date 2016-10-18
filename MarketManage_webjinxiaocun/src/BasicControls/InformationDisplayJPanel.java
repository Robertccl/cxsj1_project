package BasicControls;

import java.awt.*;
import java.awt.List;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

public class InformationDisplayJPanel extends JPanel
{
	private String changedData=new String();
	
	private Box boxInformationDisplayBox;
	
	private JScrollPane jspInformationDisplayJScrollPane;
	private JTable jtInformationDisplayJTable;
	private JScrollPane jspDetailedInformationJScrollPane;
	private JTabbedPane jtpDetailedInformationJTabbedPane;
	
	private LinkedList<ArrayList<String>> selectedDataList=new LinkedList<ArrayList<String>>();
	private ArrayList<String> DataJTableColumnName=new ArrayList<String>();
	
	
	private boolean mutex=true;
	private int []oldRow=null;
	public InformationDisplayJPanel()
	{
		boxInformationDisplayBox=Box.createHorizontalBox();
		//boxInformationDisplayBox.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		
		InitInformationDisplayJScrollPane();
		InitDetailedInformationJScrollPane();
		
		boxInformationDisplayBox.add(jspInformationDisplayJScrollPane);
		boxInformationDisplayBox.add(Box.createHorizontalStrut(10));
		boxInformationDisplayBox.add(jspDetailedInformationJScrollPane);
		
		super.add(boxInformationDisplayBox);
	}
	
		
	private void InitDetailedInformationJScrollPane() 
	{
		jtpDetailedInformationJTabbedPane=new JTabbedPane(JTabbedPane.LEFT,JTabbedPane.SCROLL_TAB_LAYOUT);
		
		jspDetailedInformationJScrollPane=new JScrollPane(jtpDetailedInformationJTabbedPane);
		Dimension scrSize=Toolkit.getDefaultToolkit().getScreenSize();
		jspDetailedInformationJScrollPane.setPreferredSize(
				new Dimension(scrSize.width/2-50,
						(int)(scrSize.height/2-50.0*scrSize.height/scrSize.width)));
		//jspDetailedInformationJScrollPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		

	}
	private void UpdataDetailedInformation()
	{
		jtpDetailedInformationJTabbedPane.removeAll();
		
		int i;
		int rowLength=selectedDataList.size();
		
		String[]columnName={"类别","值"};
		
		String[][]Data=new String[DataJTableColumnName.size()][2];
		
		for(i=0;i<rowLength;i++)
		{
			InitJTabbedPaneData(selectedDataList.get(i),Data);
			jtpDetailedInformationJTabbedPane.add(selectedDataList.get(i).get(0),new NewTabJPanel(Data,columnName));
		}
		jtpDetailedInformationJTabbedPane.validate();
	}
	

	private void UpdataDetailedInformation(int changedRow, int changedColumn,String newData) 
	{
		Component component=jtpDetailedInformationJTabbedPane.getComponentAt(changedRow).getComponentAt(100, 100);
		//JTable jtChangedTable=(JTable)jtpDetailedInformationJTabbedPane.getSelectedComponent();
		//jtChangedTable.setValueAt(newData, changedColumn, 1);
	}
	private void InitJTabbedPaneData(ArrayList<String> selectedData,String[][] Data)
	{
		for(int i=0;i<selectedData.size();i++) {
			Data[i][0]=DataJTableColumnName.get(i);
			Data[i][1]=selectedData.get(i);
		}
	}
	
	private void GetColumnName(String []columnName)
	{
		DataJTableColumnName.clear();
		
		int i;
		int columnNameLength=columnName.length;
		for(i=0;i<columnNameLength;i++)
		{
			DataJTableColumnName.add(columnName[i]);
		}
	}
	

	private void InitInformationDisplayJScrollPane()
	{
		String [][]columnData=new String[100][50];
		String []columnName=new String[50];
		
		int i,j;
		for(i=0;i<100;i++)
			for(j=0;j<50;j++)
				columnData[i][j]=i+" "+j;
		for(j=0;j<50;j++)
		{
			columnName[j]=j+"列";
			DataJTableColumnName.add(columnName[j]);
		}
		GetColumnName(columnName);
		DefaultTableModel InformationDisplayJTableModel=new DefaultTableModel(columnData,columnName){
            public boolean isCellEditable(int row, int column)
            {
                return column!=0;
            }
        }; 
        jtInformationDisplayJTable=new JTable(InformationDisplayJTableModel);
		//DataJTableColumnName.add(jtInformationDisplayJTable.getColumnName());
		jtInformationDisplayJTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		jtInformationDisplayJTable.getTableHeader().setReorderingAllowed(false);
		
		
		jtInformationDisplayJTable.getModel().addTableModelListener(new TableModelListener(){
			
			 public void tableChanged(TableModelEvent e) {
			        int changedRow = e.getFirstRow();
			        int changedColumn = e.getColumn();
			        
			        int []SelectedRows=jtInformationDisplayJTable.getSelectedRows();
			        int i=0;
			        for(i=0;i<SelectedRows.length;i++)
			        	if(SelectedRows[i]==changedRow)
			        		break;
			        selectedDataList.get(i).set(changedColumn, jtInformationDisplayJTable.getValueAt(changedRow, changedColumn).toString());
			        
			        if(mutex)
			        	UpdataDetailedInformation();
			        else mutex=true;
			       
			    }
		});
		
		jtInformationDisplayJTable.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e)
			{
				if(MouseEvent.BUTTON1==e.getButton())
				{
					selectedDataList.clear();
					
					int []row= jtInformationDisplayJTable.getSelectedRows();
		            int column= jtInformationDisplayJTable.getColumnCount();
		            
		            int i,j;
		            int rowLength=row.length;
		           
		            for(i=0;i<rowLength;i++)
		            {
		            	ArrayList<String> selectedRowData=new  ArrayList<String>();
		            	
		            	for(j=0;j<column;j++)
		            	{
		            		selectedRowData.add(jtInformationDisplayJTable.getValueAt(row[i],j).toString());
		            	}
		            	
		            	selectedDataList.add(selectedRowData);
		            }
		            UpdataDetailedInformation();
		            
		            if(oldRow!=null)	           
		            {
		            	if(row.length>oldRow.length)
		            	{
		            		for(i=0;i<oldRow.length;i++)
		            			if(row[i]!=oldRow[i])
		            				break;
		            		
		            		jtpDetailedInformationJTabbedPane.setSelectedIndex(i);
		            	
		            	}
		            }
		            oldRow=new int [row.length];
		            oldRow=row;
		            return;
				}
			}
			public void mouseEntered(MouseEvent e){}
			public void mousePressed(MouseEvent e){}
			public void mouseReleased(MouseEvent e){}
			public void mouseExited(MouseEvent e){}
			
		});
		
		
		jspInformationDisplayJScrollPane=new JScrollPane(jtInformationDisplayJTable);
		Dimension scrSize=Toolkit.getDefaultToolkit().getScreenSize();
		jspInformationDisplayJScrollPane.setPreferredSize(
				new Dimension(scrSize.width/2-50,
						(int)(scrSize.height/2-50.0*scrSize.height/scrSize.width)));
		//jspInformationDisplayJScrollPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
	}
	
	class NewTabJPanel extends JPanel
	{

		private JTable jtData;
		
		public NewTabJPanel(String[][]Data,String[]columnName)
		{
			InitData(Data,columnName);
			
			super.add(jtData);
		}

		private void InitData(String[][]Data,String[]columnName)
		{
			DefaultTableModel InformationDisplayJTableModel=new DefaultTableModel(Data,columnName){
	            public boolean isCellEditable(int row, int column)
	            {
	                return column==1;
	            }
	        };
	        
	        InformationDisplayJTableModel.addTableModelListener(new TableModelListener(){
	        	public void tableChanged(TableModelEvent e) {
			        int changedRow = e.getFirstRow();
			        int changedColumn = e.getColumn();
			        int changedTab = jtpDetailedInformationJTabbedPane.getSelectedIndex();
			        int []changedTabRows= jtInformationDisplayJTable.getSelectedRows();
			        String value=new String(InformationDisplayJTableModel.getValueAt(changedRow, changedColumn).toString());
			       
			        mutex=false;
			        jtInformationDisplayJTable.setValueAt(value, changedTabRows[changedTab], changedRow);
			      			       
			    }
	        });
	        
			jtData=new JTable(InformationDisplayJTableModel);
			jtData.getTableHeader().setReorderingAllowed(false);
			
			jtData.getColumnModel().getColumn(1).setPreferredWidth(450);
		}
	}
}
