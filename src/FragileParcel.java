public class FragileParcel extends Parcel{
	
	private boolean flag;
	
	public FragileParcel(String track , ParcelType type){
		super(track, type);
		this.flag = true;
	}
	
	public void setFlag(boolean flag){
		this.flag = flag;
	}

}