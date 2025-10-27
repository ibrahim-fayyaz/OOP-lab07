public class Depot{
	private Rack racks[];
	private String name;
	private int count;
	
		

	public Depot(String n, int s){
		name = n;
		racks = new Rack[s];
	}

	public int[] getTotals(){
		int c = 0;
		int p = 0;
		int[] arr = new int[count*2];
		
		for(int i = 0;i < count; i++){
			p = racks[i].getCapacity();
			c = racks[i].getOccupiedCount();
			arr[i] = p;
			arr[i+1] = c;
		}

		return arr;
		

	}

	public void addRack(Rack rack){
		if(count <= racks.length) racks[count++] = rack;
		else System.out.println("No more space left! Increase the Depot's racks size.");	
	}

	public String store(String slotId , Parcel p){
		Slot s = null;
		for(int i = 0;i < count; i++){
				s = racks[i].getSlot(slotId);
				if( s.store(p)) return "true";
		}
		return "false";
		

	}

	public Parcel remove(String slotId){
		Slot s = null;
		for(int i = 0;i < count; i++){
			if(racks[i].getCapacity() > racks[i].getOccupiedCount()){
				s = racks[i].getSlot(slotId);
				break;
			}
		}
	
		Parcel p = s.getParcel();
		p.setStatus(ParcelStatus.OUT_FOR_DELIVERY);
		return p;
	
		

	}

	public void removeRack(String id){
		for(int i = 0;i < count; i++){
			if(racks[i].getId().equals(id)){
				for(int j = i; j < count; j++){
					racks[j] = racks[j+1];
				}
				racks[i] = null;
				count--;
			}
		}
	}
		
	public void printAllLayouts(){
		int occ = 0;
		int cap = 0;
		for(int i = 0;i < count; i++){
			racks[i].printLayout();
			racks[i].report();
			cap += racks[i].getCapacity();
			occ += racks[i].getOccupiedCount();
		}
		System.out.printf("Totals for %s Depot: Capacity=%d, Occupied=%d%n", name, cap, occ);
	}
		
	public String findFirstEmptySlot(){
		String n = null;
		for(int i = 0;i < count; i++){
			if(racks[i].getCapacity() > racks[i].getOccupiedCount()){
				for(int j = 0; j < racks[i].getRackSize() ; j++)
					for(int k = 0; k < racks[i].getRackSize(i) ; k++)
						if(!racks[i].getSlot(j,k).equals("[--]"))
								return racks[i].getSlot(j,k).getId();
			}
		}
		return "None Available";

	}

}