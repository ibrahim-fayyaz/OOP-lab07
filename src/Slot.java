public class Slot{

	private Parcel parcel;
	private String id;
	
	public Slot(String id , Parcel parcel){
		this.id = id;
		this.parcel = parcel;

	}

	public Slot(String id , FragileParcel parcel){
		this.id = id;
		this.parcel = parcel;

	}

	public String getId(){
		return id;
	}
	
	public Parcel getParcel(){
		return this.parcel;
	}

	public ParcelType getType(){
		return this.parcel.getType();
	}
		
	public boolean store(Parcel parcel){ 
		if(this.parcel == parcel) return false;
		if(this.parcel != null) return false;
		else 
			this.parcel = parcel;
			return true;
	}

	public Parcel remove(){
		this.parcel = null;
		return this.parcel;
	}
	
	public String toString(){
		if(this.parcel!=null){
			if(this.parcel.getStatus() == ParcelStatus.OUT_FOR_DELIVERY) return "[--]";
			if(this.parcel instanceof FragileParcel || this.parcel.getType() == ParcelType.FRAGILE) return "[F]";
			if(this.parcel instanceof Parcel) return "[R]";
			
		}
		
		return "[--]";

	}
 	


}