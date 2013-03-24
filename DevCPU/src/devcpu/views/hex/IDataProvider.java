package devcpu.views.hex;

public interface IDataProvider {
	
	public void setWordsPerRow(int bpr);
	public int getRowCount();
	public int getDataSize();
	public String getRowDescriptor(int rowNumber);
	public int getData(Character[] arr, int rowNumber);
	
}
