public class Parcel{

	private String track;
	private ParcelType type;
	private int trackCount;
	private ParcelStatus status;


	public Parcel(String track , ParcelType type){
		this.track = track;
		this.type = type;
		this.status = ParcelStatus.IN_STORAGE;
	}

	public void setType(ParcelType type){
		this.type = type;
	}
	
	public ParcelStatus getStatus(){
		return status;
	}
	
	public ParcelType getType(){
		return this.type;
	}

	public void setStatus(ParcelStatus status){
		if(this.status.equals(status)) System.out.println("Error! The Status is already the same");
		else this.status = status;
	}

	public String toString(){
		return String.format("[TRACK CODE: %s, TYPE: %s, STATUS: %s]",track , type, status);
	}

}