public class Rack{
	private Slot[][] slots ;
	private int[] rowlength;
	private String id;
	private int count;
	private int cap;

	Rack(String id , int[] rowlength){
		this.id = id ;
		this.rowlength = rowlength;
		slots = new Slot[this.rowlength.length][];
		for(int i = 0; i < rowlength.length;i++){
			slots[i] = new Slot[rowlength[i]];
		}
		
		for(int i = 0; i < slots.length ; i++){
			for(int j = 0; j < slots[i].length ; j++)
				slots[i][j] = new Slot(String.format("R%d-S%02d",i+1,j+1), null);
		}
	}
	
	public int getCapacity(){
		return cap;
	}
	
	public int getOccupiedCount(){
		return count;
	}

	public Slot getSlot(String id){
		for(int i = 0; i < slots.length ; i++)
			for(int j = 0; j < slots[i].length ; j++)
				if(slots[i][j].getId().equals(id)) 
					return slots[i][j];
		return null;
	}
	
	public Slot getSlot(int row, int col){
		return slots[row][col];
	}
	
	public int getRackSize(){
		return slots.length;
	}
	
	public int getRackSize(int i){
		return slots[i].length;
	}
	
	public String getId(){
		return id;
	}
	
	public Slot getSlotById(String id){
		for(int i = 0; i < slots.length ; i++){
			for(int j = 0; j < slots[i].length ; j++)
				if(slots[i][j].equals(id)) return slots[i][j];

		}
		return null;

	}
	
	public void printLayout(){
		for(int i = 0; i < slots.length ; i++){
			for(int j = 0; j < slots[i].length ; j++){
				System.out.print(slots[i][j]);
			}
			System.out.println();
		}

	}

	public Parcel[] getParcelsByType(ParcelType type){
		
		int count = 0;
		for(int i = 0; i < slots.length ; i++){
			for(int j = 0; j < slots[i].length ; j++){
				if(slots[i][j].getParcel() != null && slots[i][j].getType().equals(type))
					count++;
		
			}

		}
		
		Parcel[] parcels = new Parcel[count];
		int index = 0;
	
		for(int i = 0; i < slots.length ; i++){
			for(int j = 0; j < slots[i].length ; j++){
				if(slots[i][j].getParcel() != null && slots[i][j].getType().equals(type))
					parcels[index++] = slots[i][j].getParcel();
		
			}

		}
		return parcels;
		
	}

	public void report(){
		for(int i = 0; i < slots.length ; i++){
			for(int j = 0; j < slots[i].length ; j++){
				cap++;
				if(slots[i][j].getParcel() != null){
					count++;
				}
			}	
		}
		System.out.printf("Capacity=%d, Occupied=%d%n",cap,count);
	}

	


}